package com.example.mycityapp.ui

import androidx.lifecycle.ViewModel
import com.example.mycityapp.model.MenuItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState


    fun updateCategory(selectedCategory: MenuItem.Category) {
        _uiState.update {
            it.copy(currentCategory = selectedCategory)
        }
        //Log.d("Michael", "updateCategory ${uiState.value.currentCategory. }")
    }

    fun updateRecommendation(selectedRecommendation: MenuItem.Recommendation) {
        _uiState.update {
            it.copy(currentRecommendation = selectedRecommendation)
        }
        //Log.d("Michael", "updateRecommendation ${(uiState.value.currentRecommendation.categoryID)}")
    }

    fun updatePlace(selectedPlace: MenuItem.Place) {
        _uiState.update {
            it.copy(currentPlace = selectedPlace)
        }
        //Log.d("Michael", "updatePlace ${uiState.value.currentRecommendation.title.toString()}")
    }

}