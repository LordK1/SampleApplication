package com.k1.shelves.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title : String,
    val icon: ImageVector
) {
    data object Home : BottomBarScreen("home", "Home", Icons.Default.Home)
    data object Search : BottomBarScreen("search", "Search", Icons.Default.Search)
    data object Profile : BottomBarScreen("profile", "Profile", Icons.Default.Person)
}