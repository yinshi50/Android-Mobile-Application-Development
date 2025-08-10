package com.fit2081.nutritrack_yinshi_34506241.data.User

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    var phoneNumber: String,

    val sex: String,

    val HEIFAtotalscore: Double,

    val DiscretionaryHEIFAscore: Double,

    val Discretionaryservesize: Double,

    val VegetablesHEIFAscore: Double,

    val Vegetableswithlegumesallocatedservesize: Double,

    val LegumesallocatedVegetables: Double,

    val Vegetablesvariationsscore: Double,

    val VegetablesCruciferous: Double,

    val VegetablesTuberandbulb: Double,

    val VegetablesOther: Double,

    val Legumes: Double,

    val VegetablesGreen: Double,

    var VegetablesRedandorange: Double,

    val FruitHEIFAscore: Double,

    val Fruitserversize: Double,

    val Fruitvariationsscore: Double,

    val FruitPome: Double,

    val FruitTropicalandsubtropical: Double,

    val FruitBerry: Double,

    val FruitStone: Double,

    val FruitCitrus: Double,

    val FruitOther: Double,

    var GrainsandcerealsHEIFAscore: Double,

    var Grainsandcerealsservesize: Double,

    val GrainsandcerealsNonwholegrains: Double,

    val WholegrainsHEIFAscore: Double,

    val Wholegrainsservesize: Double,

    val MeatandalternativesHEIFAscore: Double,

    val Meatandalternativeswithlegumesallocatedservesize: Double,

    val LegumesallocatedMeatandalternatives: Double,

    val DairyandalternativesHEIFAscore: Double,

    val Dairyandalternativesservesize: Double,

    val SodiumHEIFAscore: Double,

    val Sodiummgmilligrams: Double,

    val AlcoholHEIFAscore: Double,

    val Alcoholstandarddrinks: Double,

    val WaterHEIFAscore: Double,

    val Water: Double,

    val WaterTotalmL: Double,

    val BeverageTotalmL: Double,

    val SugarHEIFAscore: Double,

    val Sugar: Double,

    val SaturatedFatHEIFAscore: Double,

    val SaturatedFat: Double,

    val UnsaturatedFatHEIFAscore: Double,

    val UnsaturatedFatservesize: Double,

    val questionnaire: Boolean = false,

    val password: String? = null
)