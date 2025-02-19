package com.example.mycityapp.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.data.DataSource
import com.example.mycityapp.model.MenuItem
import com.example.mycityapp.model.MenuItem.Category

@Composable
fun CategoryScreen(
    categoryList: List<Category>,
    onCategoryClick: (MenuItem) -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier,
) {
    BaseScreen(
        options = categoryList,
        onOptionClick = onCategoryClick,
        contentPadding = contentPadding,
        modifier = modifier
    )
}

@Preview
@Composable
fun CategoryScreenPreview() {
    CategoryScreen(
        categoryList = DataSource.category.toList(),
        onCategoryClick = { }
    )
}


