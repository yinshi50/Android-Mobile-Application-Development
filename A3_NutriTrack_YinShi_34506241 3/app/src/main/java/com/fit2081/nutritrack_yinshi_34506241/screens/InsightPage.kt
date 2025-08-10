package com.fit2081.nutritrack_yinshi_34506241.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fit2081.nutritrack_yinshi_34506241.data.User.AuthManager
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.UserScoreViewModel
//import com.fit2081.nutritrack_yinshi_34506241.functions.GetAllData
//import com.fit2081.nutritrack_yinshi_34506241.functions.GetTotalScore

data class ProcessBarDate (val name: String, val score: Float)

//@Preview(showBackground = true)
//@Composable
//fun InsightPagePreview (modifier: Modifier = Modifier) {
//    val controler = rememberNavController()
//    val selectedItem = remember { mutableStateOf(0) }
//    InsightPage(modifier, controler, selectedItem)
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsightPage(modifier: Modifier = Modifier, navController: NavController, selectedItem: MutableState<Int>, viewModel: UserScoreViewModel) {
    val scrollState = rememberScrollState()

    val context = LocalContext.current

    val userId = AuthManager.getId()

    if (userId != null) {
        viewModel.getOtherScore(userId)
        viewModel.getTotalScore(userId)
    }

    val listOfName = listOf("Vegetable", "Fruit", "Grain & Cereals","Whole Grains", "Meat & Alternatives", "Dairy", "Water", "Unsaturated Fats", "Sodium", "Sugar", "Alcohol", "Discretionary Foods")
    val listOfProcessBarData by viewModel.otherScore
    val totalScore by viewModel.totalScore

    Column (
        modifier = modifier.fillMaxSize().padding(16.dp).verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Insights: Food Score")

        Spacer(modifier = Modifier.padding(8.dp))

        Column {
            listOfName.zip(listOfProcessBarData).forEach { data ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        data.first,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        modifier = Modifier.width(130.dp)
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    Slider(
                        value = data.second.toFloat(),
                        onValueChange = { },
                        valueRange = 0f..10f,
                        colors = SliderDefaults.colors(
                            thumbColor = Color.White,
                            activeTrackColor = Color(0xFFCE5DF0),
                            inactiveTrackColor = Color(0xFFD0BCFF),
                        ),
                        thumb = {
                            // Custom thumb with a larger size and different background
                            Box(
                                modifier = Modifier
                                    .size(24.dp) // Custom thumb size
                                    .clip(CircleShape)
                                    .border(2.dp, Color.Gray, shape = CircleShape)
                                    .background(color = Color.White)
                            )
                        },
                        steps = 4,
                        modifier = Modifier.width(150.dp)
                    )

                    Text(
                        kotlin.math.round(data.second.toFloat()).toString() + "/10",
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )
                }
            }


        }

        Spacer(modifier = Modifier.padding(20.dp))

        Text (
            "Total Food Quality Score",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Slider(
                value = totalScore.toFloat(),
                onValueChange = {},
                valueRange = 0f..100f,
                thumb = {
                    // Custom thumb with a larger size and different background
                    Box(
                        modifier = Modifier
                            .size(24.dp) // Custom thumb size
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, shape = CircleShape)
                            .background(color = Color.White)
                    )
                },
                colors = SliderDefaults.colors(
                    thumbColor = Color.White,
                    activeTrackColor = Color(0xFFCE5DF0),
                    inactiveTrackColor = Color(0xFFD0BCFF),
                ),
                steps = 4,
                modifier = Modifier.width(260.dp)
            )

            Text(
                "$totalScore / 100",
            )
        }

//        val sharedData = GetAllData(
//            sharedPref.getString("userID", "Unknown").toString(), "userdata.csv", context
//        ).joinToString ("\n"){
//            "${it.name}: ${it.score}"
//        }
        val sharedData = listOfName.zip(listOfProcessBarData).joinToString("\n") {
            "${it.first}: ${it.second}"
        }

        Button (
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(
                    Intent.EXTRA_TEXT, sharedData
                )
                context.startActivity(Intent.createChooser(shareIntent, "Share text via: "))
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonColors(
                containerColor = Color(0xFFCE5DF0),
                contentColor = Color.White,
                disabledContainerColor = Color(0xFFCE5DF0),
                disabledContentColor = Color.White
            )
        ) {
            Icon (
                imageVector = Icons.Outlined.Share,
                contentDescription = "share"
            )
            Text ("Share with someone")
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Button(
            onClick = {
                navController.navigate("NutriCoach")
                selectedItem.value = 2
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonColors(
                containerColor = Color(0xFFCE5DF0),
                contentColor = Color.White,
                disabledContainerColor = Color(0xFFCE5DF0),
                disabledContentColor = Color.White
            )
        ) {
            Icon (
                imageVector = Icons.Default.RocketLaunch,
                contentDescription = "Improve"
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text ("Improve my diet")
        }
    }

}
