package com.example.ipr.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ipr.domain.OnUserEditListener
import com.example.ipr.domain.OnUserItemClickListener
import com.example.ipr.R
import com.example.ipr.data.Cities
import com.example.ipr.data.Users
import com.example.ipr.databinding.ActivityMainBinding
import com.squareup.picasso.BuildConfig
import data.DataUsers

class MainActivity : AppCompatActivity(), OnUserEditListener {

    private lateinit var adapter: AdapterUsers
    private lateinit var citiesAdapter: AdapterCities
    private lateinit var concatAdapter: ConcatAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = AdapterUsers()
        citiesAdapter = AdapterCities()

        concatAdapter = ConcatAdapter(HorizontalCitiesAdapter(citiesAdapter), adapter)
        recyclerView.adapter = concatAdapter

        val userServer = DataUsers.userServer
        adapter.submitList(userServer)

        val cities = listOf(
            Cities(1, "New York"),
            Cities(2, "Los Angeles"),
            Cities(3, "Chicago"),
        )
        citiesAdapter.submitList(cities)
    }

    override fun onUserEdited(user: Users) {
        val index = DataUsers.userServer.indexOfFirst { it.id == user.id }
        if (index != -1) {
            DataUsers.userServer[index] = user
            adapter.submitList(DataUsers.userServer.toList())
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



