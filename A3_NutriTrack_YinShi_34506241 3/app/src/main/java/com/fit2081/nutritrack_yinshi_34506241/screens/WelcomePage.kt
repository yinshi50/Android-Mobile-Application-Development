package com.fit2081.nutritrack_yinshi_34506241.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit2081.nutritrack_yinshi_34506241.R
import com.fit2081.nutritrack_yinshi_34506241.activities.MainAppScreen
import com.fit2081.nutritrack_yinshi_34506241.data.User.AuthManager
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.UserLoginViewModel
//import com.fit2081.nutritrack_yinshi_34506241.functions.checkUserID
//import com.fit2081.nutritrack_yinshi_34506241.functions.checkUserLogin
//import com.fit2081.nutritrack_yinshi_34506241.functions.checkUserPhoneNumber


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomePage (viewModel: UserLoginViewModel, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val link = """https://www.monash.edu/medicine/scs/nutrition/clinics
        |/nutrition""".trimMargin()
    val disclaimerText =
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Gray,
                    fontStyle = FontStyle.Italic,
                    fontSize = 12.sp,
                )
            ){
                append(
                    """
                This app provides general health and nutrition information
                 for educational purposes only. It is not intended as
                 medical advice, diagnosis, or treatment. Always consult a 
                 qualified healthcare professional before making any
                 changes to your diet, exercise, or health regimen.
                 Use this app at your own risk.
                 If you'd like to an Accredited Practicing Dietitian (APD),
                 please visit the Monash Nutrition/Dietetics Clinic
                 (discounted rates for students):
                 
                 """.trimIndent()
                )
            }
            pushStringAnnotation(tag = "URL", annotation = link)
            withStyle(
                style = SpanStyle(
                    fontSize = 12.sp,
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append(link)
            }
            pop()
        }

    val rainbowColors = listOf(
        Color.Blue, Color.Magenta, Color.Cyan
    )
    val showBottomSheet = remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )
    val userID = remember { mutableStateOf("") }
    val userPhoneNumber = remember { mutableStateOf("") }
    val userPassword = remember { mutableStateOf("") }
    val userPasswordConfirm = remember { mutableStateOf("") }

    val userPasswordError = remember { mutableStateOf(false) }
    val userPasswordConfirmError = remember { mutableStateOf(false) }

    val idEmptyError = remember { mutableStateOf(false)}
    val phoneNumberEmptyError = remember { mutableStateOf(false)}
    val userIDErrorViewModel by viewModel.userIDError
    val userPhoneNumberErrorViewModel by viewModel.userPhoneNumberError

    val showLoginDialog = remember { mutableStateOf(false) }
    val showRegisterDialog = remember { mutableStateOf(false) }

    val login = remember { mutableStateOf(true) }

    val isPasswordVisible = remember { mutableStateOf(false) }
    val isPasswordConfirmVisible = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFCCC2DC)),

        ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text (
                "NutriTrack",
                fontSize = 48.sp,
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(R.drawable.images),
                contentDescription = "My Image",
                modifier = Modifier.size(200.dp)
            )

            ClickableText(
                text = disclaimerText,
                onClick = { offset ->
                    disclaimerText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                        .firstOrNull()?.let {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                            context.startActivity(intent)
                        }
                },
                style = androidx.compose.ui.text.TextStyle(
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp
                ),
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Button (
                onClick = {
                    showBottomSheet.value = true
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
            ){
                Text ("Login")
            }
        }

        Text(
            text = "Designed by YinShi (34506241)",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp), // Aligns text at the bottom
            fontSize = 12.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            style = androidx.compose.ui.text.TextStyle(
                brush = Brush.linearGradient(
                    colors = rainbowColors // Gradient colors
                )
            )
        )
    }

    if (showBottomSheet.value) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxHeight(),
            sheetState = sheetState,
            onDismissRequest = { showBottomSheet.value = false }
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer (modifier = Modifier.padding(8.dp))

                Text (
                    if (login.value) "Log in" else "Register",
                    fontSize = 24.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )

                LaunchedEffect(userID.value) {

                }

                // user ID
                OutlinedTextField(
                    modifier = Modifier.padding(8.dp),
                    value = userID.value,
                    onValueChange = {
                        userID.value = it
                        viewModel.checkUserID(it)
                        idEmptyError.value = it.isEmpty()
                    },
                    label = { Text("My ID") },
                    placeholder = { Text("Enter your username") },
                    singleLine = true,
                    isError = !userIDErrorViewModel.first || userID.value.isEmpty() && idEmptyError.value,
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                if (!userIDErrorViewModel.first || userID.value.isEmpty() && idEmptyError.value) {
                    Text(
                        text = viewModel.userIDError.value.second,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    )
                }

                // user phone number
                AnimatedVisibility (
                    visible = !login.value,
                    enter = fadeIn(animationSpec = tween(500)),
                    exit = fadeOut(animationSpec = tween(500))
                ){
                    OutlinedTextField(
                        modifier = Modifier.padding(8.dp),
                        value = userPhoneNumber.value,
                        onValueChange = {
                            userPhoneNumber.value = it
                            viewModel.checkUserPhoneNumber(it)
                            phoneNumberEmptyError.value = it.isEmpty()
                        },
                        label = { Text("Phone Number") },
                        placeholder = { Text("Enter your phone number") },
                        singleLine = true,
                        isError = !userPhoneNumberErrorViewModel.first || userPhoneNumber.value.isEmpty() && phoneNumberEmptyError.value,
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )
                }
                if (!login.value){
                    if (!userPhoneNumberErrorViewModel.first || userPhoneNumber.value.isEmpty() && phoneNumberEmptyError.value) {
                        Text(
                            text = viewModel.userPhoneNumberError.value.second,
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp
                        )
                    }
                }

                // user password
                OutlinedTextField(
                    modifier = Modifier.padding(8.dp),
                    value = userPassword.value,
                    onValueChange = {
                        userPassword.value = it
                        userPasswordError.value = userPassword.value.length < 8
                    },
                    label = { Text("Password") },
                    placeholder = { Text("Enter your password") },
                    singleLine = true,
                    isError = userPasswordError.value,
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val icon = if (isPasswordVisible.value) Icons.Default.Visibility else Icons.Default.VisibilityOff
                        IconButton(onClick = { isPasswordVisible.value = !isPasswordVisible.value }) {
                            Icon(imageVector = icon, contentDescription = null)
                        }
                    },
                    visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                )

                if (userPasswordError.value) {
                    Text(
                        text = "Password should not be less than 8 chars",
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    )
                }

                // user confirm password
                AnimatedVisibility (
                    visible = !login.value,
                    enter = fadeIn(animationSpec = tween(500)),
                    exit = fadeOut(animationSpec = tween(500))
                ){
                    OutlinedTextField(
                        modifier = Modifier.padding(8.dp),
                        value = userPasswordConfirm.value,
                        onValueChange = {
                            userPasswordConfirm.value = it
                            userPasswordConfirmError.value = userPasswordConfirm.value != userPassword.value || userPasswordConfirm.value.isEmpty()
                        },
                        label = { Text("Confirm Password") },
                        placeholder = { Text("Confirm your password") },
                        singleLine = true,
                        isError = userPasswordConfirmError.value,
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            val icon = if (isPasswordConfirmVisible.value) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = { isPasswordConfirmVisible.value = !isPasswordConfirmVisible.value }) {
                                Icon(imageVector = icon, contentDescription = null)
                            }
                        },
                        visualTransformation = if (isPasswordConfirmVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                    )
                }
                if (!login.value){
                    if (userPasswordConfirmError.value) {
                        if (userPasswordConfirm.value.isEmpty()){
                            Text(
                                text = "Password cannot be empty",
                                color = Color.Red,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp
                            )
                        } else{
                            Text(
                                text = "Passwords do not match",
                                color = Color.Red,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                Text (
                    text = if (login.value) """
                        |This app is only for pre-registered user. Please have
                        |your ID and password or Register to claim your 
                        |account on your first visit.""".trimMargin()
                    else
                        """
                        |This app is only for pre-registered user. Please enter
                        |your ID, photo number and password to claim your
                        |account.""".trimMargin(),
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    style = androidx.compose.ui.text.TextStyle(
                        brush = Brush.linearGradient(listOf(Color.Magenta, Color.Cyan)))
                )

                if (login.value) {
                    // login
                    Button (
                        onClick = {
                            showLoginDialog.value = true
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .width(200.dp),
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Text("Continue",
                            style = androidx.compose.ui.text.TextStyle(
                                brush = Brush.linearGradient(
                                    colors = rainbowColors // Gradient colors
                                )
                            )
                        )
                    }

                    // go to register
                    Button (
                        onClick = {
                            login.value = !login.value
                            userID.value = ""
                            userPhoneNumber.value = ""
                            userPassword.value = ""
                            userPasswordConfirm.value = ""
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .width(200.dp),
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Text("Register",
                            style = androidx.compose.ui.text.TextStyle(
                                brush = Brush.linearGradient(
                                    colors = rainbowColors // Gradient colors
                                )
                            )
                        )
                    }
                } else {
                    // register
                    Button (
                        onClick = {
                            showRegisterDialog.value = true
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .width(200.dp),
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Text("Register",
                            style = androidx.compose.ui.text.TextStyle(
                                brush = Brush.linearGradient(
                                    colors = rainbowColors // Gradient colors
                                )
                            )
                        )
                    }


                    // go back to login
                    Button(
                        onClick = {
                            login.value = !login.value
                            userID.value = ""
                            userPhoneNumber.value = ""
                            userPassword.value = ""
                            userPasswordConfirm.value = ""
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .width(200.dp),
                        shape = RoundedCornerShape(8.dp),
                    ){
                        Text(
                            "Login",
                            style = androidx.compose.ui.text.TextStyle(
                                brush = Brush.linearGradient(
                                    colors = rainbowColors // Gradient colors
                                )
                            )
                        )
                    }
                }

                LoginHandler(viewModel, userID.value, userPassword.value, showLoginDialog)
                RegisterHandler(viewModel, userID.value, userPhoneNumber.value, userPassword.value, showRegisterDialog)
            }
        }
    }
}

@Composable
fun LoginHandler (viewModel: UserLoginViewModel, userID: String, userPassword: String, showLoginDialog: MutableState<Boolean>) {
    viewModel.checkLogin(userID, userPassword)
    val resultPair by viewModel.loginResult
    val myContext = LocalContext.current

    if (resultPair.first && showLoginDialog.value) {

        AuthManager.login(userID)
        viewModel.getUserById(userID)

        if (viewModel.user.value?.questionnaire == true){
            myContext.startActivity(Intent(myContext, FoodQuestionnaire::class.java))
        } else{
            viewModel.updateUserQuestionnaireProcess(userID, true)
            myContext.startActivity(Intent(myContext, MainAppScreen::class.java))
        }
    }

    showLoginDialog.value = !resultPair.first && showLoginDialog.value

    if (showLoginDialog.value) {
        AlertDialog(
            onDismissRequest = { showLoginDialog.value = false },
            title = { Text(resultPair.second) },
            confirmButton = {
                Button(onClick = { showLoginDialog.value = false }) {
                    Text("OK")
                }
            }
        )
    }
}

@Composable
fun RegisterHandler (viewModel: UserLoginViewModel, userID: String, userPhoneNumber: String, password: String, showRegisterDialog: MutableState<Boolean>){
    viewModel.registerUser(userID, userPhoneNumber, password)
    val registrationResult by viewModel.registrationResult
    val resultPair = registrationResult
    val myContext = LocalContext.current

    if (resultPair.first && showRegisterDialog.value) {
        AuthManager.login(userID)
        viewModel.updateUserPassword(userID, password)
        viewModel.updateUserQuestionnaireProcess(userID, true)
        myContext.startActivity(Intent(myContext, FoodQuestionnaire::class.java))
    }
    showRegisterDialog.value = !resultPair.first && showRegisterDialog.value

    if (showRegisterDialog.value) {
        AlertDialog(
            onDismissRequest = { showRegisterDialog.value = false },
            title = { Text(resultPair.second) },
            confirmButton = {
                Button(onClick = { showRegisterDialog.value = false }) {
                    Text("OK")
                }
            }
        )
    }
}
