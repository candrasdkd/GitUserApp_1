package com.example.learn.myproject.adapter
import com.example.learn.myproject.dataUser.User

interface OnItemClickCallback {
    fun onItemClicked(user : User)
}