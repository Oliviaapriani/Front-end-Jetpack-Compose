package com.example.pedulisehat.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pedulisehat.R
import com.example.pedulisehat.screen.Screen

@Composable
fun BottomNavigation(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""
    Surface(
        shadowElevation = 8.dp
    ) {
        BottomAppBar(
            containerColor = colorResource(id = R.color.white),
            modifier = Modifier.height(80.dp),
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ItemNav(
                    title = "Home",
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home,
                    selected = currentRoute == Screen.Home.route,
                    onClick = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = true }
                        }
                    }
                )
                ItemNav(
                    title = "Find",
                    selectedIcon = Icons.Filled.Search,
                    unselectedIcon = Icons.Outlined.Search,
                    selected = currentRoute == Screen.FInd.route,
                    onClick = {
                        navController.navigate(Screen.FInd.route) {
                            popUpTo(Screen.FInd.route) { inclusive = true }
                        }
                    }
                )

                ItemNav(
                    title = "About",
                    selectedIcon = Icons.Filled.Person,
                    unselectedIcon = Icons.Outlined.Person,
                    selected = currentRoute == Screen.About.route,
                    onClick = {
                        navController.navigate(Screen.About.route) {
                            popUpTo(Screen.About.route) { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ItemNav(
    title: String,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = if (selected) selectedIcon else unselectedIcon,
                contentDescription = title,
                modifier = Modifier.size(30.dp),
                tint = if (selected) colorResource(id = R.color.black) else colorResource(id = R.color.black)
            )
        }
        Text(
            text = title,
            color = if (selected) colorResource(id = R.color.black) else colorResource(id = R.color.black),
            fontSize = 12.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomNavigation() {
    val navController = rememberNavController()
    BottomNavigation(navController = navController)
}