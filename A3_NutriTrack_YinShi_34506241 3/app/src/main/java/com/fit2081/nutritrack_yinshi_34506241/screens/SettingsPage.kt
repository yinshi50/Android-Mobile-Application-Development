package com.fit2081.nutritrack_yinshi_34506241.screens

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.DisplaySettings
import androidx.compose.material.icons.outlined.Login
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fit2081.nutritrack_yinshi_34506241.BuildConfig
import com.fit2081.nutritrack_yinshi_34506241.MainActivity
import com.fit2081.nutritrack_yinshi_34506241.R
import com.fit2081.nutritrack_yinshi_34506241.data.AI.Patterns
import com.fit2081.nutritrack_yinshi_34506241.data.User.AuthManager
import com.fit2081.nutritrack_yinshi_34506241.data.User.User
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.GenAIViewModel
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.UserScoreViewModel
import com.fit2081.nutritrack_yinshi_34506241.ui.UiStates.UiState
import com.google.gson.Gson

@Composable
fun SettingsPage (modifier: Modifier = Modifier, viewModel: UserScoreViewModel) {
    val showScreen = remember {mutableStateOf("Outline")}

    when(showScreen.value){
        "Outline" -> SettingsOutline(modifier, viewModel, showScreen)
        "AdminLogin" -> AdminLoginScreen(modifier, viewModel, showScreen)
        "AdminView" -> AdminViewScreen(modifier, viewModel, showScreen)
    }


}
@Composable
fun SettingsOutline(modifier: Modifier = Modifier, viewModel: UserScoreViewModel, showScreen: MutableState<String>) {
    val scrollState = rememberScrollState()
    val userId = AuthManager.getId()
    if (userId != null){
        viewModel.getUserById(userId)
    }
    val user by viewModel.user

    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp).verticalScroll(scrollState),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text (
            "Settings",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.padding(14.dp))

        Text(
            "ACCOUNT",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.padding(14.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon (
                imageVector = Icons.Outlined.PersonOutline,
                contentDescription = "Person",
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                user?.id ?: "Unknown",
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon (
                imageVector = Icons.Outlined.Phone,
                contentDescription = "Person",
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                user?.phoneNumber ?: "Unknown",
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.padding(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon (
                imageVector = Icons.Outlined.DisplaySettings,
                contentDescription = "Person",
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                user?.sex?: "Unknown",
                fontSize = 18.sp,
            )

        }

        Spacer(modifier = Modifier.padding(12.dp))

        Divider(
            thickness = 1.dp,
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.padding(14.dp))

        Text(
            "OTHER SETTINGS",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.padding(14.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon (
                imageVector = Icons.Outlined.Logout,
                contentDescription = "Logout",
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                "Logout",
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Outlined.ArrowForwardIos,
                contentDescription = "Forward",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable {
                        AuthManager.logout()
                        context.startActivity(Intent(context, MainActivity::class.java))
                    }
            )
        }

        Spacer (modifier = Modifier.padding(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {

                },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon (
                imageVector = Icons.Outlined.PersonOutline,
                contentDescription = "Clinician Login",
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                "Clinician Login",
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Outlined.ArrowForwardIos,
                contentDescription = "Forward",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable {
                        showScreen.value = "AdminLogin"
                    }
            )
        }
    }
}

@Composable
fun AdminLoginScreen(modifier: Modifier = Modifier, viewModel: UserScoreViewModel, showScreen: MutableState<String>) {
    val scrollState = rememberScrollState()
    val keyError = remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp).verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        val key = remember {mutableStateOf("")}

        Text(
            text = "Clinician Login"
        )

        Spacer(modifier = Modifier.padding(16.dp))

        OutlinedTextField(
            value = key.value,
            onValueChange = {key.value = it},
            label = { Text("Clinician Key") },
            placeholder = { Text("Enter Clinician Key") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = {
                if (key.value == "dollar-entry-apples"){
                    showScreen.value = "AdminView"
                } else{
                    keyError.value = true
                }
            }
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    imageVector = Icons.Outlined.Login,
                    contentDescription = "Login"
                )

                Spacer(modifier = Modifier.width(24.dp))

                Text(
                    "Clinician Login",
                    fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))

        if (keyError.value){
            Text(
                "Wrong key access",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.error
            )
        }

    }
}

@Composable
fun AdminViewScreen(modifier: Modifier = Modifier, viewModel: UserScoreViewModel, showScreen: MutableState<String>) {
    val scrollState = rememberScrollState()

    val genAIViewModel = viewModel<GenAIViewModel>()

    val gson = Gson()

    val maleAverageScore by viewModel.maleAverageScore
    val femaleAverageScore by viewModel.femaleAverageScore

    val allUsers by viewModel.allUsers.collectAsState()

    val secretUserData = remember { mutableStateOf<List<User>>(emptyList()) }

    val promptTemplate = stringResource(R.string.prompt_placeholder_pattern)
    val promptInfo = remember { mutableStateOf("") }

    val uiStatePattern by genAIViewModel.uiStatePattern.collectAsState()

//    LaunchedEffect(allUsers) {
        secretUserData.value = allUsers.map{user -> user.copy(id = "unKnown", phoneNumber = "null", questionnaire = false, password = "null")}
        promptInfo.value = promptTemplate + secretUserData.value.joinToString(", ")
//    }

    val displayAverageScoreInfo = listOf(
        "Average HEIF (Male)",
        "Average HEIF (Female)"
    )

    viewModel.getMaleAverageScore()
    viewModel.getFemaleAverageScore()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp).verticalScroll(scrollState),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Clinician Dashboard",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                displayAverageScoreInfo[0],
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(4.dp)
                    .width(200.dp)
            )

            Text(
                ": ${maleAverageScore.toString()}",
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(4.dp)
            )
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                displayAverageScoreInfo[1],
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(4.dp)
                    .width(200.dp)
            )

            Text(
                ": ${femaleAverageScore.toString()}",
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(4.dp)
            )
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Divider(
            thickness = 1.dp,
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = {
                genAIViewModel.sendPrompt(promptInfo.value, "Pattern")
            }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Forward",
                    modifier = Modifier
                        .padding(end = 8.dp)
                )

                Text("Find Pattern",
                    fontSize = 18.sp)
            }
        }

        when (uiStatePattern){
            is UiState.Initial -> {
                Text (
                    "Try to search something",
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 24.dp),
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            is UiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            is UiState.Success -> {
                var rawJson = (uiStatePattern as UiState.Success).outputText
                Log.d("3 Success", "Unescape quotes")
                rawJson = rawJson.replace("\n", "")
                rawJson = rawJson.trim()
                val aiResponse = gson.fromJson(rawJson, Patterns::class.java).patterns
                Log.d("3 Patterns", aiResponse.toString())
                Column(){
                    aiResponse.forEach{it ->
                        Card(
                            modifier = Modifier.fillMaxWidth().padding(6.dp)
                        ){
                            Column(
                                modifier = Modifier.padding(6.dp).fillMaxWidth()
                            ){
                                Text(
                                    it.patternTitle,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Text(
                                    it.patternDescription,
                                    fontSize = 12.sp,
                                    fontStyle = FontStyle.Italic,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }
            }
            is UiState.NetworkError -> {}
            is UiState.Error -> {
                Text(
                    (uiStatePattern as UiState.Error).errorMessages,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 24.dp),
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }


        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    showScreen.value = "Outline"
                }
            ) {
                Text("Done")
            }
        }
    }

}