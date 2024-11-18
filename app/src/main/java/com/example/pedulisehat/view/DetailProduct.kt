package com.example.pedulisehat.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.pedulisehat.component.TopNavigation
import com.example.pedulisehat.viewModel.ProductVM

@Composable
fun DetailProductScreen(navController: NavController, id: Int) {
    val productVM = ProductVM()
    val productList = productVM.product.collectAsState().value
    val product = productList.find { it.id == id }
    
    Scaffold (
        topBar = {
            TopNavigation("Detail Product", true, navController)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (product != null){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Gray
                        ),
                        shape = RoundedCornerShape(16.dp),
                    ) {
                        AsyncImage(
                            model = product.gambar,
                            contentDescription = product.nama,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = -30.dp)
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(6.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp),
                                    tint = Color.Yellow
                                )

                                Text(
                                    text = "${product.rating}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }

                            Icon(
                                imageVector = Icons.Filled.Share,
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    Text(
                        text = product.nama,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.size(15.dp))

                    Text(
                        text = "Rp ${product.harga}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.size(20.dp))

                    Text(
                        text = product.deskripsi,
                        fontSize = 10.sp,
                        letterSpacing = 2.sp,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailProduct() {
    val navController = rememberNavController()
    val productVM = ProductVM()
    val product = productVM.product.collectAsState().value
    if (product.isNotEmpty()){
        DetailProductScreen(navController = navController, product[0].id)
    }
}