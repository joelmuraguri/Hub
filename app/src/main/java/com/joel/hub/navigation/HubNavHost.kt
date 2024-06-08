package com.joel.hub.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.joel.discover.anime.AnimeScreen
import com.joel.discover.comic.ComicScreen
import com.joel.discover.core.navigation.Screen
import com.joel.discover.film.FilmScreen
import com.joel.discover.home.HomeScreen
import com.joel.discover.news.NewsScreen
import com.joel.profile.ProfileScreen
import com.joel.search.SearchScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun HubNavHost(
    navController: NavHostController,
    drawerState: DrawerState,
    scope : CoroutineScope
){

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route){
            HomeScreen(drawerState = drawerState, scope = scope,
                onSearchClick = { navController.navigate(Screen.Search.route) },
                onProfileClick = { navController.navigate(Screen.Profile.route)}
            )
        }
        composable(Screen.Anime.route){
            AnimeScreen(drawerState = drawerState, scope = scope,
                onSearchClick = { navController.navigate(Screen.Search.route) },
                onProfileClick = { navController.navigate(Screen.Profile.route)}
            )
        }
        composable(Screen.Comic.route){
            ComicScreen(drawerState = drawerState, scope = scope,
                onSearchClick = { navController.navigate(Screen.Search.route) },
                onProfileClick = { navController.navigate(Screen.Profile.route)}
            )
        }
        composable(Screen.Film.route){
            FilmScreen(drawerState = drawerState, scope = scope,
                onSearchClick = { navController.navigate(Screen.Search.route) },
                onProfileClick = { navController.navigate(Screen.Profile.route)}
            )
        }
        composable(Screen.News.route){
            NewsScreen(drawerState = drawerState, scope = scope,
                onSearchClick = { navController.navigate(Screen.Search.route) },
                onProfileClick = { navController.navigate(Screen.Profile.route)}
            )
        }
        composable(Screen.Search.route){
            SearchScreen {
                navController.popBackStack()
            }
        }
        composable(Screen.Profile.route){
            ProfileScreen {
                navController.popBackStack()
            }
        }
    }

}