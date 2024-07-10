package com.joel.presentation.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joel.presentation.FilmScreen

const val FILM_ROUTE = "film_route"

fun NavGraphBuilder.filmNavigation(
    updateBottomBarState: (Boolean) -> Unit,
    updateTopBarState: (Boolean) -> Unit
){

    composable(route = FILM_ROUTE){
        updateBottomBarState(true)
        updateTopBarState(true)
        FilmScreen()
    }

}