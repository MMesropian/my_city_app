package com.example.mycityapp.data

import com.example.mycityapp.R
import com.example.mycityapp.model.MenuItem.*


object DataSource {
    val category = listOf(
        Category(
            R.drawable.category1,
            R.string.category1
        ),
        Category(
            R.drawable.category2,
            R.string.category2
        ),
        Category(
            R.drawable.category3,
            R.string.category3
        ),
        Category(
            R.drawable.category4,
            R.string.category4
        ),
        Category(
            R.drawable.category5,
            R.string.category5
        )
    )

    val recommendation = listOf(
        Recommendation(
            R.drawable.recommendation,
            R.string.recommendation1,
            categoryID = 1
        ),
        Recommendation(
            R.drawable.recommendation,
            R.string.recommendation2,
            categoryID = 2
        ), Recommendation(
            R.drawable.recommendation,
            R.string.recommendation3,
            categoryID = 2
        ), Recommendation(
            R.drawable.recommendation,
            R.string.recommendation4,
            categoryID = 3
        ), Recommendation(
            R.drawable.recommendation,
            R.string.recommendation5,
            categoryID = 3
        ), Recommendation(
            R.drawable.recommendation,
            R.string.recommendation6,
            categoryID = 3
        ), Recommendation(
            R.drawable.recommendation,
            R.string.recommendation7,
            categoryID = 4
        ), Recommendation(
            R.drawable.recommendation,
            R.string.recommendation8,
            categoryID = 4
        ), Recommendation(
            R.drawable.recommendation,
            R.string.recommendation9,
            categoryID = 4
        ), Recommendation(
            R.drawable.recommendation,
            R.string.recommendation10,
            categoryID = 4
        ), Recommendation(
            R.drawable.recommendation,
            R.string.recommendation11,
            categoryID = 5
        ), Recommendation(
            R.drawable.recommendation,
            R.string.recommendation12,
            categoryID = 5
        ), Recommendation(
            R.drawable.recommendation,
            R.string.recommendation13,
            categoryID = 5
        )
    )

    val places = listOf(
        Place(
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 1
        ),
        Place(
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 2
        ),
        Place(
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 2
        ),
        Place(
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 3
        ),
        Place(
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 3
        ),
        Place(
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 3
        )
    )

    fun getDefaultCategory() = category.first()
    fun getDefaultRecommendation() = recommendation.first()
    fun getDefaultPlace() = places.first()

    fun getRecommendationForCategory1() = recommendation.filter { it.categoryID == 1 }
    fun getRecommendationForCategory2() = recommendation.filter { it.categoryID == 2 }
    fun getRecommendationForCategory3() = recommendation.filter { it.categoryID == 3 }
    fun getRecommendationForCategory4() = recommendation.filter { it.categoryID == 4 }
    fun getRecommendationForCategory5() = recommendation.filter { it.categoryID == 5 }

    fun getPlaceForRecommendation1() = places.filter { it.recommendationID ==1 }
    fun getPlaceForRecommendation2() = places.filter { it.recommendationID ==2 }
    fun getPlaceForRecommendation3() = places.filter { it.recommendationID ==3 }


}