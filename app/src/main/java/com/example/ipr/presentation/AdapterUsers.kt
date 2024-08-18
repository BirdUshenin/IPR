package com.example.ipr.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.R
import com.example.ipr.data.Cities
import com.example.ipr.data.Users
import com.example.ipr.domain.OnUserItemClickListener

class AdapterUsers : ListAdapter<Users, UsersItemViewHolder>(UsersItemDiffCallback()) {

    var clickListener: OnUserItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return UsersItemViewHolder(view)
    }

    fun setOnUserItemClickListener(listener: OnUserItemClickListener) {
        clickListener = listener
    }

    override fun onBindViewHolder(viewHolder: UsersItemViewHolder, position: Int) {
        val user = getItem(position)
        viewHolder.bind(user)
        viewHolder.itemView.setOnClickListener {
            clickListener?.onUserItemClicked(user)
        }
    }
}


class HorizontalCitiesAdapter(private val citiesAdapter: AdapterCities) :
    RecyclerView.Adapter<HorizontalCitiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalCitiesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_cities_container, parent, false)
        return HorizontalCitiesViewHolder(view, citiesAdapter)
    }

    override fun onBindViewHolder(holder: HorizontalCitiesViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 1
}

class HorizontalCitiesViewHolder(itemView: View, private val citiesAdapter: AdapterCities) :
    RecyclerView.ViewHolder(itemView) {

    private val recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerViewCities)

    init {
        recyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = citiesAdapter
    }

    fun bind() {}
}

class AdapterCities : ListAdapter<Cities, CitiesItemViewHolder>(CitiesItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CitiesItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CitiesItemViewHolder, position: Int) {
        val city = getItem(position)
        viewHolder.bind(city)
    }
}

class CitiesItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(city: Cities) {
        itemView.findViewById<TextView>(R.id.cityName).text = city.name
    }
}

class CitiesItemDiffCallback : DiffUtil.ItemCallback<Cities>() {
    override fun areItemsTheSame(oldItem: Cities, newItem: Cities): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Cities, newItem: Cities): Boolean {
        return oldItem == newItem
    }
}
