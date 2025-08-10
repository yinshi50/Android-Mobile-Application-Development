package com.fit2081.nutritrack_yinshi_34506241.data.login

import android.content.Context
import com.fit2081.nutritrack_yinshi_34506241.data.User.User
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


//@Composable
//fun ImportData(
//    userViewModel: UserDatabaseViewModel = viewModel(),
//    fileName: String,
//    context: Context
//){
//    val prefs = context.getSharedPreferences("init", Context.MODE_PRIVATE)
//    val alreadyImported = prefs.getBoolean("data_imported", false)
//    val sign = remember { mutableStateOf("") }
//    if (!alreadyImported) {
//        sign.value = initializeUserData(userViewModel, fileName, context)
//        prefs.edit().putBoolean("data_imported", true).apply()
//    }
//}


suspend fun initializeUserData(
    fileName: String,
    context: Context
): List<User> = withContext(Dispatchers.IO) {
    try {
        val asset = context.assets
        val inputStream = asset.open(fileName)
        val reader = BufferedReader(InputStreamReader(inputStream))

        val userList = mutableListOf<User>()

        val linesList = reader.useLines { it.toList() }
        val titleList = linesList.first().split(",")
        val sex = titleList.indexOf("Sex")
        val listOfTotalScoreIndexMale = listOf (
            titleList.indexOf("VegetablesHEIFAscoreMale"),
            titleList.indexOf("FruitHEIFAscoreMale"),
            titleList.indexOf("GrainsandcerealsHEIFAscoreMale"),
            titleList.indexOf("WholegrainsHEIFAscoreMale"),
            titleList.indexOf("MeatandalternativesHEIFAscoreMale"),
            titleList.indexOf("DairyandalternativesHEIFAscoreMale"),
            titleList.indexOf("WaterHEIFAscoreMale"),
            titleList.indexOf("UnsaturatedFatHEIFAscoreMale"),
            titleList.indexOf("SodiumHEIFAscoreMale"),
            titleList.indexOf("SugarHEIFAscoreMale"),
            titleList.indexOf("AlcoholHEIFAscoreMale"),
            titleList.indexOf("DiscretionaryHEIFAscoreMale")
        )
        val listOfMaleDataFormat = listOf(
            titleList.indexOf("PhoneNumber"),
            titleList.indexOf("User_ID"),
            titleList.indexOf("Sex"),
            titleList.indexOf("HEIFAtotalscoreMale"),
            titleList.indexOf("DiscretionaryHEIFAscoreMale"),
            titleList.indexOf("Discretionaryservesize"),
            titleList.indexOf("VegetablesHEIFAscoreMale"),
            titleList.indexOf("Vegetableswithlegumesallocatedservesize"),
            titleList.indexOf("LegumesallocatedVegetables"),
            titleList.indexOf("Vegetablesvariationsscore"),
            titleList.indexOf("VegetablesCruciferous"),
            titleList.indexOf("VegetablesTuberandbulb"),
            titleList.indexOf("VegetablesOther"),
            titleList.indexOf("Legumes"),
            titleList.indexOf("VegetablesGreen"),
            titleList.indexOf("VegetablesRedandorange"),
            titleList.indexOf("FruitHEIFAscoreMale"),
            titleList.indexOf("Fruitservesize"),
            titleList.indexOf("Fruitvariationsscore"),
            titleList.indexOf("FruitPome"),
            titleList.indexOf("FruitTropicalandsubtropical"),
            titleList.indexOf("FruitBerry"),
            titleList.indexOf("FruitStone"),
            titleList.indexOf("FruitCitrus"),
            titleList.indexOf("FruitOther"),
            titleList.indexOf("GrainsandcerealsHEIFAscoreMale"),
            titleList.indexOf("Grainsandcerealsservesize"),
            titleList.indexOf("GrainsandcerealsNonwholegrains"),
            titleList.indexOf("WholegrainsHEIFAscoreMale"),
            titleList.indexOf("Wholegrainsservesize"),
            titleList.indexOf("MeatandalternativesHEIFAscoreMale"),
            titleList.indexOf("Meatandalternativeswithlegumesallocatedservesize"),
            titleList.indexOf("LegumesallocatedMeatandalternatives"),
            titleList.indexOf("DairyandalternativesHEIFAscoreMale"),
            titleList.indexOf("Dairyandalternativesservesize"),
            titleList.indexOf("SodiumHEIFAscoreMale"),
            titleList.indexOf("Sodiummgmilligrams"),
            titleList.indexOf("AlcoholHEIFAscoreMale"),
            titleList.indexOf("Alcoholstandarddrinks"),
            titleList.indexOf("WaterHEIFAscoreMale"),
            titleList.indexOf("Water"),
            titleList.indexOf("WaterTotalmL"),
            titleList.indexOf("BeverageTotalmL"),
            titleList.indexOf("SugarHEIFAscoreMale"),
            titleList.indexOf("Sugar"),
            titleList.indexOf("SaturatedFatHEIFAscoreMale"),
            titleList.indexOf("SaturatedFat"),
            titleList.indexOf("UnsaturatedFatHEIFAscoreMale"),
            titleList.indexOf("UnsaturatedFatservesize"),
        )

        val listOfFemaleDataFormat = listOf(
            titleList.indexOf("PhoneNumber"),
            titleList.indexOf("User_ID"),
            titleList.indexOf("Sex"),
            titleList.indexOf("HEIFAtotalscoreFemale"),
            titleList.indexOf("DiscretionaryHEIFAscoreFemale"),
            titleList.indexOf("Discretionaryservesize"),
            titleList.indexOf("VegetablesHEIFAscoreFemale"),
            titleList.indexOf("Vegetableswithlegumesallocatedservesize"),
            titleList.indexOf("LegumesallocatedVegetables"),
            titleList.indexOf("Vegetablesvariationsscore"),
            titleList.indexOf("VegetablesCruciferous"),
            titleList.indexOf("VegetablesTuberandbulb"),
            titleList.indexOf("VegetablesOther"),
            titleList.indexOf("Legumes"),
            titleList.indexOf("VegetablesGreen"),
            titleList.indexOf("VegetablesRedandorange"),
            titleList.indexOf("FruitHEIFAscoreFemale"),
            titleList.indexOf("Fruitservesize"),
            titleList.indexOf("Fruitvariationsscore"),
            titleList.indexOf("FruitPome"),
            titleList.indexOf("FruitTropicalandsubtropical"),
            titleList.indexOf("FruitBerry"),
            titleList.indexOf("FruitStone"),
            titleList.indexOf("FruitCitrus"),
            titleList.indexOf("FruitOther"),
            titleList.indexOf("GrainsandcerealsHEIFAscoreFemale"),
            titleList.indexOf("Grainsandcerealsservesize"),
            titleList.indexOf("GrainsandcerealsNonwholegrains"),
            titleList.indexOf("WholegrainsHEIFAscoreFemale"),
            titleList.indexOf("Wholegrainsservesize"),
            titleList.indexOf("MeatandalternativesHEIFAscoreFemale"),
            titleList.indexOf("Meatandalternativeswithlegumesallocatedservesize"),
            titleList.indexOf("LegumesallocatedMeatandalternatives"),
            titleList.indexOf("DairyandalternativesHEIFAscoreFemale"),
            titleList.indexOf("Dairyandalternativesservesize"),
            titleList.indexOf("SodiumHEIFAscoreFemale"),
            titleList.indexOf("Sodiummgmilligrams"),
            titleList.indexOf("AlcoholHEIFAscoreFemale"),
            titleList.indexOf("Alcoholstandarddrinks"),
            titleList.indexOf("WaterHEIFAscoreFemale"),
            titleList.indexOf("Water"),
            titleList.indexOf("WaterTotalmL"),
            titleList.indexOf("BeverageTotalmL"),
            titleList.indexOf("SugarHEIFAscoreFemale"),
            titleList.indexOf("Sugar"),
            titleList.indexOf("SaturatedFatHEIFAscoreFemale"),
            titleList.indexOf("SaturatedFat"),
            titleList.indexOf("UnsaturatedFatHEIFAscoreFemale"),
            titleList.indexOf("UnsaturatedFatservesize"),

            )

        for (line in linesList.drop(1)){
            val value = line.split(",")
            if (value[sex] == "Male") {
                userList.add(
                    User(
                        value[listOfMaleDataFormat[1]],
                        value[listOfMaleDataFormat[0]],
                        value[listOfMaleDataFormat[2]],
                        value[listOfMaleDataFormat[3]].toDouble(),
                        value[listOfMaleDataFormat[4]].toDouble(),
                        value[listOfMaleDataFormat[5]].toDouble(),
                        value[listOfMaleDataFormat[6]].toDouble(),
                        value[listOfMaleDataFormat[7]].toDouble(),
                        value[listOfMaleDataFormat[8]].toDouble(),
                        value[listOfMaleDataFormat[9]].toDouble(),
                        value[listOfMaleDataFormat[10]].toDouble(),
                        value[listOfMaleDataFormat[11]].toDouble(),
                        value[listOfMaleDataFormat[12]].toDouble(),
                        value[listOfMaleDataFormat[13]].toDouble(),
                        value[listOfMaleDataFormat[14]].toDouble(),
                        value[listOfMaleDataFormat[15]].toDouble(),
                        value[listOfMaleDataFormat[16]].toDouble(),
                        value[listOfMaleDataFormat[17]].toDouble(),
                        value[listOfMaleDataFormat[18]].toDouble(),
                        value[listOfMaleDataFormat[19]].toDouble(),
                        value[listOfMaleDataFormat[20]].toDouble(),
                        value[listOfMaleDataFormat[21]].toDouble(),
                        value[listOfMaleDataFormat[22]].toDouble(),
                        value[listOfMaleDataFormat[23]].toDouble(),
                        value[listOfMaleDataFormat[24]].toDouble(),
                        value[listOfMaleDataFormat[25]].toDouble(),
                        value[listOfMaleDataFormat[26]].toDouble(),
                        value[listOfMaleDataFormat[27]].toDouble(),
                        value[listOfMaleDataFormat[28]].toDouble(),
                        value[listOfMaleDataFormat[29]].toDouble(),
                        value[listOfMaleDataFormat[30]].toDouble(),
                        value[listOfMaleDataFormat[31]].toDouble(),
                        value[listOfMaleDataFormat[32]].toDouble(),
                        value[listOfMaleDataFormat[33]].toDouble(),
                        value[listOfMaleDataFormat[34]].toDouble(),
                        value[listOfMaleDataFormat[35]].toDouble(),
                        value[listOfMaleDataFormat[36]].toDouble(),
                        value[listOfMaleDataFormat[37]].toDouble(),
                        value[listOfMaleDataFormat[38]].toDouble(),
                        value[listOfMaleDataFormat[39]].toDouble(),
                        value[listOfMaleDataFormat[40]].toDouble(),
                        value[listOfMaleDataFormat[41]].toDouble(),
                        value[listOfMaleDataFormat[42]].toDouble(),
                        value[listOfMaleDataFormat[43]].toDouble(),
                        value[listOfMaleDataFormat[44]].toDouble(),
                        value[listOfMaleDataFormat[45]].toDouble(),
                        value[listOfMaleDataFormat[46]].toDouble(),
                        value[listOfMaleDataFormat[47]].toDouble(),
                        value[listOfMaleDataFormat[48]].toDouble(),
                    )
                )
            } else {
                userList.add(
                    User(
                        value[listOfFemaleDataFormat[1]],
                        value[listOfFemaleDataFormat[0]],
                        value[listOfFemaleDataFormat[2]],
                        value[listOfFemaleDataFormat[3]].toDouble(),
                        value[listOfFemaleDataFormat[4]].toDouble(),
                        value[listOfFemaleDataFormat[5]].toDouble(),
                        value[listOfFemaleDataFormat[6]].toDouble(),
                        value[listOfFemaleDataFormat[7]].toDouble(),
                        value[listOfFemaleDataFormat[8]].toDouble(),
                        value[listOfFemaleDataFormat[9]].toDouble(),
                        value[listOfFemaleDataFormat[10]].toDouble(),
                        value[listOfFemaleDataFormat[11]].toDouble(),
                        value[listOfFemaleDataFormat[12]].toDouble(),
                        value[listOfFemaleDataFormat[13]].toDouble(),
                        value[listOfFemaleDataFormat[14]].toDouble(),
                        value[listOfFemaleDataFormat[15]].toDouble(),
                        value[listOfFemaleDataFormat[16]].toDouble(),
                        value[listOfFemaleDataFormat[17]].toDouble(),
                        value[listOfFemaleDataFormat[18]].toDouble(),
                        value[listOfFemaleDataFormat[19]].toDouble(),
                        value[listOfFemaleDataFormat[20]].toDouble(),
                        value[listOfFemaleDataFormat[21]].toDouble(),
                        value[listOfFemaleDataFormat[22]].toDouble(),
                        value[listOfFemaleDataFormat[23]].toDouble(),
                        value[listOfFemaleDataFormat[24]].toDouble(),
                        value[listOfFemaleDataFormat[25]].toDouble(),
                        value[listOfFemaleDataFormat[26]].toDouble(),
                        value[listOfFemaleDataFormat[27]].toDouble(),
                        value[listOfFemaleDataFormat[28]].toDouble(),
                        value[listOfFemaleDataFormat[29]].toDouble(),
                        value[listOfFemaleDataFormat[30]].toDouble(),
                        value[listOfFemaleDataFormat[31]].toDouble(),
                        value[listOfFemaleDataFormat[32]].toDouble(),
                        value[listOfFemaleDataFormat[33]].toDouble(),
                        value[listOfFemaleDataFormat[34]].toDouble(),
                        value[listOfFemaleDataFormat[35]].toDouble(),
                        value[listOfFemaleDataFormat[36]].toDouble(),
                        value[listOfFemaleDataFormat[37]].toDouble(),
                        value[listOfFemaleDataFormat[38]].toDouble(),
                        value[listOfFemaleDataFormat[39]].toDouble(),
                        value[listOfFemaleDataFormat[40]].toDouble(),
                        value[listOfFemaleDataFormat[41]].toDouble(),
                        value[listOfFemaleDataFormat[42]].toDouble(),
                        value[listOfFemaleDataFormat[43]].toDouble(),
                        value[listOfFemaleDataFormat[44]].toDouble(),
                        value[listOfFemaleDataFormat[45]].toDouble(),
                        value[listOfFemaleDataFormat[46]].toDouble(),
                        value[listOfFemaleDataFormat[47]].toDouble(),
                        value[listOfFemaleDataFormat[48]].toDouble(),
                    )
                )
            }
        }
        return@withContext userList
    } catch(e: Exception){
        return@withContext emptyList()
    }
}

//@Composable
//fun InitializeDataTest(
//    modifier: Modifier = Modifier,
//    userViewModel: UserScoreViewModel = viewModel(),
//){
//
//    val allUsers = userViewModel.allUsers.collectAsState()
//
//    LazyColumn {
//        items(allUsers.value) { user ->
//            Text(text = user.toString())
//        }
//    }
//
//}