package com.example.ipr.domain

import com.example.ipr.data.SimpsonsItem

interface OnSimpsonItemClickListener {
    fun onSimpsonItemClicked(character: SimpsonsItem)
}