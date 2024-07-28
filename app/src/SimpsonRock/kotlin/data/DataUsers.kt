package data

import com.example.ipr.R
import com.example.ipr.data.Users

object DataUsers {
    val userServer = mutableListOf(
        Users(1, R.drawable.gomer, "Гомэр", "Симпсон", "+132 244 242"),
        Users(2, R.drawable.bart, "Барт", "Симпсон", "+122 344 745"),
        Users(3, R.drawable.lisa, "Лиза", "Симпсон", "+143 344 745"),
        Users(4, R.drawable.ralf, "Ральф", "Виггум", "+198 123 894"),
        Users(5, R.drawable.mardge, "Мардж", "Симпсон", "+153 411 124")
    )
}