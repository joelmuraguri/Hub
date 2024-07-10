package com.joel.hub.navigation

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.joel.hub.R
import com.joel.hub.ui.theme.HubTheme

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomAppBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        bottomBarNavigationList.forEach { destination ->
            val selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true
            NavigationBarItem(
                selected = selected,
                icon = {
                    Icon(
                        painter = painterResource(id = destination.icon!!),
                        contentDescription = destination.title,
                        tint = if (selected) Color(0xFF5180f1) else Color.Black
                    )
                },
                label = { Text(text = destination.title) },
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(Screens.Discover.route){
                            inclusive = true
                            saveState = true
                        }
                    }
                },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onSearchClick : () -> Unit,
    onProfileClick : () -> Unit
){

    CenterAlignedTopAppBar(
        title = { /*TODO*/ },
        actions = {
            IconButton(onClick = { onSearchClick() }) {
                Icon(painter = painterResource(id = R.drawable.search), contentDescription = null)
            }
            IconButton(onClick = { onProfileClick() }) {
                Icon(painter = painterResource(id = com.joel.profile.R.drawable.profile), contentDescription = null)
            }
        }
    )

}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    HubTheme {
        BottomNavigationBar(rememberNavController())
    }
}