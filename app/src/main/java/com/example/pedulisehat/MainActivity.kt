package com.example.pedulisehat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pedulisehat.screen.Screen
import com.example.pedulisehat.ui.theme.PeduliSehatTheme
import com.example.pedulisehat.view.AboutScreen
import com.example.pedulisehat.view.DetailCategoryScreen
import com.example.pedulisehat.view.DetailProductScreen
import com.example.pedulisehat.view.FindScreen
import com.example.pedulisehat.view.HomeScreen
import com.example.pedulisehat.viewModel.CategoryVM
import com.example.pedulisehat.viewModel.ProductVM
import com.example.pedulisehat.viewModel.ProfileVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            PeduliSehatTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Navigations()
                }
            }
        }
    }

    @Composable
    fun Navigations() {
        val navController = rememberNavController()
        val start = Screen.Home.route

        NavHost(
            navController = navController,
            startDestination = start
        ) {
            composable(Screen.Home.route){
                val categoryVM = CategoryVM()
                val productVM = ProductVM()
                HomeScreen(navController = navController,categoryVM = categoryVM, productVM = productVM)
            }

            composable(Screen.FInd.route){
                val productVM = ProductVM()
                FindScreen(navController = navController, productVM = productVM)
            }

            composable(Screen.About.route){
                val profileVM = ProfileVM()
                AboutScreen(navController = navController, profileVM = profileVM)
            }

            composable(
                route = Screen.DetailCategory.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                val categoryId = backStackEntry.arguments?.getInt("id")
                categoryId?.let {
                    DetailCategoryScreen(navController = navController, id = it)
                }
            }

            composable(
                route = Screen.DetailProduct.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                val productId = backStackEntry.arguments?.getInt("id")
                productId?.let {
                    DetailProductScreen(navController = navController, id = it)
                }
            }
        }
    }
}