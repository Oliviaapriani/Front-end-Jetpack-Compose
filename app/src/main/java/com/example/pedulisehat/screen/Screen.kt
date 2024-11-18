package com.example.pedulisehat.screen

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object FInd: Screen("find")
    object About: Screen("about")

    object DetailCategory : Screen("detailCategory/{id}") {
        fun DetailCategory(id: Int) = "detailCategory/$id"
    }

    object DetailProduct : Screen("detailProduct/{id}") {
        fun DetailProduct(id: Int) = "detailProduct/$id"
    }

}