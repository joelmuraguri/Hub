package com.joel.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SEARCH_ROUTE = "search_route"

fun NavGraphBuilder.searchNavigation(
    updateBottomBarState: (Boolean) -> Unit,
    updateTopBarState: (Boolean) -> Unit,
    popBackStack : () -> Unit
){
    composable(route = SEARCH_ROUTE){
        updateBottomBarState(false)
        updateTopBarState(false)
        SearchScreen(popBackStack)
    }

}