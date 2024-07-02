package com.joel.discover.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.joel.discover.core.components.AppBar
import kotlinx.coroutines.CoroutineScope

@Composable
fun HomeScreen(
    scope: CoroutineScope,
    onSearchClick: () -> Unit,
    onProfileClick: () -> Unit,
    drawerState: DrawerState
){

    Scaffold(
        topBar = {
            AppBar(
                screenTitle = "", onSearchClick = { onSearchClick() },
                scope = scope, drawerState = drawerState,
                onProfileClick = onProfileClick
                )
        },
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(text = "HUB")
        }
    }
}