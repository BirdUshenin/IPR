package com.example.ipr.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.R
import com.example.ipr.data.SubItem
import com.squareup.picasso.Picasso

class InnerHorizontalAdapter(private val items: List<SubItem>) :
    RecyclerView.Adapter<InnerHorizontalAdapter.InnerHorizontalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHorizontalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cities_list, parent, false)
        return InnerHorizontalViewHolder(view)
    }

    override fun onBindViewHolder(holder: InnerHorizontalViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class InnerHorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photoUser: ImageView = itemView.findViewById(R.id.inner_item_image)

        fun bind(item: SubItem) {
            Picasso.get()
                .load(item.photo)
                .into(photoUser)
        }
    }
}