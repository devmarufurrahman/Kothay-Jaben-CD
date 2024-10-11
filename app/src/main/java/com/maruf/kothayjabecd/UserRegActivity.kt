package com.maruf.kothayjabecd

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.maruf.kothayjabecd.databinding.ActivityUserRegBinding

class UserRegActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserRegBinding
    private lateinit var name : String
    private lateinit var contact : String
    private lateinit var password : String
    private lateinit var c_password : String
    private lateinit var address : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_reg)

        // Find the toolbar and set it as the action bar
        val toolbar = binding.customToolbar
        setSupportActionBar(toolbar)
        // Enable the back button in the toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.icon_arrow_back)

        binding.SignUpBtn.setOnClickListener {
            name = binding.userName.text.toString()
            contact = binding.userContact.text.toString()
            password = binding.userPass.text.toString()
            c_password = binding.userPassC.text.toString()
            address = binding.userAddress.text.toString()

            val intent = Intent(this@UserRegActivity, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    // Handle the back button click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {

                finish() // Finishes the current activity
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}