package com.example.pedulisehat.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pedulisehat.model.Category
import com.example.pedulisehat.repository.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryVM: ViewModel() {
    val categoryRepository = CategoryRepository()
    private val _category = MutableStateFlow<List<Category>>(emptyList())
    val category: StateFlow<List<Category>> get() = _category

    init {
        loadCategory()
    }

    fun loadCategory() {
        viewModelScope.launch {
            _category.value = categoryRepository.getCategory()
        }
    }
}