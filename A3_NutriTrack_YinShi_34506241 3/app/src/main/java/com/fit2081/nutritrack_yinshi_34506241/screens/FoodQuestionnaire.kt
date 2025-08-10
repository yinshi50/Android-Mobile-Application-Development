package com.fit2081.nutritrack_yinshi_34506241.screens

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit2081.nutritrack_yinshi_34506241.ui.theme.NutriTrack_YinShi_34506241Theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModelProvider
import com.fit2081.nutritrack_yinshi_34506241.activities.MainAppScreen
import com.fit2081.nutritrack_yinshi_34506241.data.Questionnaire.QuestionnaireAnswers
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.QuestionnaireViewModel
import com.fit2081.nutritrack_yinshi_34506241.data.User.AuthManager
import com.fit2081.nutritrack_yinshi_34506241.ui.components.TopAppBarExample


class FoodQuestionnaire : ComponentActivity() {
    private lateinit var viewModel: QuestionnaireViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(
                this,
                QuestionnaireViewModel.QuestionnaireFactory(this@FoodQuestionnaire)
            )[QuestionnaireViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            NutriTrack_YinShi_34506241Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopAppBarExample("Food Questionnaire") }
                ) { innerPadding ->
                    FoodQuestionnairePreview(viewModel, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FoodQuestionnairePreview (viewModel: QuestionnaireViewModel, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    Column (
        modifier = modifier.verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // get user id
        val userId = AuthManager.getId()

        // initialize questionnaire
        val questionnaire = remember {
            mutableStateOf<QuestionnaireAnswers?>(
                QuestionnaireAnswers(
                    id = "unknown",
                    firstPartResult = "[false, false, false, false, false, false, false, false, false]",
                    thirdPartResult = "Select Option",
                    fourthPartResult = "[00:00, 00:00, 00:00]"
                )
            )
        }

        // check if the questionnaire has been done before
        val doneBefore = remember { mutableStateOf<Boolean>(true) }

        val fetchedQuestionnaire by viewModel.questionnaireViewModel

        // get the questionnaire from the database

        if (userId != null) {
            viewModel.getQuestionnaireById(userId)
        }else{
            Log.e("Error", "UserId == null")
        }

        if (userId != null){
            if (fetchedQuestionnaire == null) {
                questionnaire.value = QuestionnaireAnswers(
                    id = userId,
                    firstPartResult = "[false, false, false, false, false, false, false, false, false]",
                    thirdPartResult = "Select Option",
                    fourthPartResult = "[00:00, 00:00, 00:00]"
                )
                doneBefore.value = false
            } else {
                questionnaire.value = fetchedQuestionnaire
            }
        }else {
            Log.e("Error", "UserId == null")
        }


        val firstPart = remember(questionnaire.value) { questionnaire.value?.firstPartResult?.removeSurrounding("[", "]")
            ?.split(", ")
            ?.map { it.toBoolean() }
            ?.toMutableStateList()
            ?: mutableStateListOf(false, false, false, false, false, false, false, false, false) }

        val thirdPart = remember(questionnaire.value) { mutableStateOf(questionnaire.value?.thirdPartResult ?: "Select Option") }

        val fourthPart = remember(questionnaire.value) { questionnaire.value?.fourthPartResult?.removeSurrounding("[", "]")
            ?.split(", ")
            ?.map { mutableStateOf(it) }
            ?.toMutableStateList()
            ?: mutableStateListOf(mutableStateOf("00:00"), mutableStateOf("00:00"), mutableStateOf("00:00")) // Default state
        }

        FoodQuestionnairePart1(firstPart)

        Spacer(modifier = Modifier.padding(16.dp))

        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(bottom = 16.dp))

        val savedPicturesStates = foodQuestionnairePart2()

        Spacer(modifier = Modifier.padding(16.dp))

        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(bottom = 16.dp))

        FoodQuestionnairePart3(thirdPart)

        Spacer(modifier = Modifier.padding(16.dp))

        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(bottom = 16.dp))

        FoodQuestionnairePart4(fourthPart)

        Spacer(modifier = Modifier.padding(16.dp))

        IconButton (
            onClick = {
                if (userId != null) {
                    if (!doneBefore.value) {
                        doneBefore.value = true
                        viewModel.insertQuestionnaire(
                            QuestionnaireAnswers(
                                id = userId,
                                firstPartResult = firstPart.joinToString(prefix = "[", postfix = "]"),
                                thirdPartResult = thirdPart.value,
                                fourthPartResult = fourthPart.joinToString(prefix = "[", postfix = "]") { it.value }
                            )
                        )
                    } else {
                        viewModel.updateQuestionnaire(
                            QuestionnaireAnswers(
                                id = userId,
                                firstPartResult = firstPart.joinToString(prefix = "[", postfix = "]"),
                                thirdPartResult = thirdPart.value,
                                fourthPartResult = fourthPart.joinToString(prefix = "[", postfix = "]") { it.value }
                            )
                        )
                        Log.d("FoodQuestionnaire", "Questionnaire updated")
                    }
                }
                context.startActivity(Intent(context, MainAppScreen::class.java))
            },
            modifier = Modifier.border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp)).width(140.dp).height(43.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
                Icon(
                    imageVector = Icons.Outlined.Check,
                    contentDescription = "Save"
                )
                Text(
                    text = "Save",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }

            Log.d("FoodQuestionnaire", "Questionnaire saved")
        }

    }


}

