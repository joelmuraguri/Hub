package com.joel.hub.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.joel.discover.DefaultScreen
import com.joel.discover.anime.AnimeScreen
import com.joel.discover.comic.ComicScreen
import com.joel.discover.core.navigation.Screen
import com.joel.discover.film.FilmScreen
import com.joel.discover.news.NewsScreen

@Composable
fun HubNavHost(
    navHostController: NavHostController
){

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route){
            DefaultScreen(drawerState = drawerState, scope = scope, onSearchClick = {})
        }
        composable(Screen.Anime.route){
            AnimeScreen(drawerState = drawerState, scope = scope, onSearchClick = {})
        }
        composable(Screen.Comic.route){
            ComicScreen(drawerState = drawerState, scope = scope, onSearchClick = {})
        }
        composable(Screen.Film.route){
            FilmScreen(drawerState = drawerState, scope = scope, onSearchClick = {})
        }
        composable(Screen.News.route){
            NewsScreen(drawerState = drawerState, scope = scope, onSearchClick = {})
        }
    }

}