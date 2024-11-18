
package com.example.pedulisehat.view

import android.widget.Space
import android.widget.Toast
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.pedulisehat.component.BottomNavigation
import com.example.pedulisehat.component.TopNavigation
import com.example.pedulisehat.model.Product
import com.example.pedulisehat.screen.Screen
import com.example.pedulisehat.viewModel.ProductVM

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindScreen(navController: NavController, productVM: ProductVM) {
    val product = productVM.product.collectAsState()
    val searchQuery = remember { mutableStateOf("") }

    Scaffold (
        topBar = {
            TopNavigation("Find Product", false, navController)
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
            Column {
                OutlinedTextField(
                    value = searchQuery.value,
                    onValueChange = { searchQuery.value = it },
                    placeholder = { Text(text = "Find Product...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Green,
                        cursorColor = Color.Green
                    )
                )

                val filteredProducts = product.value.filter {
                    it.nama.contains(searchQuery.value, ignoreCase = true)
                }
                if (filteredProducts.isNotEmpty()){
                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        columns = GridCells.Adaptive(minSize = 100.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(filteredProducts) {value ->
                            ProductCardItem(product = value) {
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

@Composable
fun ProductCardItem(product: Product, onClick: () -> Unit) {
    val context = LocalContext.current

    Card (
        modifier = Modifier
            .clickable { onClick() }
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation =8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .height(80.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = product.gambar,
                    contentDescription = product.nama,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.size(6.dp))

            Text(
                text = product.nama,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.size(6.dp))

            Text(
                text = "Rp ${product.harga}",
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                color = Color.Green
            )

            Spacer(modifier = Modifier.size(10.dp))

            Box(
                modifier = Modifier
                    .background(color = Color.Green, RoundedCornerShape(16.dp))
                    .fillMaxWidth().padding(8.dp).clickable { Toast.makeText(context, "Buy", Toast.LENGTH_SHORT).show() },
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Beli",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    
                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "+",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewFindScreen() {
    val navController = rememberNavController()
    val productVM = ProductVM()
    FindScreen(navController = navController, productVM = productVM)
}