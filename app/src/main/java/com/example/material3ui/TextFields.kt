package com.example.material3ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.Details
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TextFieldsScreen(
    mainNavController: NavController
) {

    /**
     * Mix TextField types in one screen (and maybe in one app) is bad idea
     *
     */
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 120.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /**
         * Filled text field
         */
        var filledText by remember {
            mutableStateOf("")
        }
        TextField(
            value = filledText,
            onValueChange = {
                filledText = it
            }
        )

        /**
         * Filled text field (styled)
         */
        var filledStyledTextOne by remember {
            mutableStateOf("")
        }
        TextField(
            value = filledStyledTextOne,
            onValueChange = {
                filledStyledTextOne = it
            },
            //enabled = false   disable text field
            //readOnly = true   disable text field, but user still can copy text from it
            label = {
                Text(text = "Label text")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Abc,
                    contentDescription = null
                )
            },
            suffix = {
                Text(text = "--Suffix")
            },
            supportingText = {
                Text(text = "Supporting text") // ex. for "*requested" or some explanation or for errors
            },
            isError = false, //some fields become error (red)
            //visualTransformation = PasswordVisualTransformation()
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters,
                autoCorrect = false,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { }
            ),
        )

        /**
         * Filled text field (styled)
         */
        var filledStyledTextTwo by remember {
            mutableStateOf("")
        }
        TextField(
            value = filledStyledTextTwo,
            onValueChange = {
                filledStyledTextTwo = it
            },
            //enabled = false   disable text field
            //readOnly = true   disable text field, but user still can copy text from it
            textStyle = LocalTextStyle.current.copy(   //change something in default text style
                textAlign = TextAlign.Right
            ),
            placeholder = {
                Text(text = "Placeholder text")
            },
            trailingIcon = { // you can use clickable icon, to make "clear text" button, or something else
                Icon(
                    imageVector = Icons.Default.Details,
                    contentDescription = null
                )
            },
            prefix = {
                Text(text = "Prefix--")
            },
            supportingText = {
                Text(text = "Supporting text") // ex. for "*requested" or some explanation or for errors
            },
            isError = true, //some fields become error (red)
            //visualTransformation = PasswordVisualTransformation()
            keyboardOptions = KeyboardOptions(
                //capitalization = KeyboardCapitalization.Characters
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { }
            ),
        )

        /**
         * Outlined text field
         */
        var outlinedText by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = outlinedText,
            onValueChange = {
                outlinedText = it
            },
        )

        /**
         * Outlined styled text field
         */
        var outlinedStyledTextOne by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = outlinedStyledTextOne,
            onValueChange = {
                outlinedStyledTextOne = it
            },
            label = {
                Text(text = "Label text")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Abc,
                    contentDescription = null
                )
            },
            suffix = {
                Text(text = "--Suffix")
            },
            supportingText = {
                Text(text = "Supporting text")
            },
            isError = false,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters,
                autoCorrect = false,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { }
            ),
        )

        /**
         * Outlined styled text field
         */
        var outlinedStyledTextTwo by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = outlinedStyledTextTwo,
            onValueChange = {
                outlinedStyledTextTwo = it
            },
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Right
            ),
            placeholder = {
                Text(text = "Placeholder text")
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Details,
                    contentDescription = null
                )
            },
            prefix = {
                Text(text = "Prefix--")
            },
            supportingText = {
                Text(text = "Supporting text")
            },
            isError = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { }
            ),
        )
    }
}