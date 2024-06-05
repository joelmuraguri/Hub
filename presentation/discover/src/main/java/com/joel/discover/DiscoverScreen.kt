package com.joel.discover

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joel.discover.anime.AnimeScreen
import com.joel.discover.comic.ComicScreen
import com.joel.discover.components.AppBar
import com.joel.discover.core.navigation.Screen
import com.joel.discover.core.navigation.navigationDrawerItems
import com.joel.discover.film.FilmScreen
import com.joel.discover.news.NewsScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DiscoverScreen(){

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        content = { it ->
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    ModalDrawerSheet(
                        modifier = Modifier.width(270.dp),
                        drawerShape = RectangleShape,
                        drawerTonalElevation = 0.dp,
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(40.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            navigationDrawerItems.forEach {it ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 20.dp)
                                        .clickable(onClick = {
                                            navController.navigate(it.route){
                                                popUpTo(Screen.Home.route)
                                            }
                                            scope.launch {
                                                drawerState.close()
                                            }
                                        }),
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(id = it.icon),
                                        contentDescription = it.name,
                                        tint = Color.White,
                                        modifier = Modifier
                                            .size(35.dp)
                                            .padding(end = 10.dp)
                                    )
                                    Text(
                                        text = it.name,
                                        fontSize = 15.sp,
//                                        fontFamily = poppinsFamily,
                                        fontWeight = FontWeight.Medium,
                                        color = Color.White,
                                        modifier = Modifier.align(Alignment.CenterVertically)
                                    )
                                }
                            }
                        }
                    }
                },
                content = {
                    NavHost(navController = navController, startDestination = Screen.Home.route) {
                        composable(Screen.Home.route){
                            DefaultScreen(drawerState = drawerState, scope = scope, onSearchClick = { })
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
                },
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(it)
            )
        },

    )
}

@Composable
fun DefaultScreen(
    scope: CoroutineScope,
    onSearchClick: () -> Unit,
    drawerState: DrawerState
){

    Scaffold(
        topBar = {
            AppBar(screenTitle = "", onSearchClick = { onSearchClick() }, scope = scope, drawerState = drawerState)
        },
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(text = "HUB")
        }
    }
}