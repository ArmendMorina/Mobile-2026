package com.example.ushtrimi_2.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ushtrimi_2.LoginScreen
import com.example.ushtrimi_2.home.contacts.HomeScreen
import com.example.ushtrimi_2.home.gallery.FullScreenGalleryItem
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
            HomeScreen() { contactId ->
                navigationControlloer.navigate(Routes.navigateToGalleryWithContactId(contactId)/*"gallery/${contactId}"*/)
            }
        }

        composable(
            route = Routes.GALLERY,
            arguments = listOf(
                navArgument(Routes.CONTACT_ID) { type = NavType.StringType }
            )
        ) { navBackStackEntry ->

            val contactId = navBackStackEntry.arguments?.getString(Routes.CONTACT_ID) ?: ""

            GalleryScreen(
                contactId,
                onGalleryItemClicked = { galleryItemId ->
                    navigationControlloer.navigate("galleryItem/$galleryItemId")
                },
                onBack = {
                    navigationControlloer.popBackStack()
                }
            )

        }

        composable(
            route = "galleryItem/{galleryItemId}",
            arguments = listOf(
                navArgument("galleryItemId") { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            val galleryItemID = navBackStackEntry.arguments?.getInt("galleryItemId") ?: -1
            FullScreenGalleryItem(
                drawableId = galleryItemID
            ) {
                navigationControlloer.popBackStack()
            }
        }
    }
}

object Routes {
    const val LOGIN = "login"
    const val HOME = "home"

    const val GALLERY_ROUTE = "gallery"
    const val CONTACT_ID = "contactId"
    const val GALLERY = "$GALLERY_ROUTE/{$CONTACT_ID}"
    // other screen routes

    fun navigateToGalleryWithContactId(contactId: String): String {
        return "$GALLERY_ROUTE/$contactId"
    }
}