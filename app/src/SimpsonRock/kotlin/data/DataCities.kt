package data

import com.example.ipr.R
import com.example.ipr.data.CitiesItem
import com.example.ipr.data.SubItem

object DataCities {
    val citiesServer = listOf(
        CitiesItem(
            id = 1,
            title = "Cities",
            subItems = listOf(
                SubItem(R.drawable.sprin, "Спрингфилд"),
                SubItem(R.drawable.nyc, "Нью Йорк"),
                SubItem(R.drawable.paris, "Париж")
            )
        )
    )
}