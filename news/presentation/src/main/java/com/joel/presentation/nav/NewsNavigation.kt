package com.joel.presentation.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joel.presentation.NewsScreen

const val NEWS_ROUTE = "news_route"

fun NavGraphBuilder.newsNavigation(
    updateBottomBarState: (Boolean) -> Unit,
    updateTopBarState: (Boolean) -> Unit
){

    composable(route = NEWS_ROUTE){
        updateBottomBarState(true)
        updateTopBarState(true)
        NewsScreen()
    }

}