package com.example.mycityapp.data

import androidx.annotation.StringRes
import com.example.mycityapp.R

enum class MyCityScreen(@StringRes val title: Int) {
    Category(title = R.string.app_name),
    Recommendation(title = R.string.app_name),
    Place(title = R.string.app_name)
}