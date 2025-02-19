package com.example.mycityapp.ui

import com.example.mycityapp.data.DataSource
import com.example.mycityapp.model.MenuItem


data class MyCityUiState(
    val currentCategory: MenuItem.Category = DataSource.getDefaultCategory(),
    val currentRecommendation: MenuItem.Recommendation = DataSource.getDefaultRecommendation(),
    val currentPlace: MenuItem.Place = DataSource.getDefaultPlace()
)
