package com.example.pedulisehat.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pedulisehat.model.Profile
import com.example.pedulisehat.repository.ProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileVM: ViewModel() {
    val profileRepository = ProfileRepository()
    private val _profile = MutableStateFlow<List<Profile>>(emptyList())
    val profile: StateFlow<List<Profile>> get() = _profile

    init {
        loadProfile()
    }

    fun loadProfile() {
        viewModelScope.launch {
            _profile.value = profileRepository.getProfile()
        }
    }
}