package com.fit2081.nutritrack_yinshi_34506241.data.User

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.fit2081.nutritrack_yinshi_34506241.data.AI.AIResponse
import com.fit2081.nutritrack_yinshi_34506241.data.AI.AIResponseDao
import com.fit2081.nutritrack_yinshi_34506241.data.Questionnaire.QuestionnaireAnswers
import com.fit2081.nutritrack_yinshi_34506241.data.Questionnaire.QuestionnaireDao

@Database (
    entities = [User::class, QuestionnaireAnswers::class, AIResponse::class],
    version = 1,
    exportSchema = true,
)

abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun questionnaireDao(): QuestionnaireDao
    abstract fun aiResponseDao(): AIResponseDao


    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build().also { INSTANCE = it}
            }
        }
    }


}