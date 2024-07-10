package com.joel.discover.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joel.discover.home.DiscoverScreen

const val DISCOVER_ROUTE = "discover_route"

fun NavGraphBuilder.discoverNavigation(
    updateBottomBarState: (Boolean) -> Unit,
    updateTopBarState: (Boolean) -> Unit
){
    composable(route = DISCOVER_ROUTE){
        updateBottomBarState(true)
        updateTopBarState(true)
        DiscoverScreen()
    }

}