package data

import com.example.ipr.R
import com.example.ipr.data.SimpsonsItem

object DataUsers {
    val userServer = mutableListOf(
        SimpsonsItem(1, R.drawable.gomer, "Гомэр", "Симпсон", "+132 244 242"),
        SimpsonsItem(2, R.drawable.bart, "Барт", "Симпсон", "+122 344 745"),
        SimpsonsItem(3, R.drawable.lisa, "Лиза", "Симпсон", "+143 344 745"),
        SimpsonsItem(5, R.drawable.mardge, "Мардж", "Симпсон", "+153 411 124")
    )
}