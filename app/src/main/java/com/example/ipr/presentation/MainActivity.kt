package com.example.ipr.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.domain.OnUserEditListener
import com.example.ipr.domain.OnUserItemClickListener
import com.example.ipr.R
import com.example.ipr.data.HorizontalItem
import com.example.ipr.data.Users
import com.example.ipr.data.VerticalItem
import com.example.ipr.databinding.ActivityMainBinding
import com.squareup.picasso.BuildConfig
import data.DataUsers

//class MainActivity : AppCompatActivity(), OnUserEditListener {
//
//    private lateinit var adapter: AdapterUsers
//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        val recyclerView = binding.recyclerView
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        adapter = AdapterUsers()
//
//        adapter.setOnUserItemClickListener(object : OnUserItemClickListener {
//            override fun onUserItemClicked(user: Users) {
//                val fragmentB = EditUserFragment()
//                fragmentB.setOnUserEditListener(this@MainActivity)
//                fragmentB.setUser(user)
//
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragEdit, fragmentB)
//                    .addToBackStack("FragEdit")
//                    .commit()
//            }
//        })
//        recyclerView.adapter = adapter
//
//        val userServer = DataUsers.userServer
//        adapter.submitList(userServer)
//    }
//
//    override fun onUserEdited(user: Users) {
//        val index = DataUsers.userServer.indexOfFirst { it.id == user.id }
//        if (index != -1) {
//            DataUsers.userServer[index] = user
//            adapter.submitList(DataUsers.userServer.toList())
//        }
//    }
//}
//
//fun getFeatures(): List<String> {
//    return if (BuildConfig.DEBUG) {
//        listOf("Feature1", "Feature2")
//    } else {
//        listOf("Feature1")
//    }
//}



class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MultiTypeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MultiTypeAdapter(
            listOf(
                VerticalItemDelegate(),
                HorizontalItemDelegate()
            )
        )

        recyclerView.adapter = adapter

        val items = listOf(
            VerticalItem(
                1, "look"
            ),
            HorizontalItem(2, "moon"),
            VerticalItem(3,"sun"),
            HorizontalItem(4, "light")
        )

        adapter.submitList(items)
    }
}




