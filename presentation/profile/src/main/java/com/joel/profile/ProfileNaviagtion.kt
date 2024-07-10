package com.joel.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val PROFILE_ROUTE = "profile_route"

fun NavGraphBuilder.profileNavigation(
    updateBottomBarState: (Boolean) -> Unit,
    updateTopBarState: (Boolean) -> Unit,
    popBackStack : () -> Unit
){
    composable(route = PROFILE_ROUTE){
        updateBottomBarState(false)
        updateTopBarState(false)
        ProfileScreen(popBackStack)
    }

}