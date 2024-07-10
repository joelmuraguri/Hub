package com.joel.hub.navigation

import com.joel.discover.R
import com.joel.discover.nav.DISCOVER_ROUTE
import com.joel.presentation.nav.COMIC_ROUTE
import com.joel.presentation.nav.FILM_ROUTE
import com.joel.presentation.nav.NEWS_ROUTE
import com.joel.profile.PROFILE_ROUTE
import com.joel.search.SEARCH_ROUTE

sealed class Screens (
    val route : String,
    val icon : Int?,
    val title : String
){
    data object Comic : Screens(COMIC_ROUTE, R.drawable.comics, "Comic")
    data object Film : Screens(FILM_ROUTE, R.drawable.film, "Film")
    data object News : Screens(NEWS_ROUTE, R.drawable.news, "News")
    data object Discover : Screens(DISCOVER_ROUTE, com.joel.hub.R.drawable.explore, "Discover")
    data object Search : Screens(SEARCH_ROUTE, icon = null, "Search")
    data object Profile : Screens(PROFILE_ROUTE, icon = null, "Profile")
}

val bottomBarNavigationList = listOf(
    Screens.Discover,
    Screens.Comic,
    Screens.Film,
    Screens.News,
)