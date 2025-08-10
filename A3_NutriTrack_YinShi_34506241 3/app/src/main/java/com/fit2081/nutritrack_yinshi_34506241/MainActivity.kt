package com.fit2081.nutritrack_yinshi_34506241

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.fit2081.nutritrack_yinshi_34506241.ui.theme.NutriTrack_YinShi_34506241Theme
import com.fit2081.nutritrack_yinshi_34506241.data.ViewModel.UserLoginViewModel
import com.fit2081.nutritrack_yinshi_34506241.screens.WelcomePage


class MainActivity : ComponentActivity() {
    private val viewModel : UserLoginViewModel by viewModels(
        factoryProducer = { UserLoginViewModel.UserLoginFactory(this@MainActivity) }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NutriTrack_YinShi_34506241Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WelcomePage(viewModel, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