@Composable
fun FoodQuestionnairePart1(savedCheckedStates: MutableList<Boolean>) {
    val options1 = listOf("Fruit", "Vegetables", "Grains")
    val options2 = listOf("Red Meat", "Seafood", "Poultry")
    val options3 = listOf("Fish", "Eggs", "Nuts/Seeds")
    val options = listOf(options1, options2, options3)
    Column (
        verticalArrangement = Arrangement.Center,
    ) {
        Text (
            text = "Tick all the food categories you can eat",
            modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        options.forEachIndexed { index, optionList ->
            Row(
                modifier = Modifier.padding(end = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                optionList.forEachIndexed { anotherIndex, option ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = savedCheckedStates[index * optionList.size + anotherIndex],
                            onCheckedChange = { savedCheckedStates[index * optionList.size + anotherIndex] = it }
                        )
                        Text(
                            option,
                            modifier = Modifier.width(80.dp),
                            fontSize = 12.sp,
                        )
                    }
                }
            }
        }
    }
}

data class FoodCategory(val name: String, val imageName: String, val description: String)
// alternative way of implementation

@Composable
fun foodQuestionnairePart2(): MutableList<Boolean> {
    val personaOptionsList = listOf (
        mapOf("Health Devotee" to Pair("persona_1", """
            |A dedicated health enthusiast who meticulously follows a strict diet and exercise regimen.
            |They prioritize organic foods, track macros, and embrace wellness trends.
            |Their lifestyle revolves around maintaining peak physical fitness,
            |often engaging in yoga, meditation, and mindful eating.
            |They influence others by sharing health tips and nutritious meal plans.""".trimMargin()),
            "Mindful Eater" to Pair("persona_2", """
            A conscious and intuitive eater who carefully selects food based on nutritional value and
            ethical considerations. They avoid processed foods, savor each bite, and practice portion control.
            Their focus is on balance, avoiding extremes while making informed food choices.
            They appreciate local, fresh ingredients and enjoy cooking wholesome meals""".trimIndent()),
            "Wellness Striver" to Pair("persona_3", """
            A health-conscious individual constantly seeking ways to improve their diet and overall well-being.
            They experiment with new fitness routines, superfoods, and health supplements.
            While they aim for consistency, they occasionally struggle with maintaining discipline.
            They believe in progress over perfection and continuously refine their habits for better health outcomes.""".trimIndent())),

        mapOf("Balance Seeker" to Pair("persona_4","""
            |A pragmatic individual who values both nutrition and indulgence.
            |They strive for moderation, enjoying a mix of healthy meals and occasional treats.
            |They believe in listening to their body's needs rather than following rigid diets.
            |For them, well-being is about enjoying life while making mindful and sustainable food choices.""".trimMargin()),
            "Health Procrastinator" to Pair("persona_5","""
            Someone who aspires to live a healthier lifestyle but often postpones taking action.
            They frequently start new diets or exercise plans but struggle with consistency.
            They have good intentions and understand the benefits of healthy eating, yet convenience,
            cravings, or lack of motivation often lead them to unhealthy choices.""".trimIndent()),
            "Food Carefree" to Pair("persona_6", """
            An easygoing eater who prioritizes enjoyment over nutrition.
            They eat whatever they crave, often choosing comfort and convenience over health.
            They don’t stress over calories or ingredients and are open to trying new foods without restriction.
            Their philosophy is that food should bring joy without being overly controlled or analyzed.""".trimIndent())
        )
    )

    val showDialogPictureList = remember { mutableStateListOf(false, false, false, false, false, false)}

    Column (
        verticalArrangement = Arrangement.Center,
    ) {

        Text(
            text = "Your Persona",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )

        Text(
            text = """People can be broadly classified into 6 different types based on
                |their eating preferences. Click on each button below to find out
                |the difference types, and select the type that best fits you!
            """.trimMargin(),
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            fontSize = 12.sp
        )

        personaOptionsList.forEachIndexed { index, optionList ->
            Row(
                modifier = Modifier.padding(end = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                optionList.entries.toList().forEachIndexed { anotherIndex, (option, pictureAndText) ->
                    Button (
                        onClick = {
                            showDialogPictureList[anotherIndex+index * 3] = true
                        },
                        modifier = Modifier.padding(4.dp),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                    ) {
                        Text(
                            option,
                            fontSize = 12.sp,
                            maxLines = 1
                        )
                    }

                    val context = LocalContext.current
                    val imageResId = remember {
                        context.resources.getIdentifier(pictureAndText.first, "drawable", context.packageName)
                    }
                    // alternative assign the string content to be R.drawable.image_name
                    // then id = pictureAndText.first

                    if (showDialogPictureList[anotherIndex+index * 3]) {
                        AlertDialog(
                            onDismissRequest = { showDialogPictureList[anotherIndex+index * 3] = false },
                            confirmButton = {
                                TextButton(onClick = { showDialogPictureList[anotherIndex+index * 3] = false }) {
                                    Text("OK")
                                }
                            },
                            title = { Text(option) },
                            text = {
                                Column (
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = imageResId),
                                        contentDescription = "Description of image",
                                        modifier = Modifier.fillMaxWidth() // Adjust size if needed
                                    )

                                    Spacer(modifier = Modifier.padding(16.dp))

                                    Text(
                                        text = pictureAndText.second,
                                        textAlign = TextAlign.Center,
                                        fontSize = 12.sp,
                                        color = Color.Gray,
                                        fontStyle = FontStyle.Italic,
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }

    return showDialogPictureList
}

@Composable
fun FoodQuestionnairePart3 (selectedPersona: MutableState<String>){
    val options = listOf("Health Devotee", "Mindful Eater", "Wellness Striver", "Balance Seeker", "Health Procrastinator", "Food Carefree")
    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
    ){
        Text (
            "Which persona best fits you?",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        SimpleDropdownMenu(
            options, selectedPersona.value, onItemSelected = {
                selectedPersona.value = it
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleDropdownMenu(
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = Modifier.padding(16.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth().border(1.dp, Color.Gray, RoundedCornerShape(16.dp)).menuAnchor(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text (
                text = selectedItem,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                fontSize = 14.sp,
                fontStyle = FontStyle.Italic
            )
            IconButton(
                onClick = { expanded = true },
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Dropdown List",
                )
            }
        }

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
        ) {
            items.forEachIndexed { index,item ->
                DropdownMenuItem(
                    text = { Text(item, modifier = Modifier.padding(16.dp)) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }

                )
                if (index < items.lastIndex) {
                    Divider(thickness = 1.dp, color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun FoodQuestionnairePart4 (selectedTimes: MutableList<MutableState<String>>) {

    val timePickerQuestions = listOf(
        "What time of day approx. do you normally eat your biggest meal?",
        "What time of day approx. do you go to sleep at night?",
        "What time of day approx. do you wake up in the morning?"
    )

    Column (
        modifier = Modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text ("Timing",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        timePickerQuestions.forEachIndexed{ index, question ->
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text (question,
                    modifier = Modifier.width(200.dp),
                    fontSize = 12.sp,
                )
                TimePickerButton(selectedTimes[index].value, dialog = TimePickerFun(selectedTimes[index]))
            }
        }
    }
}

@Composable
fun TimePickerButton (timeValue: String, dialog: TimePickerDialog) {

    Button(onClick = { dialog.show() },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray, // Button background color
            contentColor = Color.Black // Text color
        ),
        border = (BorderStroke(1.dp, Color.Gray)),
        modifier = Modifier.height(43.dp).width(140.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon (
                imageVector = Icons.Outlined.DateRange,
                contentDescription = "",
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(text = timeValue,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Composable
fun TimePickerFun (mTime: MutableState<String>): TimePickerDialog {
    val mContext = LocalContext.current
    val mHour: Int
    val mMinute: Int

    val mCalendar = Calendar.getInstance()
    mHour = mCalendar.get(Calendar.HOUR_OF_DAY)
    mMinute = mCalendar.get(Calendar.MINUTE)

    mCalendar.time = Calendar.getInstance().time

    return TimePickerDialog(
        mContext,
        { _, hour: Int, minute: Int ->
            mTime.value = "$hour:$minute"
        }, mHour, mMinute, true
    )
}




