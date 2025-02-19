package com.example.mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class MenuItem(
    open val ID: Int,
    @DrawableRes
    open val image: Int,
    @StringRes
    open val title: Int
) {
    data class Category(
        override val ID: Int,
        override val image: Int,
        override val title: Int
    ) : MenuItem(ID, image, title)

    data class Recommendation(
        override val ID: Int,
        override val image: Int,
        override val title: Int,
        var categoryID: Int
    ) : MenuItem(ID, image, title)

    data class Place(
        override val ID: Int,
        override val image: Int,
        override val title: Int,
        val text: Int,
        var recommendationID: Int
    ) : MenuItem(ID, image, title)

}

