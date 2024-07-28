package com.example.ipr.domain

import com.example.ipr.data.Users

interface OnUserEditListener {
    fun onUserEdited(user: Users)
}