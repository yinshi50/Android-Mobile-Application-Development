package com.fit2081.nutritrack_yinshi_34506241.data.ViewModel

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.fit2081.nutritrack_yinshi_34506241.data.User.User
import com.fit2081.nutritrack_yinshi_34506241.data.Repository.UserDatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserLoginViewModel(context: Context): ViewModel() {
    private val userRepository = UserDatabaseRepository(context)

    val allUsers = userRepository.getAllUsers().
    stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        emptyList()
    )

    init{
        initUser(context)
    }

    private fun initUser(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val existingUsers = userRepository.getAllUsersOnce() // Get current users one time

            if (existingUsers.isEmpty()) {
                val listOfUsers = userRepository.initUser(context = context)
                insertAll(listOfUsers)
            }
        }
    }

    private val _user = mutableStateOf<User?>(null)
    val user: State<User?> = _user
    fun getUserById(id: String) = viewModelScope.launch(Dispatchers.IO) {
        _user.value = userRepository.getUserById(id)
    }

    fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.insertUser(user)
    }

    fun insertAll(users: List<User>) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.insertAll(users)
    }

    fun deleteUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.deleteUser(user)
    }

    fun deleteAllUsers() = viewModelScope.launch(Dispatchers.IO) {
        userRepository.deleteAllUsers()
    }

    fun updateUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.updateUser(user)
    }

    fun updateUserPassword(uid: String, newPassword: String) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.updateUserPassword(uid, newPassword)
    }

    fun updateUserQuestionnaireProcess(uid: String, questionnaireProcess: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.updateUserQuestionnaireProcess(uid, questionnaireProcess)
    }

    private val _userIDError = mutableStateOf(Pair(true, "Valid ID."))
    val userIDError: State<Pair<Boolean, String>> = _userIDError

    fun checkUserID(userID: String) {
        viewModelScope.launch (Dispatchers.IO){
            val user = userRepository.getUserById(userID)
            val result = if (user != null) {
                Pair(true, "Valid ID.")
            } else {
                Pair(false, "Invalid ID.")
            }

            withContext(Dispatchers.Main) {
                _userIDError.value = result
            }

        }
    }

    private val _userPhoneNumberError = mutableStateOf(Pair(true, "Valid Phone Number."))
    val userPhoneNumberError: State<Pair<Boolean, String>> = _userPhoneNumberError

    fun checkUserPhoneNumber(phoneNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepository.getUserByPhoneNumber(phoneNumber)
            val result = if (user != null) {
                Pair(true, "Valid Phone Number.")
            } else {
                Pair(false, "Invalid Phone Number.")
            }
            withContext(Dispatchers.Main) {
                _userPhoneNumberError.value = result
            }

        }
    }

    private val _loginResult = mutableStateOf<Pair<Boolean, String>>(Pair(false, "Invalid user."))
    val loginResult: State<Pair<Boolean, String>> = _loginResult

    fun checkLogin(userID: String, userPassword: String?) {
        viewModelScope.launch(Dispatchers.IO){
            val user = userRepository.getUserById(userID)
            val result = if (user != null) {
                if (user.password == userPassword) {
                    Pair(true, "Valid user.")
                } else{
                    if (userPassword == null) {
                        Pair(false, "Please register first.")
                    } else{
                        Pair(false, "Invalid password.")
                    }
                }
            } else{
                Pair(false, "Invalid username.")
            }
            withContext(Dispatchers.Main) {
                _loginResult.value = result
            }
        }
    }

    private val _registrationResult = mutableStateOf<Pair<Boolean, String>>(Pair(false, "Invalid user."))
    val registrationResult: State<Pair<Boolean, String>> = _registrationResult

    fun registerUser(userId: String, phone: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepository.getUserById(userId)
            val result = if (user != null) {
                if (user.phoneNumber == phone) {
                    if (user.password == null) Pair(true, "Valid user.")
                    else Pair(false, "Please use your previous password to login.")
                } else Pair(false, "Invalid phone number.")
            } else {
                Pair(false, "Invalid user.")
            }
            withContext(Dispatchers.Main) {
                _registrationResult.value = result
            }
        }
    }

    class UserLoginFactory(context: Context): ViewModelProvider.Factory {
        private val context = context.applicationContext
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            UserLoginViewModel(context) as T
    }
}