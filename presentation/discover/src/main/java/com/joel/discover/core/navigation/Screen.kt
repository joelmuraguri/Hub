package com.joel.discover.core.navigation

sealed class Screen(val route : String) {
    data object Home : Screen("home_route")
    data object Profile : Screen("profile_route")
    data object Search : Screen("search_route")
    data object Anime : Screen("anime_route")
    data object Comic : Screen("comic_route")
    data object Film : Screen("film_route")
    data object News : Screen("news_route")
}

enum class NavRoutes{
    DISCOVER_ROUTE,
}

