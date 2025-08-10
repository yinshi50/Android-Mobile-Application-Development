package com.fit2081.nutritrack_yinshi_34506241.ui.components

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TopAppBarExample(title: String = "Login in"){
    val context = LocalContext.current
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors
            (
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),

        title = {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 20.sp
            )
        },

        navigationIcon = {
//            IconButton(onClick = { context.startActivity(Intent(context, SecondActivity::class.java)) }) {
//                Icon(Icons.Filled.Menu, contentDescription = "Menu")
//            }
            IconButton(onClick = { onBackPressedDispatcher?.onBackPressed() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Localized description")
            }
        },

        actions = {
            MyDropdownMenu()
        }, scrollBehavior = scrollBehavior,
    )
}
