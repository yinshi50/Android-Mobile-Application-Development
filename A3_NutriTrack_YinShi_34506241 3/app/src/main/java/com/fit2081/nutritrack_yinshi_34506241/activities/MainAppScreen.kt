package com.fit2081.nutritrack_yinshi_34506241.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.UserLoginViewModel
import com.fit2081.nutritrack_yinshi_34506241.navigation.MyBottomAppBar
import com.fit2081.nutritrack_yinshi_34506241.navigation.MyNavHost
import com.fit2081.nutritrack_yinshi_34506241.ui.theme.NutriTrack_YinShi_34506241Theme

class MainAppScreen : ComponentActivity() {
    private val viewModel: UserLoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NutriTrack_YinShi_34506241Theme {
                val navController: NavHostController = rememberNavController()
                val bottomBarSelector = remember {mutableStateOf(0)}
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        MyBottomAppBar(bottomBarSelector,navController)
                    }
                ){ innerPadding ->
                    Column(){
                        MyNavHost(innerPadding, navController, bottomBarSelector)
                    }
                }
            }
        }
    }
}

