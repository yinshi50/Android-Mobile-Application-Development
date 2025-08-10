package com.fit2081.nutritrack_yinshi_34506241.data.Questionnaire

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuestionnaireDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestionnaire(questionnaire: QuestionnaireAnswers)

    @Query("SELECT * FROM food_questionnaire WHERE questionnaireId = :id")
    suspend fun getQuestionnaireById(id: String): QuestionnaireAnswers?

    @Delete
    suspend fun deleteQuestionnaire(questionnaire: QuestionnaireAnswers)

    @Update
    suspend fun updateQuestionnaire(questionnaire: QuestionnaireAnswers)


}