package com.example.ipr.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.R
import com.example.ipr.data.VerticalItem
import com.example.ipr.domain.OnUserItemClickListener
import com.squareup.picasso.Picasso

class VerticalItemDelegate(private val clickListener: OnUserItemClickListener?) : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return VerticalItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Any) {
        if (holder is VerticalItemViewHolder && item is VerticalItem) {
            holder.bind(item)
            holder.itemView.setOnClickListener {
                clickListener?.onUserItemClicked(item)
            }
        }
    }

    override fun isForViewType(item: Any): Boolean {
        return item is VerticalItem
    }
}

class VerticalItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var PhotoUser: ImageView = itemView.findViewById(R.id.photo)
    val NameUser = itemView.findViewById<TextView>(R.id.name)
    val Surname = itemView.findViewById<TextView>(R.id.surname)
    val Number = itemView.findViewById<TextView>(R.id.number)

    fun bind(item: VerticalItem) {
        NameUser.text = item.name
        Surname.text = item.surname
        Number.text = item.phoneNumber
        Picasso.get()
            .load(item.photo)
            .into(PhotoUser)
    }
}
