package com.example.mycityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycityapp.R
import com.example.mycityapp.data.DataSource
import com.example.mycityapp.model.MenuItem


@Composable
fun PlacesScreen(
    place: MenuItem.Place,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            Image(
                painterResource(place.image),
                contentDescription = null
            )
        }
        Spacer(modifier = modifier.height(dimensionResource(R.dimen.padding_spacer)))
        Text(
            text = place.recommendationID.toString(),
            style = MaterialTheme.typography.displayLarge
        )
        Text(text = stringResource(place.text))
    }
}

@Preview(showBackground = true)
@Composable
fun PlacesScreenPreview() {
    PlacesScreen(DataSource.places.first())
}