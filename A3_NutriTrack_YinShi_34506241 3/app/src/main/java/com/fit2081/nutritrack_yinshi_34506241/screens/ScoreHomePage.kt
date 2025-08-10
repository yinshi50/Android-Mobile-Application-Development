package com.fit2081.nutritrack_yinshi_34506241.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
//import com.fit2081.nutritrack_yinshi_34506241.functions.GetTotalScore
import com.fit2081.nutritrack_yinshi_34506241.R
import com.fit2081.nutritrack_yinshi_34506241.data.User.AuthManager
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.UserScoreViewModel

//@Preview (showBackground = true)
//@Composable
//fun ScoreHomePagePreview (modifier: Modifier = Modifier) {
//    val controler = rememberNavController()
//    val selectedItem = remember { mutableStateOf(0) }
//    ScoreHomePage(modifier, controler, selectedItem)
//}

@Composable
fun ScoreHomePage (modifier: Modifier = Modifier, navController: NavController, selectedItem: MutableState<Int>, viewModel: UserScoreViewModel) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val user = AuthManager.getId()

    if (user != null) {
        viewModel.getTotalScore(user)
    }

    val totalScore by viewModel.totalScore

    Column (
        modifier = modifier.fillMaxSize().padding(16.dp).verticalScroll(scrollState),
//        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Hello",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Text(
            text = "USER: $user",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "You've already filled in your Food intake Questionnaire, but you can change details here: ",
                fontSize = 12.sp,
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    val intent = Intent(context, FoodQuestionnaire::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.padding(start = 8.dp),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
            ) {
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon (imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text ( "Edit", fontSize = 16.sp)
                }
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Image(
            painter = painterResource(id = R.drawable.images),
            contentDescription = "",
            modifier = Modifier.size(300.dp).align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text ("My Score: ", fontSize = 16.sp, fontWeight = FontWeight.Bold)

            ClickableText(
                text = AnnotatedString("See all scores >"),
                onClick = {
                    navController.navigate("Insights")
                    selectedItem.value = 1
                },
                style = TextStyle(
                    color = Color.Blue,
                )
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text ("Your Food Quality score",
                color = Color.Gray,
                fontSize = 16.sp
            )

            Text (
//                text = GetTotalScore(
//                    sharedPref.getString("userID", "Unknown").toString(), "userdata.csv", context
//                ) + " / 100",
                text = "$totalScore / 100",
                color = Color.Blue,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text (
            "What is the Food Quality Score?",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Text(
            "Your Food Quality Score provides a snapshot of how well your eating patterns aligns with" +
                    "established food guidelines, helping you identify both strengths and opportunities for improvment" +
                    "in your diet.",
            fontSize = 13.sp,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text (
            "This personalized measurement considers various food groups including vegetables, " +
                    "fruits, whole grains, and proteins to give you practical insights for making healthier food choices",
            fontSize = 13.sp,
            modifier = Modifier.padding(top = 8.dp)
        )

    }
}

