package com.example.material3ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChangeCircle
import androidx.compose.material.icons.filled.SwapCalls
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


/**
 * Used for:
 *  - user understand where they currently are in the app (title)
 *  - navigation action icon (back button, nav. drawer)
 *  - other action icons (contextual actions like add to favorite, edit, e.t.c)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarScreen(
    mainNavController: NavController
) {

    var currentTopBarType by remember {
        mutableIntStateOf(0)
    }
    var currentBehavior by remember {
        mutableIntStateOf(0)
    }

    val scrollBehavior = when (currentBehavior) {
        0 -> TopAppBarDefaults.pinnedScrollBehavior() // Change color of TopAbbBar when scrolling
        1 -> TopAppBarDefaults.enterAlwaysScrollBehavior() // Toolbar gets hidden when user scroll down, and appears on scroll up
        else -> TopAppBarDefaults.exitUntilCollapsedScrollBehavior() // Toolbar gets hidden when user scroll down and appears when scrolled to top
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection), //Connect scrollable content to TopAbbBar behavior
        topBar = {
            /**
             * Common Top app bar
             * Center for root screen of app
             * Medium - double height, need if title is long
             * Large - even more space
             */
            when (currentTopBarType) {
                0 -> {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(text = "Center TopAbbBar")
                        },
                        navigationIcon = { // back button or menu drawer
                            IconButton(
                                onClick = {
                                    mainNavController.popBackStack()
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Go Back"
                                )
                            }
                        },
                        actions = { // up to three actions allowed, if you need more - use menu button for them.
                            IconButton(onClick = {
                                if (currentTopBarType < 3) currentTopBarType++ else currentTopBarType =
                                    0
                            }) {
                                Icon(
                                    imageVector = Icons.Default.ChangeCircle,
                                    contentDescription = "Change top bar"
                                )
                            }
                            IconButton(
                                onClick = {
                                    if (currentBehavior < 2) currentBehavior++ else currentBehavior =
                                        0
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.SwapCalls,
                                    contentDescription = "Change behavior"
                                )
                            }
                        },
                        scrollBehavior = scrollBehavior // Use chosen TopAppBar behavior

                    )
                }

                1 -> {
                    TopAppBar(
                        title = {
                            Text(text = "Standard TopAppBar")
                        },
                        navigationIcon = { // back button or menu drawer
                            IconButton(
                                onClick = {
                                    mainNavController.popBackStack()
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Go Back"
                                )
                            }
                        },
                        actions = { // up to three actions allowed, if you need more - use menu button for them.
                            IconButton(onClick = {
                                if (currentTopBarType < 3) currentTopBarType++ else currentTopBarType =
                                    0
                            }) {
                                Icon(
                                    imageVector = Icons.Default.ChangeCircle,
                                    contentDescription = "Change top bar"
                                )
                            }
                            IconButton(
                                onClick = {
                                    if (currentBehavior < 2) currentBehavior++ else currentBehavior =
                                        0
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.SwapCalls,
                                    contentDescription = "Change behavior"
                                )
                            }
                        },
                        scrollBehavior = scrollBehavior // Use chosen TopAppBar behavior
                    )
                }

                2 -> {
                    MediumTopAppBar(
                        title = {
                            Text(text = "Medium TopAppBar")
                        },
                        navigationIcon = { // back button or menu drawer
                            IconButton(
                                onClick = {
                                    mainNavController.popBackStack()
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Go Back"
                                )
                            }
                        },
                        actions = { // up to three actions allowed, if you need more - use menu button for them.
                            IconButton(onClick = {
                                if (currentTopBarType < 3) currentTopBarType++ else currentTopBarType =
                                    0
                            }) {
                                Icon(
                                    imageVector = Icons.Default.ChangeCircle,
                                    contentDescription = "Change top bar"
                                )
                            }
                            IconButton(
                                onClick = {
                                    if (currentBehavior < 2) currentBehavior++ else currentBehavior =
                                        0
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.SwapCalls,
                                    contentDescription = "Change behavior"
                                )
                            }
                        },
                        scrollBehavior = scrollBehavior // Use chosen TopAppBar behavior
                    )
                }

                3 -> {
                    LargeTopAppBar(
                        title = {
                            Text(text = "Large TopAppBar")
                        },
                        navigationIcon = { // back button or menu drawer
                            IconButton(
                                onClick = {
                                    mainNavController.popBackStack()
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Go Back"
                                )
                            }
                        },
                        actions = { // up to three actions allowed, if you need more - use menu button for them.
                            IconButton(onClick = {
                                if (currentTopBarType < 3) currentTopBarType++ else currentTopBarType =
                                    0
                            }) {
                                Icon(
                                    imageVector = Icons.Default.ChangeCircle,
                                    contentDescription = "Change top bar"
                                )
                            }
                            IconButton(
                                onClick = {
                                    if (currentBehavior < 2) currentBehavior++ else currentBehavior =
                                        0
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.SwapCalls,
                                    contentDescription = "Change behavior"
                                )
                            }
                        },
                        scrollBehavior = scrollBehavior // Use chosen TopAppBar behavior
                    )
                }
            }
        }

        /**
         * Things under the TopAppBar
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