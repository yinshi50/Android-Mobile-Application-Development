package com.fit2081.nutritrack_yinshi_34506241.screens

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fit2081.nutritrack_yinshi_34506241.R
import com.fit2081.nutritrack_yinshi_34506241.data.AI.AIResponse
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.AIResponseViewModel
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.GenAIViewModel
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.FruitViewModel
import com.fit2081.nutritrack_yinshi_34506241.data.User.AuthManager
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.UserScoreViewModel
import com.fit2081.nutritrack_yinshi_34506241.ui.UiStates.UiState

//import com.fit2081.nutritrack_yinshi_34506241.data.login.ImportData
//import com.fit2081.nutritrack_yinshi_34506241.data.login.InitializeDataTest

@Composable
fun NutriCoach (modifier: Modifier = Modifier, viewModel: UserScoreViewModel) {

    val fruitViewModel = viewModel<FruitViewModel>()
    val genAIViewModel = viewModel<GenAIViewModel>()
    val aIResponseViewModel = viewModel<AIResponseViewModel>()

    val promptTemplateTips = stringResource(R.string.prompt_placeholder_tips)
    val promptTemplateFeedback = stringResource(R.string.prompt_placeholder_feedback)
    val promptTips = remember { mutableStateOf(promptTemplateTips) }
    val promptFeedback = remember { mutableStateOf(promptTemplateFeedback) }

    val userId = AuthManager.getId()
    if (userId != null){
        viewModel.getUserById(userId)
    }
    val user by viewModel.user

    val fruitScoreNames = listOf(
        "FruitHEIFAscore",
        "Fruitserversize",
        "Fruitvariationsscore",
        "FruitPome",
        "FruitTropicalandsubtropical",
        "FruitCitrus",
        "FruitOther"
    )

    val userInfo = listOf(
        "${user?.FruitHEIFAscore ?: "N/A"}",
        "${user?.Fruitserversize ?: "N/A"}",
        "${user?.Fruitvariationsscore ?: "N/A"}",
        "${user?.FruitPome ?: "N/A"}",
        "${user?.FruitTropicalandsubtropical ?: "N/A"}",
        "${user?.FruitCitrus ?: "N/A"}",
        "${user?.FruitOther ?: "N/A"}"
    )

    val promptScoreInfo =
        fruitScoreNames.zip(userInfo).joinToString("\n") { "${it.first}: ${it.second}" }

    promptTips.value = promptTemplateTips + promptScoreInfo
    promptFeedback.value = promptTemplateFeedback + promptScoreInfo
    val AIResultTips = remember { mutableStateOf("") }
    val AIResultFeedback = remember { mutableStateOf("") }

    val fruit by fruitViewModel.fruit.collectAsState(initial = null)
    val fruitInfo = listOf(
        ": ${fruit?.name ?: "N/A"}",
        ": ${fruit?.nutritions?.calories ?: "N/A"}",
        ": ${fruit?.nutritions?.fat ?: "N/A"}",
        ": ${fruit?.nutritions?.sugar ?: "N/A"}",
        ": ${fruit?.nutritions?.carbohydrates ?: "N/A"}",
        ": ${fruit?.nutritions?.protein ?: "N/A"}"
    )
    val fruitTitle = listOf(
        "Name",
        "Calories",
        "Fat",
        "Sugar",
        "Carbohydrates",
        "Protein"
    )

    val uiState by fruitViewModel.uiState.collectAsState()
    val uiStateAITips by genAIViewModel.uiStateTips.collectAsState()
    val uiStateAIFeedback by genAIViewModel.uiStateFeedback.collectAsState()

    val fruitName = remember{ mutableStateOf("")}

    val scrollState = rememberScrollState()
    val showDialog = remember { mutableStateOf(false) }
    val saveAIResponseTrigger = remember { mutableStateOf(false)}

    Surface(
        modifier = modifier.fillMaxSize().verticalScroll(scrollState)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "NutriCoach",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Box (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(8.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopStart),
                    horizontalAlignment = Alignment.Start
                ){
                    Text (
                        "Fruit Name: ",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer (modifier = Modifier.padding(2.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
                    ){
                        BasicTextField(
                            value = fruitName.value,
                            onValueChange = { fruitName.value = it },
                            modifier = Modifier.width(200.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color.Gray,
                                    shape = RoundedCornerShape(8.dp)
                                ).padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 8.dp),
                            textStyle = TextStyle(
                                color = Color.Gray,
                                fontSize = 18.sp,
                                fontStyle = FontStyle.Italic
                            ),
                        )

                        Button(
                            onClick = {
                                fruitViewModel.getFruit(fruitName.value)
                            },
                            modifier = Modifier.height(35.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonColors(
                                containerColor = Color(0xFFCE5DF0),
                                contentColor = Color.White,
                                disabledContainerColor = Color(0xFFCE5DF0),
                                disabledContentColor = Color.White
                            )
                        ) {
                            Icon (
                                Icons.Default.Search,
                                contentDescription = "Details"
                            )
                            Text("Details")
                        }
                    }

                    when (uiState){

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
                            Column (
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                fruitInfo.forEachIndexed{index, info ->
                                    Row(
                                        modifier = Modifier
                                            .padding(top = 6.dp, bottom = 6.dp)
                                            .border(
                                                width = 1.dp,
                                                color = Color.Gray,
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            .fillMaxWidth()
                                    ){
                                        Spacer (modifier = Modifier.padding(8.dp))
                                        Text(
                                            text = fruitTitle[index],
                                            modifier = Modifier.width(150.dp).padding(2.dp),
                                            fontSize = 18.sp
                                        )
                                        Text(
                                            text = info,
                                            fontSize = 18.sp,
                                            fontStyle = FontStyle.Italic,
                                            modifier = Modifier.padding(2.dp)
                                        )
                                    }
                                }
                            }
                        }
                        is UiState.NetworkError -> {
                            Text(text = "Network Error: ${(uiState as UiState.NetworkError).errorMessages}",
                                modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 24.dp),
                                fontSize = 18.sp,
                                color = MaterialTheme.colorScheme.error)
                        }
                        is UiState.Error -> {
                            Text(text = "Error: ${(uiState as UiState.Error).errorMessages}",
                                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 24.dp),
                                fontSize = 18.sp,
                                color = MaterialTheme.colorScheme.error)
                        }
                    }
                }
            }

            Divider(
                thickness = 2.dp,
                color = Color.Gray
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(8.dp)
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopStart).padding(bottom = 40.dp)
                ) {
                    Button(
                        onClick = {
                            genAIViewModel.sendPrompt(promptTips.value, "Tips")
                            genAIViewModel.sendPrompt(promptFeedback.value, "Feedback")
                            saveAIResponseTrigger.value = true
                        },
                        modifier = Modifier.align(Alignment.Start)
                            .padding(top = 8.dp, bottom = 8.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonColors(
                            containerColor = Color(0xFFCE5DF0),
                            contentColor = Color.White,
                            disabledContainerColor = Color(0xFFCE5DF0),
                            disabledContentColor = Color.White
                        )
                    ) {
                        Icon(
                            Icons.Default.Chat, contentDescription = "Chat"
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(
                            "Motivational message and feedback"
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth().weight(1f)
                    ) {

                        Text(
                            "Tip: ",
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .align(Alignment.Start).padding(4.dp),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        )

                        if (uiStateAITips is UiState.Loading) {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                        } else {
                            var textColor = MaterialTheme.colorScheme.onSurface
                            if (uiStateAITips is UiState.Initial) {
                                textColor = MaterialTheme.colorScheme.onSurface
                                AIResultTips.value = "You can ask for some tips!"
                            } else if (uiStateAITips is UiState.Error) {
                                textColor = MaterialTheme.colorScheme.error
                                AIResultTips.value = (uiStateAITips as UiState.Error).errorMessages
                            } else if (uiStateAITips is UiState.Success) {
                                textColor = MaterialTheme.colorScheme.onSurface
                                AIResultTips.value = (uiStateAITips as UiState.Success).outputText
                            }
                            val scrollState = rememberScrollState()

                            Text(
                                text = AIResultTips.value,
                                textAlign = TextAlign.Start,
                                color = textColor,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .verticalScroll(scrollState),
                                fontSize = 18.sp
                            )
                    }
                    }

                    Divider(
                        thickness = 1.dp,
                        color = Color.Gray,

                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth().weight(1f)
                    ) {

                        Text(
                            "Feedback: ",
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .align(Alignment.Start).padding(4.dp),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        )

                        if (uiStateAIFeedback is UiState.Loading) {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                        } else {
                            var textColor = MaterialTheme.colorScheme.onSurface
                            if (uiStateAIFeedback is UiState.Initial) {
                                textColor = MaterialTheme.colorScheme.onSurface
                                AIResultFeedback.value = "You can ask for some tips!"
                            } else if (uiStateAIFeedback is UiState.Error) {
                                textColor = MaterialTheme.colorScheme.error
                                AIResultFeedback.value =
                                    (uiStateAIFeedback as UiState.Error).errorMessages
                            } else if (uiStateAIFeedback is UiState.Success) {
                                textColor = MaterialTheme.colorScheme.onSurface
                                AIResultFeedback.value =
                                    (uiStateAIFeedback as UiState.Success).outputText
                            }
                            val scrollState = rememberScrollState()

                            Text(
                                text = AIResultFeedback.value,
                                textAlign = TextAlign.Start,
                                color = textColor,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .verticalScroll(scrollState),
                                fontSize = 18.sp
                            )
                        }
                    }
                }

                if (saveAIResponseTrigger.value && uiStateAITips is UiState.Success && uiStateAIFeedback is UiState.Success){
                    if (userId != null) {
                        aIResponseViewModel.insertAIResponse(
                            AIResponse(
                                userId = userId,
                                promptTips = promptTips.value,
                                promptFeedback = promptFeedback.value,
                                tip = AIResultTips.value,
                                feedback = AIResultFeedback.value
                            )
                        )
                        Log.d("AIResponseViewModel", "AIResponse inserted successfully\n ${AIResponse(
                            userId = userId,
                            promptTips = promptTips.value,
                            promptFeedback = promptFeedback.value,
                            tip = AIResultTips.value,
                            feedback = AIResultFeedback.value
                        ).toString()}")
                    }
                    saveAIResponseTrigger.value = false
                }

                Button(
                    onClick = {
                        showDialog.value = true
                    },
                    modifier = Modifier.align(Alignment.BottomEnd),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonColors(
                        containerColor = Color(0xFFCE5DF0),
                        contentColor = Color.White,
                        disabledContainerColor = Color(0xFFCE5DF0),
                        disabledContentColor = Color.White
                    )
                ){
                    Text ("Show all suggestions")
                }
            }
        }

        if (showDialog.value) {
            AIResponseViewDialog(modifier, userID = userId!!, viewModel = aIResponseViewModel, showDialog)
        }
    }
}

