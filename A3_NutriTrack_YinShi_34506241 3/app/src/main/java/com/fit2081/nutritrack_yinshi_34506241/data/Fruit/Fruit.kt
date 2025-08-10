package com.fit2081.nutritrack_yinshi_34506241.data.Fruit

import androidx.room.Entity
import androidx.room.PrimaryKey


data class FruitResponse(
    val name: String,
    val id: Int,
    val family: String,
    val order: String,
    val genus: String,
    val nutritions: Nutrition
)
