package com.joel.discover.core.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.joel.discover.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    screenTitle : String,
    drawerState: DrawerState,
    onSearchClick: () -> Unit,
    onProfileClick: () -> Unit,
    scope: CoroutineScope
){

    CenterAlignedTopAppBar(
        title = {
           Text(text = screenTitle)
        },
        navigationIcon = {
            DrawerIcon(drawerState = drawerState, scope = scope)
        },
        actions = {
            SearchIcon(
                onSearchClick = onSearchClick
            )
            ProfileIcon {
                onProfileClick()
            }
        }
    )
}


@Composable
private fun DrawerIcon(
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    IconButton(onClick = {
        scope.launch {
            drawerState.open()
        }
    }) {
        Icon(
            painter = painterResource(id = R.drawable.menu),
            tint = MaterialTheme.colorScheme.onBackground,
            contentDescription = null
        )
    }
}

@Composable
private fun SearchIcon(
    onSearchClick : () -> Unit
) {

    IconButton(onClick = {
        onSearchClick()
    }) {
        Icon(
            painter = painterResource(id = R.drawable.search),
            tint = MaterialTheme.colorScheme.onBackground,
            contentDescription = null
        )
    }
}

@Composable
private fun ProfileIcon(
    onProfileClick : () -> Unit
) {

    IconButton(onClick = {
        onProfileClick()
    }) {
        Icon(
            painter = painterResource(id = R.drawable.profile),
            tint = MaterialTheme.colorScheme.onBackground,
            contentDescription = null
        )
    }
}