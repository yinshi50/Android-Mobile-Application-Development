package com.fit2081.nutritrack_yinshi_34506241.data.Questionnaire

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import com.fit2081.nutritrack_yinshi_34506241.data.User.User

@Entity(
    tableName = "food_questionnaire",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["questionnaireId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class QuestionnaireAnswers(
    @PrimaryKey
    @ColumnInfo(name = "questionnaireId")
    val id: String,

    val firstPartResult: String,

    val thirdPartResult: String,

    val fourthPartResult: String,
)