@Composable
fun AIResponseViewDialog(modifier: Modifier = Modifier, userID: String, viewModel: AIResponseViewModel, showDialog: MutableState<Boolean>){
    val aiResponseOrderDateTime by viewModel.aiResponseListOrderDateTime.collectAsState()
    val aiResponseOrderId by viewModel.aiResponseListOrderId.collectAsState()
    viewModel.getAIResponseOrderId(userID)
    viewModel.getAIResponseOrderDateTime(userID)

    val displayInfo = remember { mutableStateOf<List<AIResponse>>(emptyList()) }

    val orderByDateTime = remember { mutableStateOf(true) }
    val orderById = remember { mutableStateOf(false) }

    val expandNumber = remember { mutableStateOf(-1) }

    AlertDialog(
        onDismissRequest = {
            showDialog.value = false
        },
        confirmButton = {
            TextButton(
                onClick = {
                    showDialog.value = false
                }
            ) {
                Text("OK")
            }
        },
        title = {Text("AI Responses")},
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .padding(start = 4.dp, end = 4.dp),
                verticalArrangement = Arrangement.Top
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    FilterChip(
                        onClick = {
                            orderByDateTime.value = true
                            orderById.value = false
                            viewModel.getAIResponseOrderDateTime(userID)
                        },
                        label = {
                            Text("Time")
                        },
                        selected = orderByDateTime.value,
                        leadingIcon = if (orderByDateTime.value) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done icon",
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        } else {
                            null
                        },
                    )

                    Spacer(modifier = Modifier.padding(4.dp))

                    FilterChip(
                        onClick = {
                            orderByDateTime.value = false
                            orderById.value = true
                            viewModel.getAIResponseOrderId(userID)
                        },
                        label = {
                            Text("Id")
                        },
                        selected = orderById.value,
                        leadingIcon = if (orderById.value) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done icon",
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        } else {
                            null
                        },
                    )
                }

                if (orderById.value){
                    displayInfo.value = aiResponseOrderId
                } else {
                    displayInfo.value = aiResponseOrderDateTime
                }

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    itemsIndexed(displayInfo.value){ index, item ->
                        Card(
                            modifier = Modifier
                                .width(300.dp)
                                .padding(8.dp)
                                .animateContentSize(
                                    animationSpec = spring(
                                        dampingRatio = Spring.DampingRatioMediumBouncy,
                                        stiffness = Spring.StiffnessLow
                                    )
                                )
                                .clickable{
                                    if (expandNumber.value == index) {expandNumber.value = -1}
                                    else{ expandNumber.value = index}
                                          },
                            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.Start,
                            ) {
                                Text(
                                    buildAnnotatedString {
                                        withStyle(
                                            style = SpanStyle(
                                                fontSize = 15.sp,
                                                color = Color.Black,
                                                fontStyle = FontStyle.Italic
                                            )
                                        ){
                                            append("AI Response ${item.id} -- ")
                                        }
                                        withStyle(
                                            style = SpanStyle(
                                                fontSize = 12.sp,
                                                color = Color.Black,
                                                fontStyle = FontStyle.Italic,
                                            )
                                        ){
                                            append(item.dateTime)
                                        }
                                    },
                                    modifier = Modifier.padding(4.dp)
                                )

                                if (expandNumber.value == index) {
                                    Text(
                                        "Tips: ",
                                        fontSize = 15.sp,
                                        color = Color.Black,
                                        fontStyle = FontStyle.Italic,
                                        modifier = Modifier.padding(4.dp)
                                    )

                                    Text(
                                        text = item.tip,
                                        fontSize = 12.sp,
                                        color = Color.Gray,
                                        fontStyle = FontStyle.Italic,
                                        modifier = Modifier.padding(4.dp)
                                    )

                                    Text(
                                        "Feedback: ",
                                        fontSize = 15.sp,
                                        color = Color.Black,
                                        fontStyle = FontStyle.Italic,
                                        modifier = Modifier.padding(4.dp)
                                    )

                                    Text(
                                        text = item.feedback,
                                        fontSize = 12.sp,
                                        color = Color.Gray,
                                        fontStyle = FontStyle.Italic,
                                        modifier = Modifier.padding(4.dp)
                                    )
                                }

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End,
                                    verticalAlignment = Alignment.CenterVertically
                                ){

                                    if (expandNumber.value == index){
                                        Button(
                                            onClick = {
                                                viewModel.deleteAIResponse(item)
                                                expandNumber.value = -1
                                            },
                                            modifier = Modifier.height(40.dp)
                                        ) {
                                            Text(
                                                "Delete",
                                                fontSize = 12.sp,
                                            )
                                        }
                                    } else {
                                        Text(
                                            "Tap to view more info",
                                            fontSize = 12.sp,
                                            color = Color.DarkGray,
                                            fontStyle = FontStyle.Italic,
                                            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                                        )
                                    }

                                    Spacer(modifier = Modifier.padding(8.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}