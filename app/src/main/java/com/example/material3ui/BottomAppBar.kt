package com.example.material3ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.RamenDining
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


/**
 * Use only for smartphones/tablets, not for big screens.
 * Only use if have at least 2 actions to show.
 * If more then 3 actions, hide the least important of them under menu.
 * Should not use for navigation.
 */
@Composable
fun BottomAppBarScreen(
    mainNavController: NavController
) {

    var currentBottomBarType by remember {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            when (currentBottomBarType) {
                /**
                 * Bottom bar with actions and (optional) floating button
                 */
                0 -> {
                    BottomAppBar(
                        actions = {
                            IconButton(onClick = { currentBottomBarType = 1}) {
                                Icon(imageVector = Icons.Default.SwapHoriz, contentDescription = "swap bottom bar")
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Default.Headphones, contentDescription = null)
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Default.Language, contentDescription = null)
                            }
                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Default.Construction, contentDescription = null)
                            }
                        }
                    )
                }
                /**
                 * Bottom bar with custom content
                 */
                1 -> {
                    BottomAppBar {
                        IconButton(onClick = { currentBottomBarType = 0}) {
                            Icon(imageVector = Icons.Default.SwapHoriz, contentDescription = "swap bottom bar")
                        }
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(text = "Bottom text")
                        Icon(imageVector = Icons.Default.RamenDining, contentDescription = null)

                    }
                }
            }

        }
        /**
         * Things above the Bottom Bar
         */
    ) { values ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = values) //always use padding values from scaffold as padding
        ) {
            items(99) {
                Text(
                    text = "Item $it",
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }

}