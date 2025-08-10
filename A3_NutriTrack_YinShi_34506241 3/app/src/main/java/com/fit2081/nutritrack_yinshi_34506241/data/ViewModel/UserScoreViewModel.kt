package com.fit2081.nutritrack_yinshi_34506241.data.ViewModel

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableDoubleStateOf
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

class UserScoreViewModel (context: Context): ViewModel(){
    private val userRepository = UserDatabaseRepository(context)

    val allUsers = userRepository.getAllUsers().
    stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        emptyList()
    )

    private val _totalScore = mutableDoubleStateOf(0.0)
    val totalScore: State<Double> = _totalScore

    fun getTotalScore(uid: String) = viewModelScope.launch(Dispatchers.IO) {
        val user = userRepository.getUserById(uid)
        if (user != null) {
            withContext(Dispatchers.Main){
                _totalScore.doubleValue = user.HEIFAtotalscore
            }
        }
    }

    private val _otherScore = mutableStateOf(listOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0))
    val otherScore: State<List<Double>> = _otherScore

    fun getOtherScore(uid: String) = viewModelScope.launch(Dispatchers.IO) {
        val user = userRepository.getUserById(uid)
        if (user != null) {
            withContext(Dispatchers.Main) {
                _otherScore.value = listOf(
                    user.VegetablesHEIFAscore ,
                    user.FruitHEIFAscore ,
                    user.GrainsandcerealsHEIFAscore ,
                    user.WholegrainsHEIFAscore ,
                    user.MeatandalternativesHEIFAscore ,
                    user.DairyandalternativesHEIFAscore ,
                    user.WaterHEIFAscore ,
                    user.UnsaturatedFatHEIFAscore ,
                    user.SodiumHEIFAscore ,
                    user.SugarHEIFAscore ,
                    user.AlcoholHEIFAscore ,
                    user.DiscretionaryHEIFAscore
                )
            }
        }
    }

    private val _user = mutableStateOf<User?>(null)
    val user: State<User?> = _user
    fun getUserById(id: String) = viewModelScope.launch(Dispatchers.IO) {
        _user.value = userRepository.getUserById(id)
    }

    private val _maleAverageScore = mutableDoubleStateOf(0.0)
    val maleAverageScore: State<Double> = _maleAverageScore
    fun getMaleAverageScore() = viewModelScope.launch(Dispatchers.IO) {
        val maleScore = userRepository.getMaleAverageScore()
        withContext(Dispatchers.Main) {
            _maleAverageScore.doubleValue = maleScore
        }
    }

    private val _femaleAverageScore = mutableDoubleStateOf(0.0)
    val femaleAverageScore: State<Double> = _femaleAverageScore
    fun getFemaleAverageScore() = viewModelScope.launch(Dispatchers.IO) {
        val femaleScore = userRepository.getFemaleAverageScore()
        withContext(Dispatchers.Main) {
            _femaleAverageScore.doubleValue = femaleScore
        }
    }

    class UserScoreViewModelFactory(context: Context): ViewModelProvider.Factory {
        private val context = context.applicationContext
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            UserScoreViewModel(context) as T
    }
}