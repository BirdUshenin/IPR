package com.example.ipr.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.BuildConfig
import com.example.ipr.R
import com.example.ipr.data.VerticalItem
import com.example.ipr.domain.OnUserEditListener
import com.example.ipr.domain.OnUserItemClickListener
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
                VerticalItemDelegate(object : OnUserItemClickListener {
                    override fun onUserItemClicked(user: VerticalItem) {
                        val fragmentB = EditUserFragment()
                        fragmentB.setOnUserEditListener(this@MainActivity)
                        fragmentB.setUser(user)

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragEdit, fragmentB)
                            .addToBackStack("FragEdit")
                            .commit()
                    }
                }),
                HorizontalItemDelegate()
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

    override fun onUserEdited(user: VerticalItem) {
        val index = DataUsers.userServer.indexOfFirst { it.id == user.item() }

        if (index != -1) {
            DataUsers.userServer[index] = user
            updateList()
        }

    }
}

fun getFeatures(): List<String> {
    return if (BuildConfig.DEBUG) {
        listOf("Feature1", "Feature2")
    } else {
        listOf("Feature1")
    }
}