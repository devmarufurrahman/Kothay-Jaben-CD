package com.maruf.kothayjabecd



import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.maruf.kothayjabecd.databinding.ActivityLoginBinding
import com.maruf.kothayjabecd.utils.Utils


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var flashOverlay : View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        flashOverlay = binding.flashOverlay


        binding.loginBtn.setOnClickListener {
            binding.progressbar.visibility = View.VISIBLE
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {

                Utils.buttonAnimation(binding.loginBtn,binding.progressbar, this)

                // Simulate network call with delay
                Handler().postDelayed(Runnable {
                    val animateSuccess = Utils.animateSuccess(binding.loginBtn,binding.progressbar,"Login Successfully", 300,this,this)

                    if (animateSuccess){
                        //Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()


                        Utils.flashOverlayEffect(binding.flashOverlay, binding.main) {
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
//                            overridePendingTransition()
                        }
                    }

                }, 2000) // Delay to simulate network call


            } else {
                binding.progressbar.visibility = View.GONE
                Toast.makeText(this, "Empty Fields Are not Allowed", Toast.LENGTH_SHORT).show()
                Utils.animateFailure("Login", binding.loginBtn, this)
            }
        }

        binding.signupButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, UserRegActivity::class.java)
            startActivity(intent)
        }

//        binding.forgotPassword.setOnClickListener {
//            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
//            startActivity(intent)
//        }

    }



}