package com.fit2081.nutritrack_yinshi_34506241.data.Repository

import android.content.Context
import com.fit2081.nutritrack_yinshi_34506241.data.AI.AIResponse
import com.fit2081.nutritrack_yinshi_34506241.data.User.UserDatabase

class AIResponseRepository(private val applicationContext: Context) {
    private val aiResponseDao = UserDatabase.getDatabase(applicationContext).aiResponseDao()

    suspend fun insertAIResponse(aiResponse: AIResponse) {
        aiResponseDao.insertAIResponse(aiResponse)
    }
    fun getAIResponsesById(id: String) = aiResponseDao.getAIResponsesOrderId(id)

    suspend fun deleteAIResponse(aiResponse: AIResponse) {
        aiResponseDao.deleteAIResponse(aiResponse)
    }

    fun getAIResponsesByDateTime(id: String) = aiResponseDao.getAIResponsesOrderDateTime(id)

}