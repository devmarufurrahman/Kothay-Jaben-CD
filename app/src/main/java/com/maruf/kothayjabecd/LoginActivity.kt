package com.maruf.kothayjabecd

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.maruf.kothayjabecd.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.loginBtn.setOnClickListener {
            binding.progressbar.visibility = View.VISIBLE
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                binding.progressbar.visibility = View.GONE
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
            } else {
                binding.progressbar.visibility = View.GONE
                Toast.makeText(this, "Empty Fields Are not Allowed", Toast.LENGTH_SHORT).show()

            }
        }

        binding.signupButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, UserOrRiderActivity::class.java)
            startActivity(intent)
        }

//        binding.forgotPassword.setOnClickListener {
//            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
//            startActivity(intent)
//        }

    }
}