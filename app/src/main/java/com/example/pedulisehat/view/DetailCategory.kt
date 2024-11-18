package com.example.pedulisehat.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pedulisehat.component.TopNavigation
import com.example.pedulisehat.viewModel.CategoryVM

@Composable
fun DetailCategoryScreen(navController: NavController, id: Int) {
    val categoryVM = CategoryVM()
    val categoryList = categoryVM.category.collectAsState().value
    val category = categoryList.find { it.id == id }

    Scaffold (
        topBar = {
            TopNavigation("Detail Category", true, navController)
        },
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            Column (
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                if (category != null) {
                    Text(
                        text = category.nama,
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.size(12.dp))

                    Text(
                        text = category.Deskripsi,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailCategory() {
    val navController = rememberNavController()
    val categoryVM = CategoryVM()
    val category = categoryVM.category.collectAsState().value
    if (category.isNotEmpty()){
        DetailCategoryScreen(navController = navController, id = category[0].id)
    }
}