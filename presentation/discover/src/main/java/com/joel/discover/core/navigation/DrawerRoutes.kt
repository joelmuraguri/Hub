package com.joel.discover.core.navigation

import com.joel.discover.R

data class NavigationDrawerItem(
    val name: String,
    val route: String,
    val icon: Int,
)

val navigationDrawerItems = listOf(
    NavigationDrawerItem(
        name = "Anime",
        route = Screen.Anime.route,
        icon = R.drawable.anime
    ),
    NavigationDrawerItem(
        name = "Comic",
        route = Screen.Comic.route,
        icon = R.drawable.comics
    ),
    NavigationDrawerItem(
        name = "Films",
        route = Screen.Film.route,
        icon = R.drawable.film
    ),
    NavigationDrawerItem(
        name = "News",
        route = Screen.News.route,
        icon = R.drawable.news
    )
)

