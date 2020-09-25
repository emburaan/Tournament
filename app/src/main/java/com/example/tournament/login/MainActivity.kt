package com.example.tournament.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.tournament.R
import com.example.tournament.databinding.ActivityMainBinding
import com.example.tournament.login.dashboard.DashBoard


class MainActivity : AppCompatActivity() {
  lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        setBackGround()
        setClickListner()
    }

    private fun setClickListner() {
        binding.google.setOnClickListener {
         val intent = Intent(this,DashBoard::class.java)
            startActivity(intent)
        }
        binding.facbook.setOnClickListener {
            val intent = Intent(this,DashBoard::class.java)
            startActivity(intent)        }

    }

    private fun setBackGround() {
        Glide.with(this)
            .load(R.drawable.animated_bg)
            .placeholder(R.drawable.animated_bg)
            .into(binding.imgLoginBg);

    }
}