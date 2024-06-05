package com.joel.hub.navigation

//@Composable
//fun HubNavHost(
//    navHostController: NavHostController
//){
//
//    val drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//
//    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
//        composable(Screen.Home.route){
//            HomeScreen(drawerState = drawerState, scope = scope, onSearchClick = {})
//        }
//        composable(Screen.Anime.route){
//            AnimeScreen(drawerState = drawerState, scope = scope, onSearchClick = {})
//        }
//        composable(Screen.Comic.route){
//            ComicScreen(drawerState = drawerState, scope = scope, onSearchClick = {})
//        }
//        composable(Screen.Film.route){
//            FilmScreen(drawerState = drawerState, scope = scope, onSearchClick = {})
//        }
//        composable(Screen.News.route){
//            NewsScreen(drawerState = drawerState, scope = scope, onSearchClick = {})
//        }
//    }
//
//}