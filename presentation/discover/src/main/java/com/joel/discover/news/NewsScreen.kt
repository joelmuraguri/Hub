package com.joel.discover.news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.joel.discover.components.AppBar
import kotlinx.coroutines.CoroutineScope

@Composable
fun NewsScreen(
    scope: CoroutineScope,
    onSearchClick: () -> Unit,
    drawerState: DrawerState
) {

    Scaffold(
        topBar = {
            AppBar(screenTitle = "News", onSearchClick = { onSearchClick() }, scope = scope, drawerState = drawerState)
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(text = "NEWS")
        }
    }
}