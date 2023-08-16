package com.example.material3ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ButtonsScreen(
    mainNavController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 120.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /**
         * Filled Material3 Button
         * Big impact button.
         * Use only for main action, like subscribe, save, confirm e.t.c.
         * Colors defaults are from Theme (MaterialTheme by default).
         */
        Button(
            onClick = { /*TODO*/ },
/*              colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.Black,
            )*/
        ) {
            Text(text = "Filled button")
        }


        /**
         * Material3 Button with Icon
         * Use size = 18.dp and 8.dp Spacer
         */
        Button(
            onClick = { /*TODO*/ },
        ) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Button with Icon")
        }

        /**
         * Elevated Material3 Button
         * Use if button is on image / content.
         */
        ElevatedButton(
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Elevated button")
        }

        /**
         * Filled Tonal Material3 Button
         * Use if there several buttons
         */
        FilledTonalButton(
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Filled tonal button")
        }

        /**
         * Outlined Material3 Button
         * If button is not so important
         * like back button, sign in (if you have highlighted sign up) e.t.c.
         */
        OutlinedButton(
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Outlined button")
        }

        /**
         * Text Material3 Button
         * Least prominent button
         * for things user very unlikely will press
         */
        TextButton(
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Text button")
        }



    }
}