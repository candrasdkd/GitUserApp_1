package com.example.learn.myproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.learn.myproject.dataUser.User
import com.example.learn.myproject.databinding.ActivityGitUserBinding
import com.bumptech.glide.Glide

class UserAdapter : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    var users = arrayListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ActivityGitUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int){
        holder.bind(users[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(users[position]) }
    }

    override fun getItemCount(): Int = users.size

    class MyViewHolder(private var binding: ActivityGitUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.name.text = user.name
            binding.username.text = user.username
            Glide.with(binding.root)
                .load(user.photo)
                .circleCrop()
                .into(binding.circleImageView)
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

}