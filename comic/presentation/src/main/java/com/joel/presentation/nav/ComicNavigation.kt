package com.joel.presentation.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joel.presentation.ComicScreen
import com.joel.presentation.ComicViewModel

const val COMIC_ROUTE = "comic_route"

fun NavGraphBuilder.comicNavigation(
    updateBottomBarState: (Boolean) -> Unit,
    updateTopBarState: (Boolean) -> Unit,
    comicViewModel: ComicViewModel
){

    composable(route = COMIC_ROUTE){
        updateBottomBarState(true)
        updateTopBarState(true)
        ComicScreen(
            comicViewModel = comicViewModel
        )
    }

}