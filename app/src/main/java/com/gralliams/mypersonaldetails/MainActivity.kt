package com.gralliams.mypersonaldetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.gralliams.mypersonaldetails.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.openGithubButton.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)

        }

    }
}