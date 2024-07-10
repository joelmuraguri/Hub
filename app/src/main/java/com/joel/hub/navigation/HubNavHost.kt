package com.joel.hub.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.joel.discover.nav.discoverNavigation
import com.joel.hub.di.comic.ComicViewModelFactory
import com.joel.presentation.ComicViewModel
import com.joel.presentation.nav.comicNavigation
import com.joel.presentation.nav.filmNavigation
import com.joel.presentation.nav.newsNavigation
import com.joel.profile.profileNavigation
import com.joel.search.searchNavigation

@Composable
fun HubNavHost(
    navController: NavHostController,
    updateBottomBarState: (Boolean) -> Unit,
    updateTopBarState: (Boolean) -> Unit,
    startDestination : String,
    comicViewModel: ComicViewModel = viewModel(factory = ComicViewModelFactory.Factory)
){
    NavHost(navController = navController, startDestination = startDestination) {
        discoverNavigation(updateBottomBarState, updateTopBarState)
        comicNavigation(
            updateBottomBarState,
            updateTopBarState,
            comicViewModel
        )
        filmNavigation(updateBottomBarState, updateTopBarState)
        newsNavigation(updateBottomBarState, updateTopBarState)
        searchNavigation(updateBottomBarState, updateTopBarState, popBackStack = {navController.popBackStack()} )
        profileNavigation(updateBottomBarState, updateTopBarState, popBackStack = {navController.popBackStack()} )
    }
}