package com.example.learn.myproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.learn.myproject.databinding.ActivityGitUserDetailBinding
import com.example.learn.myproject.dataUser.User
import com.bumptech.glide.Glide

class GitUserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGitUserDetailBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGitUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        setData()
    }

    private fun setToolbar() {
        toolbar = binding.toolbar
        toolbar.setTitleTextColor(resources.getColor(R.color.black_3333, theme))
        setSupportActionBar(toolbar)
    }

    private fun setData() {
        val dataUser = intent.getParcelableExtra<User>(KEY_USER) as User
        with(binding) {
            Glide.with(root)
                .load(dataUser.photo)
                .circleCrop()
                .into(detailImage)
            detailName.text = dataUser.name
            detailUsername.text = dataUser.username
            detailCompany.text = dataUser.company
            detailLocation.text = dataUser.location
            detailRepoValue.text = dataUser.repository
            detailFollowersValue.text = dataUser.followers
            detailFollowingValue.text = dataUser.following
        }
    }

    companion object {
        const val KEY_USER = "key_user"
    }
}