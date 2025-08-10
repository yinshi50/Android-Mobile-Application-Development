package com.fit2081.nutritrack_yinshi_34506241.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    Box (
        modifier = Modifier
            .padding(16.dp)
    ){
        IconButton(
            onClick = { expanded = true }
        ){
            Icon(Icons.Filled.MoreVert, contentDescription = "More options")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ){
            DropdownMenuItem(
                text = { Text("Edit") },
                onClick = { /* TODO: Handle menu item click */ },
                leadingIcon = { Icon(Icons.Filled.Edit, contentDescription = "Edit") }
            )

            DropdownMenuItem(
                text = { Text("Setting") },
                onClick = { /* TODO: Handle menu item click */ },
                leadingIcon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") }
            )

            HorizontalDivider ()

            DropdownMenuItem(
                text = { Text("Send Feedback") },
                onClick = { /* TODO: Handle menu item click */ },
                leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = "Send Feedback") },
                trailingIcon = { Text("F11", textAlign = TextAlign.Center) }
            )
        }
    }
}
