package com.geekymusketeers.trackit.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geekymusketeers.trackit.auth.SignInActivity
import com.geekymusketeers.trackit.databinding.ActivityGeetingStartedBinding

class GeetingStartedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGeetingStartedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGeetingStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToSignIn()
    }

    private fun goToSignIn() {
        binding.getStarted.setOnClickListener {
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}