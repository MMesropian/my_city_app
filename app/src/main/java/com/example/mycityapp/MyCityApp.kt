package com.example.mycityapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.data.DataSource
import com.example.mycityapp.data.MyCityScreen
import com.example.mycityapp.model.MenuItem
import com.example.mycityapp.ui.CategoryScreen
import com.example.mycityapp.ui.ExpandedScreen
import com.example.mycityapp.ui.MyCityViewModel
import com.example.mycityapp.ui.PlacesScreen
import com.example.mycityapp.ui.RecommendationScreen
import com.example.mycityapp.ui.utils.ContentType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    currentScreen: MyCityScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(stringResource(currentScreen.title))
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        modifier = modifier
    )
}

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.Category.name
    )

    val viewModel: MyCityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium -> ContentType.ListOnly
        WindowWidthSizeClass.Expanded -> ContentType.ListAndDetail
        else -> ContentType.ListOnly
    }

    Scaffold(
        topBar = {
            MyCityAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
        modifier = Modifier.fillMaxSize()

    ) { innerPadding ->

        if (contentType == ContentType.ListAndDetail) {
            ExpandedScreen(
                viewModel = viewModel,
                uiState = uiState,
                contentPadding = innerPadding,
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            NavHost(
                navController = navController,
                startDestination = MyCityScreen.Category.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = MyCityScreen.Category.name) {
                    CategoryScreen(
                        DataSource.category.toList(),
                        onCategoryClick = {
                            viewModel.updateCategory(it as MenuItem.Category)
                            navController.navigate(MyCityScreen.Recommendation.name)
                        },
                        //contentPadding = innerPadding
                    )
                }
                composable(route = MyCityScreen.Recommendation.name) {
                    RecommendationScreen(
                        DataSource.recommendation.toList().filter { it.categoryID == uiState.currentCategory.ID },
                        onRecommendationClick = {
                            viewModel.updateRecommendation(it as MenuItem.Recommendation)
                            navController.navigate(MyCityScreen.Place.name)
                        },
                        //contentPadding = innerPadding
                    )
                }
                composable(route = MyCityScreen.Place.name) {
                    PlacesScreen(DataSource.places.filter{ it.recommendationID == uiState.currentRecommendation.ID }.first())
                }
            }

        }


    }
}

private fun calculateContentType(windowSize: WindowSizeClass): ContentType {
    val contentType = when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium,
            -> ContentType.ListOnly

        WindowWidthSizeClass.Expanded -> ContentType.ListAndDetail
        else -> ContentType.ListOnly
    }
    return contentType
}