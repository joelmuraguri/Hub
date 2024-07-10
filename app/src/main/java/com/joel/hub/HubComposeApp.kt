package com.joel.hub

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.joel.discover.nav.DISCOVER_ROUTE
import com.joel.hub.navigation.BottomNavigationBar
import com.joel.hub.navigation.HubNavHost
import com.joel.hub.navigation.TopBar
import com.joel.presentation.ConnectivityViewModel
import com.joel.presentation.ViewModelFactory
import com.joel.profile.PROFILE_ROUTE
import com.joel.search.SEARCH_ROUTE

@Composable
fun HubComposeApp(
    connectivityViewModel: ConnectivityViewModel = viewModel(factory = ViewModelFactory.Factory),
){

    val navController = rememberNavController()
    val snackBarHostState = remember { SnackbarHostState() }
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val topBarState = rememberSaveable { (mutableStateOf(true)) }

    val isOffline by connectivityViewModel.isOffline.collectAsState()

    val notConnectedMessage = "You're not connected to the Internet"

    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackBarHostState.showSnackbar(
                message = notConnectedMessage,
                duration = SnackbarDuration.Indefinite,
            )
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { if (bottomBarState.value) BottomNavigationBar(navController) },
        snackbarHost = { SnackbarHost(snackBarHostState) },
        topBar = { if (topBarState.value) TopBar(
            onSearchClick = { navController.navigate(SEARCH_ROUTE) },
            onProfileClick = {navController.navigate(PROFILE_ROUTE) } )}
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {
            HubNavHost(
                navController = navController,
                updateBottomBarState = { bottomBarState.value = it },
                startDestination = DISCOVER_ROUTE,
                updateTopBarState = { topBarState.value = it}
            )
        }
    }
}

