package com.example.pedulisehat.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.pedulisehat.R
import com.example.pedulisehat.component.BottomNavigation
import com.example.pedulisehat.component.TopNavigation
import com.example.pedulisehat.model.Category
import com.example.pedulisehat.model.Product
import com.example.pedulisehat.screen.Screen
import com.example.pedulisehat.viewModel.CategoryVM
import com.example.pedulisehat.viewModel.ProductVM

@Composable
fun HomeScreen(navController: NavController, categoryVM: CategoryVM = viewModel(), productVM: ProductVM = viewModel()) {
    val category = categoryVM.category.collectAsState()
    val product = productVM.product.collectAsState()

    Scaffold (
        topBar = {
            TopNavigation("Home", false, navController = navController)
        },
        bottomBar = {
            BottomNavigation(navController)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                item {
                    LazyRow (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        items(category.value) { value ->
                            CategoryItem(value) {
                                navController.navigate(Screen.DetailCategory.DetailCategory(value.id)){
                                    popUpTo(Screen.DetailCategory.route) {inclusive = true}
                                }
                            }
                        }
                    }
                }

                item {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        if (product.value.isNotEmpty()){
                            product.value
                                .forEach{ value ->
                                    ProductItem(value) {
                                        navController.navigate(Screen.DetailProduct.DetailProduct(value.id)){
                                            popUpTo(Screen.DetailProduct.route) {inclusive = true}
                                        }
                                    }
                                }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryItem(category: Category, onClick: () -> Unit) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = category.nama,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
        }
    }
}

@Composable
fun ProductItem(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(120.dp)
            .background(color = colorResource(R.color.white))
            .clickable { onClick() },
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = product.nama,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.size(10.dp))

                Text(
                    text = "Rp ${product.harga}",
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = Color.Black
                )
            }

            Box(
                modifier = Modifier
                    .size(104.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                AsyncImage(
                    model = product.gambar,
                    contentDescription = product.nama,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHome() {
    val navController = rememberNavController()
    val categoryVM = CategoryVM()
    val productVM = ProductVM()
    HomeScreen(navController, categoryVM, productVM)
}

