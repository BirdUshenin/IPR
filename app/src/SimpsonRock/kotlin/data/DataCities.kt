package data

import com.example.ipr.R
import com.example.ipr.data.HorizontalItem
import com.example.ipr.data.SubItem

object DataCities {
    val citiesServer = listOf(
        HorizontalItem(
            id = 1,
            title = "Cities",
            subItems = listOf(
                SubItem(R.drawable.moscow),
                SubItem(R.drawable.nn),
                SubItem(R.drawable.spb),
            )
        )
    )
}