package ru.itis.example.summerpractice.Kristina.thirdday

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppRoot(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = EnterNumberScreen
    ) {
        composable<EnterNumberScreen>{
            EnterNumberScreen(navController = navHostController)
        }

        composable<CatalogScreen>{
            CatalogScreen()
        }
    }
}