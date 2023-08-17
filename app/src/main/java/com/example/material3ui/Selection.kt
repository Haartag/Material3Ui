package com.example.material3ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SelectionScreen(
    mainNavController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 40.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Checkboxes()
        TestSwitch()
        TestSwitchWithIcons()
        RadioButtons()

    }
}

/**
 * Checkboxes. Use when user can pick one, zero or multiple related options.
 * Must be related! Used for different options.
 * Best practice - checkbox must be usable if you click on next, not only on checkbox.
 * Text commonly on the right of checkbox.
 */
data class ToggleableInfo(
    val isChecked: Boolean,
    val text: String
)

@Composable
fun Checkboxes() {
    val checkboxes = remember {
        mutableStateListOf(
            ToggleableInfo(false, "first text"),
            ToggleableInfo(false, "second text"),
            ToggleableInfo(false, "third text"),
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        /**
         * Tri-state checkbox. Can be used as switch to group of checkboxes.
         */
        var triState by remember {
            mutableStateOf(ToggleableState.Indeterminate)
        }
        val toggleTriState = {
            triState = when (triState) {
                ToggleableState.Indeterminate -> ToggleableState.On
                ToggleableState.Off -> ToggleableState.On
                ToggleableState.On -> ToggleableState.Off
            }
            checkboxes.indices.forEach { index ->
                checkboxes[index] = checkboxes[index].copy(
                    isChecked = triState == ToggleableState.On
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    toggleTriState()
                }
                .padding(end = 16.dp) //fix short shadow on the right on-click
        ) {
            TriStateCheckbox(
                state = triState,
                onClick = toggleTriState
            )
            Text(text = "Main text")
        }


        checkboxes.forEachIndexed() { index, info ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    ) //this padding dont make shadow on click because it above clickable
                    .clickable {
                        checkboxes[index] = info.copy(isChecked = !info.isChecked)
                    }
                    .padding(end = 16.dp) //fix short shadow on the right on-click
            ) {
                Checkbox(
                    checked = info.isChecked,
                    onCheckedChange = { isChecked ->
                        checkboxes[index] = info.copy(isChecked = isChecked)
                    }
                )
                Text(text = info.text)
            }
        }
    }
}

/**
 * Switch. Use for independent options (ex. settings).
 * Must have immediately effect - user should not need to press some kind of confirm,
 * action must just enable/disable.
 * Text on the left of switch.
 */
@Composable
fun TestSwitch() {
    var switchState by remember {
        mutableStateOf(
            ToggleableInfo(
                isChecked = false,
                text = "Switch text"
            )
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = switchState.text)
        Switch(
            checked = switchState.isChecked,
            onCheckedChange = {
                switchState = switchState.copy(isChecked = !switchState.isChecked)
            }
        )
    }
}

/**
 * Switch with icons. Use simple and obvious icons for switch
 */
@Composable
fun TestSwitchWithIcons() {
    var switchState by remember {
        mutableStateOf(
            ToggleableInfo(
                isChecked = false,
                text = "Switch text with icons"
            )
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = switchState.text)
        Switch(
            checked = switchState.isChecked,
            onCheckedChange = {
                switchState = switchState.copy(isChecked = !switchState.isChecked)
            },
            thumbContent = {
                Icon(
                    imageVector = if (switchState.isChecked) Icons.Default.Check else Icons.Default.Close,
                    contentDescription = null
                )
            }
        )
    }
}

/**
 * Radio buttons. Use when user need choose only one option.
 */
@Composable
fun RadioButtons() {
    val radioButtons = remember {
        mutableStateListOf(
            ToggleableInfo(true, "first text"),
            ToggleableInfo(false, "second text"),
            ToggleableInfo(false, "third text"),
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        radioButtons.forEachIndexed() { index, info ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                        radioButtons.replaceAll {
                            it.copy(
                                isChecked = it.text == info.text
                            )
                        }
                    }
                    .padding(end = 16.dp)
            ) {
                RadioButton(
                    selected = info.isChecked,
                    onClick = {
                        radioButtons.replaceAll {
                            it.copy(
                                isChecked = it.text == info.text
                            )
                        }
                    }
                )
                Text(text = info.text)
            }
        }
    }
}