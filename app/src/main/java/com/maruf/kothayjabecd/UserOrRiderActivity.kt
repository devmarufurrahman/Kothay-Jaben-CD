package com.maruf.kothayjabecd

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.maruf.kothayjabecd.databinding.ActivityUserOrRiderBinding

class UserOrRiderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserOrRiderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_or_rider)

        binding.driverReg.setOnClickListener {
            val intent = Intent(this@UserOrRiderActivity, RiderRegActivity::class.java)
            startActivity(intent)
        }

        binding.userReg.setOnClickListener {
            val intent = Intent(this@UserOrRiderActivity, UserRegActivity::class.java)
            startActivity(intent)
        }

    }
}