package com.fit2081.nutritrack_yinshi_34506241.data.Repository

import android.content.Context
import com.fit2081.nutritrack_yinshi_34506241.R
import com.fit2081.nutritrack_yinshi_34506241.data.User.User
import com.fit2081.nutritrack_yinshi_34506241.data.User.UserDatabase
import com.fit2081.nutritrack_yinshi_34506241.data.login.initializeUserData

class UserDatabaseRepository (context: Context){
    private val UserDao = UserDatabase.getDatabase(context).userDao()

    private val userDataFileName = context.getString(R.string.user_csv)

    fun getAllUsers() = UserDao.getAllUsers()

    suspend fun getUserById(id: String) = UserDao.getUserById(id)

    suspend fun insertUser(user: User) = UserDao.insertUser(user)

    suspend fun insertAll(users: List<User>) = UserDao.insertAll(users)

    suspend fun deleteUser(user: User) = UserDao.deleteUser(user)

    suspend fun deleteAllUsers() = UserDao.deleteAllUsers()

    suspend fun updateUser(user: User) = UserDao.updateUser(user)

    suspend fun initUser(fileName: String = userDataFileName, context: Context): List<User> = initializeUserData(fileName, context)

    suspend fun getUserByPhoneNumber(phoneNumber: String) = UserDao.getUserByPhoneNumber(phoneNumber)

    suspend fun getAllUsersOnce(): List<User> = UserDao.getAllUsersOnce()

    suspend fun updateUserPassword(uid: String, newPassword: String) = UserDao.updateUserPassword(uid, newPassword)

    suspend fun updateUserQuestionnaireProcess(uid: String, questionnaireProcess: Boolean) = UserDao.updateUserQuestionnaireProcess(uid, questionnaireProcess)

    suspend fun getMaleAverageScore() = UserDao.getMaleAverageScore()

    suspend fun getFemaleAverageScore() = UserDao.getFemaleAverageScore()

//    suspend fun getUserTotalScore(uid: String) = UserDao.getUserTotalScore(uid)
//
//    suspend fun getUserScore(uid: String) = UserDao.getUserScore(uid)
}