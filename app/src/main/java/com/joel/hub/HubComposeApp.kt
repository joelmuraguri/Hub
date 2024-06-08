package com.joel.hub

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joel.discover.anime.AnimeScreen
import com.joel.discover.comic.ComicScreen
import com.joel.discover.core.navigation.Screen
import com.joel.discover.core.navigation.navigationDrawerItems
import com.joel.discover.film.FilmScreen
import com.joel.discover.home.HomeScreen
import com.joel.discover.news.NewsScreen
import com.joel.hub.navigation.HubNavHost
import com.joel.presentation.ConnectivityViewModel
import com.joel.presentation.NetworkStatusSnackBar
import com.joel.presentation.R
import com.joel.presentation.ViewModelFactory
import com.joel.profile.ProfileScreen
import com.joel.search.SearchScreen
import kotlinx.coroutines.launch

@Composable
fun HubComposeApp(
    connectivityViewModel: ConnectivityViewModel = viewModel(factory = ViewModelFactory.Factory)
){

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }

    val isOffline by connectivityViewModel.isOffline.collectAsState()

    // If the user is not connected to the internet show a snack bar to inform them.
    val notConnectedMessage = stringResource(R.string.not_connected)

    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackbarHostState.showSnackbar(
                message = notConnectedMessage,
                duration = SnackbarDuration.Indefinite,
            )
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(
                    modifier = Modifier.width(270.dp),
                    drawerShape = RectangleShape,
                    drawerTonalElevation = 0.dp,
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(40.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        navigationDrawerItems.forEach {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp)
                                    .clickable(onClick = {
                                        navController.navigate(it.route) {
                                            popUpTo(Screen.Home.route)
                                        }
                                        scope.launch {
                                            drawerState.close()
                                        }
                                    }),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = it.icon),
                                    contentDescription = it.name,
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(end = 10.dp)
                                )
                                Text(
                                    text = it.name,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }
                        }
                    }
                }
            },
            content = {
                     HubNavHost(
                         navController = navController,
                         drawerState = drawerState,
                         scope = scope
                     )
            },
            modifier = Modifier
                .fillMaxSize()
        )
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .padding(bottom = 30.dp)
        ) {
            SnackbarHost(hostState = snackbarHostState)
        }
    }
}

