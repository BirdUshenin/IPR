package com.example.ipr

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ipr.databinding.ActivityMainBinding
import com.squareup.picasso.BuildConfig

class MainActivity : AppCompatActivity(), OnUserEditListener {

    private lateinit var adapter: AdapterUsers
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

        val userServer = DataUsers.userServer
        adapter = AdapterUsers(userServer)
        adapter.setOnUserItemClickListener(object : OnUserItemClickListener {
            override fun onUserItemClicked(user: Users) {
                val fragmentB = EditUserFragment()
                fragmentB.setOnUserEditListener(this@MainActivity)
                fragmentB.setUser(user)

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragEdit, fragmentB)
                    .addToBackStack("FragEdit")
                    .commit()
            }
        })
        recyclerView.adapter = adapter

    }

    override fun onUserEdited(user: Users) {
        val index = DataUsers.userServer.indexOfFirst { it.id == user.id }
        if (index != -1) {
            DataUsers.userServer[index] = user
            adapter.notifyDataSetChanged()
        }
    }

    fun getFeatures(): List<String> {
        return if (BuildConfig.DEBUG) {
            listOf("Feature1", "Feature2")
        } else {
            listOf("Feature1")
        }
    }
}


