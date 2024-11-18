package com.example.pedulisehat.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pedulisehat.R
import com.example.pedulisehat.component.BottomNavigation
import com.example.pedulisehat.component.TopNavigation
import com.example.pedulisehat.viewModel.ProfileVM

@Composable
fun AboutScreen(navController: NavController, profileVM: ProfileVM) {
    val profile = profileVM.profile.collectAsState()

    Scaffold (
        topBar = {
            TopNavigation("About", false, navController)
        }, 
        bottomBar = {
            BottomNavigation(navController)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    color = Color.White
                ) {
                    Image(
                        painter = painterResource(
                            id = profile.value.firstOrNull()?.gambar
                                ?: R.drawable.profile
                        ),
                        contentDescription = "Profile Picture",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Column (
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                ) {
                    Text(
                        text = "Welcome Back, ${profile.value.first().nama}!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black
                    )

                    Text(
                        text = profile.value.first().email,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        color = Color.Black
                    )

                    Text(
                        text = profile.value.first().institut,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        color = Color.Black
                    )

                    Text(
                        text = profile.value.first().jurusan,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewAbout() {
    val navController  = rememberNavController()
    val profileVM = ProfileVM()
    AboutScreen(navController = navController, profileVM = profileVM)
}