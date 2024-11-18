package com.example.pedulisehat.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pedulisehat.model.Product
import com.example.pedulisehat.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductVM: ViewModel() {
    val productRepository = ProductRepository()
    private val _product = MutableStateFlow<List<Product>>(emptyList())
    val product: StateFlow<List<Product>> get() = _product

    init {
        loadProduct()
    }

    fun loadProduct(){
        viewModelScope.launch {
            _product.value = productRepository.getProduct()
        }
    }
}