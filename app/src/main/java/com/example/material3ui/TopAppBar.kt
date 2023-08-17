package com.example.material3ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


/**
 * Used for:
 *  - user understand where they currently are in the app (title)
 *  - navigation action icon (back button, nav. drawer)
 *  - other action icons (contextual actions like add to favorite, edit, e.t.c)
 */
@Composable
fun TopAppBarScreen(
    mainNavController: NavController
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            /**
             * Common Top app bar
             * Center for root screen of app
             * Medium - double height, need if title is long
             * Large - even more space
             */
            TopAppBar(
                title = {
                    Text(text = "Title")
                }
            )
        }
    ) { values ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = values) //always use padding values from scaffold as padding
        ) {
            items(20) {
                Text(
                    text = "Item $it",
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }

}