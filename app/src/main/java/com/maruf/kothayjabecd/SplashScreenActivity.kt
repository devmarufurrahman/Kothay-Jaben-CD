package com.maruf.kothayjabecd

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.maruf.kothayjabecd.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)

        lifecycleScope.launch {
            delay(1000)
            val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation( this@SplashScreenActivity, R.anim.zoom_out_open, R.anim.no_anim)
            startActivity(intent, options.toBundle())
            finish()
        }


    }
}