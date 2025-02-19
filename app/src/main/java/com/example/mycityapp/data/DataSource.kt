package com.example.mycityapp.data

import com.example.mycityapp.R
import com.example.mycityapp.model.MenuItem.Category
import com.example.mycityapp.model.MenuItem.Place
import com.example.mycityapp.model.MenuItem.Recommendation


object DataSource {
    val category = listOf(
        Category(
            ID = 1,
            R.drawable.category1,
            R.string.category1
        ),
        Category(
            ID = 2,
            R.drawable.category2,
            R.string.category2
        ),
        Category(
            ID = 3,
            R.drawable.category3,
            R.string.category3
        ),
        Category(
            ID = 4,
            R.drawable.category4,
            R.string.category4
        ),
        Category(
            ID = 5,
            R.drawable.category5,
            R.string.category5
        )
    )

    val recommendation = listOf(
        Recommendation(
            ID = 1,
            R.drawable.recommendation,
            R.string.recommendation1,
            categoryID = 1
        ),
        Recommendation(
            ID = 2,
            R.drawable.recommendation,
            R.string.recommendation2,
            categoryID = 2
        ), Recommendation(
            ID = 3,
            R.drawable.recommendation,
            R.string.recommendation3,
            categoryID = 2
        ), Recommendation(
            ID = 4,
            R.drawable.recommendation,
            R.string.recommendation4,
            categoryID = 3
        ), Recommendation(
            ID = 5,
            R.drawable.recommendation,
            R.string.recommendation5,
            categoryID = 3
        ), Recommendation(
            ID = 6,
            R.drawable.recommendation,
            R.string.recommendation6,
            categoryID = 3
        ), Recommendation(
            ID = 7,
            R.drawable.recommendation,
            R.string.recommendation7,
            categoryID = 4
        ), Recommendation(
            ID = 8,
            R.drawable.recommendation,
            R.string.recommendation8,
            categoryID = 4
        ), Recommendation(
            ID = 9,
            R.drawable.recommendation,
            R.string.recommendation9,
            categoryID = 4
        ), Recommendation(
            ID = 10,
            R.drawable.recommendation,
            R.string.recommendation10,
            categoryID = 4
        ), Recommendation(
            ID = 11,
            R.drawable.recommendation,
            R.string.recommendation11,
            categoryID = 5
        ), Recommendation(
            ID = 12,
            R.drawable.recommendation,
            R.string.recommendation12,
            categoryID = 5
        ), Recommendation(
            ID = 13,
            R.drawable.recommendation,
            R.string.recommendation13,
            categoryID = 5
        )
    )

    val places = listOf(
        Place(
            ID = 1,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 1
        ),
        Place(
            ID = 2,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 2
        ),
        Place(
            ID = 3,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 3
        ),
        Place(
            ID = 4,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 4
        ),
        Place(
            ID = 5,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 5
        ),
        Place(
            ID = 6,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 6
        ),
        Place(
            ID = 7,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 7
        ),
        Place(
            ID = 8,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 8
        ),
        Place(
            ID = 9,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 9
        ),
        Place(
            ID = 10,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 10
        ),
        Place(
            ID = 11,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 11
        ),
        Place(
            ID = 12,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 12
        ),
        Place(
            ID = 13,
            image = R.drawable.place,
            title = 0,
            text = R.string.place,
            recommendationID = 13
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