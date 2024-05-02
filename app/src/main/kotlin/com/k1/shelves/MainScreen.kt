package com.k1.shelves

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.k1.shelves.ui.BottomBarNavGraph
import com.k1.shelves.ui.BottomBarScreen
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val navController = rememberNavController()

    Scaffold(topBar = {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ), title = {
            Text("Shelves")
        })
    }, bottomBar = { BottomBar(navController = navController) }, snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    }, floatingActionButton = {
        if (navController.currentDestination?.route == BottomBarScreen.Home.route) {
            FloatingActionButton(onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Book", "Dismiss")
                }

            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    }) {
        BottomBarNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home, BottomBarScreen.Search, BottomBarScreen.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar {
        screens.forEach { screen ->
            AddBottomNavigationItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }

}

@Composable
fun RowScope.AddBottomNavigationItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBarItem(label = { Text(screen.title) },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        icon = { Icon(imageVector = screen.icon, contentDescription = "Navigation Icon") },
        modifier = modifier
    )
}
