package ir.fatemelyasi.foodi.view

import FoodScreen
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.fatemelyasi.foodi.view.screens.AuthScreen
import ir.fatemelyasi.foodi.view.screens.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("main", Context.MODE_PRIVATE)
    val userLogin = sharedPreferences.getBoolean("userLogin", false)

    NavHost(navController = navController, startDestination =if (userLogin) "home" else "auth") {
        composable("auth") {
            AuthScreen(navController=navController)
        }
        composable("home") {
            HomeScreen(navController=navController)
        }
        composable("food") {
            FoodScreen(navController=navController)
        }

    }
}