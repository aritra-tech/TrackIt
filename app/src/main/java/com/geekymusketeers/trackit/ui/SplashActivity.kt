package com.geekymusketeers.trackit.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.geekymusketeers.trackit.R
import com.geekymusketeers.trackit.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Hides action bar
        supportActionBar?.hide()
        goToGreetingStartedFragmentScreen()
    }

    private fun goToGreetingStartedFragmentScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, GeetingStartedActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}