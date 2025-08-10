package com.fit2081.nutritrack_yinshi_34506241.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Insights
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.UserScoreViewModel
import com.fit2081.nutritrack_yinshi_34506241.screens.InsightPage
import com.fit2081.nutritrack_yinshi_34506241.screens.NutriCoach
import com.fit2081.nutritrack_yinshi_34506241.screens.ScoreHomePage
import com.fit2081.nutritrack_yinshi_34506241.screens.SettingsPage

@Composable
fun MyNavHost(innerPadding: PaddingValues, navControler: NavHostController, selectedItem: MutableState<Int>){
    val context = LocalContext.current
    val userScoreViewModel: UserScoreViewModel = viewModel(
        factory = UserScoreViewModel.UserScoreViewModelFactory(context)
    )
    NavHost(
        navController = navControler,
        startDestination = "Home"
    ){
        composable("Home") {
            ScoreHomePage(modifier = Modifier.padding(innerPadding), navControler, selectedItem, viewModel = userScoreViewModel)
        }
        composable("Insights") {
            InsightPage(modifier = Modifier.padding(innerPadding), navControler, selectedItem, viewModel = userScoreViewModel)
        }
        composable("NutriCoach") {
            NutriCoach(modifier = Modifier.padding(innerPadding), viewModel = userScoreViewModel)
        }

        composable("Settings") {
            SettingsPage(modifier = Modifier.padding(innerPadding), viewModel = userScoreViewModel)
        }
    }
}

@Composable
fun MyBottomAppBar(selectedItem: MutableState<Int>, navController: NavHostController) {

    val items = listOf("Home", "Insights", "NutriCoach", "Settings")

    NavigationBar{
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    when (item) {
                        "Home" -> Icon(Icons.Filled.Home, contentDescription = "home")
                        "Insights" -> Icon(Icons.Filled.Insights, contentDescription = "insights")
                        "NutriCoach" -> Icon(Icons.Filled.AutoAwesome, contentDescription = "NutriCoach")
                        "Settings" -> Icon(Icons.Filled.Settings, contentDescription = "settings")
                    }
                },
                label = { Text(item) },
                selected = selectedItem.value == index,
                onClick = {
                    selectedItem.value = index
                    navController.navigate(item)
                }
            )
        }
    }
}



