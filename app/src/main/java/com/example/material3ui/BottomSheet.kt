package com.example.material3ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SwitchLeft
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScreen(
    mainNavController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var drawerType by remember{
            mutableIntStateOf(0)
        }
        Column {
            Button(onClick = { drawerType = if (drawerType == 1)  0 else 1 }) {
                Icon(imageVector = Icons.Default.SwitchLeft, contentDescription = null)
            }
            when (drawerType) {
                0 -> ModalBottomSheet()
                1 -> ScaffoldBottomSheet()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ModalBottomSheet() {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            isSheetOpen = true
        }) {
            Text(text = "Open sheet")
        }
    }
    if (isSheetOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isSheetOpen = false }
        ) {
            Column {
                Text(text = "Bottom text")
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Button")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldBottomSheet() {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetContent = {
                Text(text = "Bottom text")
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Button")
                }
            },
            sheetPeekHeight = 0.dp, // Non-hideable part of sheet
            //sheetDragHandle = { } // customize drag handler
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    scope.launch{ // Due to animation is async
                        scaffoldState.bottomSheetState.expand()
                    }
                }) {
                    Text(text = "Open sheet")
                }
            }
        }
    }
}