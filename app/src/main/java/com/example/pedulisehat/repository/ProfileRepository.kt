package com.example.pedulisehat.repository

import com.example.pedulisehat.R
import com.example.pedulisehat.model.Profile

class ProfileRepository {
    private val profile = listOf(
        Profile(1, R.drawable.profile, "Olivia Apriani", "oliviaapriani@gmail.com", "Institut Teknologi Del", "Teknologi Informasi")
    )

    fun getProfile() : List<Profile>{
        return profile
    }
}