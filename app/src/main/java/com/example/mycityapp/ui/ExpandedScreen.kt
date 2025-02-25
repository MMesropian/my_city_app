package com.example.mycityapp.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycityapp.R
import com.example.mycityapp.data.DataSource
import com.example.mycityapp.model.MenuItem

@Composable
fun ExpandedScreen(
    viewModel: MyCityViewModel,
    uiState: MyCityUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {

    Row(modifier = modifier.padding(contentPadding)) {
        CategoryScreen(
            DataSource.category.toList(),
            onCategoryClick = { viewModel.updateCategory(it as MenuItem.Category) },
            modifier = modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_spacer)))
        RecommendationScreen(
            DataSource.recommendation.toList().filter { it.categoryID == uiState.currentCategory.ID },
            onRecommendationClick = { viewModel.updateRecommendation(it as MenuItem.Recommendation) },
            modifier = modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_spacer)))
        PlacesScreen(
            DataSource.places.filter{ it.recommendationID == uiState.currentRecommendation.ID }.first(),
            modifier = modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandedScreenPreview() {
    ExpandedScreen(
        viewModel = viewModel(),
        uiState = MyCityUiState()
    )
}