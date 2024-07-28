package com.example.ipr.domain

import com.example.ipr.data.Users

interface OnUserItemClickListener {
    fun onUserItemClicked(user: Users)
}