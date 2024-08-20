package com.example.ipr.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.R
import com.example.ipr.data.SimpsonsItem
import com.example.ipr.domain.OnCitiesClickListener
import com.example.ipr.domain.OnUserEditListener
import com.example.ipr.domain.OnSimpsonItemClickListener
import com.example.ipr.domain.RecyclerItem
import data.DataCities
import data.DataUsers

class MainActivity : AppCompatActivity(), OnUserEditListener {

    private lateinit var adapter: MultiTypeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MultiTypeAdapter(
            listOf(
                SimpsonsItemDelegate(object : OnSimpsonItemClickListener {
                    override fun onSimpsonItemClicked(character: SimpsonsItem) {
                        val fragmentB = EditUserFragment()
                        fragmentB.setOnUserEditListener(this@MainActivity)
                        fragmentB.setUser(character)

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragEdit, fragmentB)
                            .addToBackStack("FragEdit")
                            .commit()
                    }
                }),
                CitiesItemDelegate(
                    object : OnCitiesClickListener {
                        override fun onCitiesItemClicked(city: String) {
                            val duration = Toast.LENGTH_SHORT
                            val toast = Toast.makeText(applicationContext, city, duration)
                            toast.show()
                        }
                    }
                )
            )
        )

        recyclerView.adapter = adapter

        updateList()
    }

    private fun updateList() {
        val verticalItems = DataUsers.userServer
        val horizontalItems = DataCities.citiesServer
        val items = verticalItems + horizontalItems
        adapter.submitList(items)
    }

    override fun onUserEdited(user: RecyclerItem) {
        (user as SimpsonsItem).let {
            val index = DataUsers.userServer.indexOfFirst { it.id == user.id }
            if (index != -1) {
                DataUsers.userServer[index] = user
                updateList()
            }
        }
    }
}

/***
 *  Build variants change (Debug or Release)
 *
fun getFeatures(): List<String> {
    return if (BuildConfig.DEBUG) {
        listOf("Feature1", "Feature2")
    } else {
        listOf("Feature1")
    }
}
***/