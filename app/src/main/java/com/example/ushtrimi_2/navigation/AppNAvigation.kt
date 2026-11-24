package com.example.ushtrimi_2.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ushtrimi_2.LoginScreen
import com.example.ushtrimi_2.home.contacts.HomeScreen
import com.example.ushtrimi_2.home.gallery.GalleryScreen
import java.lang.reflect.Modifier

@Composable
fun AppNavigation() {
    val navigationControlloer = rememberNavController()

    NavHost(
        navController = navigationControlloer,
        startDestination = Routes.LOGIN,
    ) {
        composable(Routes.LOGIN) {
            LoginScreen() {
                navigationControlloer.navigate(Routes.HOME) {
                    popUpTo(Routes.LOGIN) {
                        inclusive = true
                    }
                }
            }
        }
        composable(Routes.HOME) {
            HomeScreen() {
                navigationControlloer.navigate(Routes.GALLERY)
            }

        }
        composable(Routes.GALLERY) {
            GalleryScreen(
                onGalleryItemClicked = {
                    //define new fullscreen with share options or whatever we can
                    //do with gallery item
                    //FullScreenGalleryItem()
                },
                onBack = {
                    navigationControlloer.navigate(Routes.HOME)
                }
            )

        }
    }
}

object Routes {
    const val LOGIN = "login"
    const val HOME = "home"
    const val GALLERY = "gallery"
    // other screen routes
}