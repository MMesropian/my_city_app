package com.example.mycityapp.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.data.DataSource
import com.example.mycityapp.model.MenuItem

@Composable
fun RecommendationScreen(
    recommendationList: List<MenuItem.Recommendation>,
    onRecommendationClick: (MenuItem) -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier,
) {
    BaseScreen(
        options = recommendationList,
        onOptionClick = onRecommendationClick,
        contentPadding = contentPadding,
        modifier = modifier
    )
}

@Preview
@Composable
fun RecommendationScreenPreview() {
    RecommendationScreen(
        recommendationList = DataSource.recommendation.toList(),
        onRecommendationClick = { }
    )
}
