package com.example.mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class MenuItem(
    @DrawableRes
    open val image: Int,
    @StringRes
    open val title: Int
) {
    data class Category(
        override val image: Int,
        override val title: Int
    ) : MenuItem(image, title)

    data class Recommendation(
        override val image: Int,
        override val title: Int,
        var categoryID: Int
    ) : MenuItem(image, title)

    data class Place(
        override val image: Int,
        override val title: Int,
        val text: Int,
        var recommendationID: Int
    ) : MenuItem(image, title)

}

