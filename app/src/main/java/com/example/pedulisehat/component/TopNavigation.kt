package com.example.pedulisehat.component

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pedulisehat.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigation(text: String, detailScreen: Boolean, navController: NavController) {
    val context = LocalContext.current

    Surface(
        shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp),
        shadowElevation = 4.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        TopAppBar(
            title = {
                Text(
                    text = text,
                    fontSize = 25.sp,
                )
            },
            navigationIcon = {
                if (detailScreen) {
                    IconButton(
                        onClick = { navController.popBackStack() },
                    ) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(4.dp)
                                .size(30.dp)
                        )
                    }
                } else {
                    null
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorResource(id = R.color.white),
                titleContentColor = colorResource(id = R.color.black),
                navigationIconContentColor = colorResource(id = R.color.black)
            ),
            actions = {
                IconButton(
                    onClick ={ Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show()}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = null
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopNavigation() {
    val title = "Home"
    val navController = rememberNavController()
    TopNavigation(title, false, navController)
}