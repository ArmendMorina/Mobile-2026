/*
package com.example.ushtrimi_2.home

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ushtrimi_2.home.contacts.ContactsScreen
import com.example.ushtrimi_2.home.notifications.NotificationsScreen
import com.example.ushtrimi_2.home.settings.SettingsScreen
import com.example.ushtrimi_2.home.stories.StoriesScreen
import com.example.ushtrimi_2.nav.HomeRoutes

@Composable
fun HomeScreen(onOpenGallery: () -> Unit) {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        contentWindowInsets = WindowInsets(0),
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                               restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = stringResource(item.label)
                            )
                        },
                        label = { Text(stringResource(item.label)) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeRoutes.CONTACTS,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(HomeRoutes.CONTACTS) { ContactsScreen(onContactClick = onOpenGallery) }
            composable(HomeRoutes.NOTIFICATIONS) { NotificationsScreen() }
            composable(HomeRoutes.STORIES) { StoriesScreen() }
            composable(HomeRoutes.SETTINGS) { SettingsScreen() }
        }
    }
}
*/
