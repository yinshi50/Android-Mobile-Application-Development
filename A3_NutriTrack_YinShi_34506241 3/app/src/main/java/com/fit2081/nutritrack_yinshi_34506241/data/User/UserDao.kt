package com.fit2081.nutritrack_yinshi_34506241.data.User

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAllUsers()

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUserById(id: String): User?

    @Query("SELECT * FROM user WHERE phoneNumber = :phoneNumber")
    suspend fun getUserByPhoneNumber(phoneNumber: String): User?

    @Query("SELECT * FROM user")
    suspend fun getAllUsersOnce(): List<User>

    @Query("UPDATE user SET password = :newPassword WHERE id = :uid")
    suspend fun updateUserPassword(uid: String, newPassword: String)

    @Query("UPDATE user SET questionnaire = :questionnaireProcess WHERE id = :uid")
    suspend fun updateUserQuestionnaireProcess(uid: String, questionnaireProcess: Boolean)

    @Query("SELECT AVG(HEIFAtotalscore) AS average_score FROM user WHERE sex = 'Male'")
    suspend fun getMaleAverageScore(): Double

    @Query("SELECT AVG(HEIFAtotalscore) AS average_score FROM user WHERE sex = 'Female'")
    suspend fun getFemaleAverageScore(): Double



//    @Query("Select HEIFAtotalscore from user where id = :uid")
//    suspend fun getUserTotalScore(uid: String): Double
//
//    @Query("Select VegetablesHEIFAscore, FruitHEIFAscore, GrainsandcerealsHEIFAscore, WholegrainsHEIFAscore, MeatandalternativesHEIFAscore, DairyandalternativesHEIFAscore, WaterHEIFAscore, UnsaturatedFatHEIFAscore, SodiumHEIFAscore, SugarHEIFAscore, AlcoholHEIFAscore, DiscretionaryHEIFAscore from user where id = :uid")
//    suspend fun getUserScore(uid: String): List<Double>


}