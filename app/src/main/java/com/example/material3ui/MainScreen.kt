package com.example.material3ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(
    mainNavController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 120.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FilledTonalButton(onClick = {
            mainNavController.navigate(Screen.ButtonsScreen.route)
        }) {
            Text(text = "Buttons")
        }
        FilledTonalButton(onClick = {
            mainNavController.navigate(Screen.TextFieldsScreen.route)
        }) {
            Text(text = "Text Fields")
        }
    }
}