package com.example.mycityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycityapp.R
import com.example.mycityapp.model.MenuItem

@Composable
fun BaseScreen(
    options: List<MenuItem>,
    onOptionClick: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
    ) {
        items(options) { item ->
            BaseItem(
                item = item,
                onClick = onOptionClick
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseItem(
    item: MenuItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        onClick = onClick,
        modifier = modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium))
                .height(
                    dimensionResource(R.dimen.card_row_height)
                )
        ) {
            BaseItemImage(
                item = item,
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.card_image_height))
            )
            Text(text = stringResource(id = item.title))
        }
    }
}

@Composable
fun BaseItemImage(
    item: MenuItem,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}