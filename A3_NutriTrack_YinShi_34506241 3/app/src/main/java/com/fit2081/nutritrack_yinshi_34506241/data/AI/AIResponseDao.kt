package com.fit2081.nutritrack_yinshi_34506241.data.AI

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AIResponseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAIResponse(aiResponse: AIResponse)

    @Query("SELECT * FROM ai_response WHERE userId = :userId ORDER BY dateTime DESC")
    fun getAIResponsesOrderDateTime(userId: String): Flow<List<AIResponse>>

    @Query("SELECT * FROM ai_response WHERE userId = :userId ORDER BY id DESC")
    fun getAIResponsesOrderId(userId: String): Flow<List<AIResponse>>

    @Delete
    suspend fun deleteAIResponse(aiResponse: AIResponse)

}