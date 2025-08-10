package com.fit2081.nutritrack_yinshi_34506241.data.AI

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.fit2081.nutritrack_yinshi_34506241.data.User.User
import com.fit2081.nutritrack_yinshi_34506241.functions.getCurrentFormattedDateTime

@Entity(
    tableName = "ai_response",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("id")]
)
data class AIResponse(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: String,
    val promptTips: String,
    val promptFeedback: String,
    val tip: String,
    val feedback: String,
    val dateTime: String = getCurrentFormattedDateTime()
)
