package com.fit2081.nutritrack_yinshi_34506241.data.Repository

import android.content.Context
import com.fit2081.nutritrack_yinshi_34506241.data.Questionnaire.QuestionnaireAnswers
import com.fit2081.nutritrack_yinshi_34506241.data.User.UserDatabase

class QuestionnaireRepository(context: Context) {
    private val questionnaireDao = UserDatabase.getDatabase(context).questionnaireDao()

    suspend fun insertQuestionnaire(questionnaire: QuestionnaireAnswers) {
        questionnaireDao.insertQuestionnaire(questionnaire)
    }

    suspend fun getQuestionnaireById(id: String): QuestionnaireAnswers? {
        return questionnaireDao.getQuestionnaireById(id)
    }


    suspend fun deleteQuestionnaire(questionnaire: QuestionnaireAnswers) {
        questionnaireDao.deleteQuestionnaire(questionnaire)
    }

    suspend fun updateQuestionnaire(questionnaire: QuestionnaireAnswers) {
        questionnaireDao.updateQuestionnaire(questionnaire)
    }
}