package com.maruf.kothayjabecd



import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.ActivityOptions
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


                        Utils.flashOverlayEffect(binding.flashOverlay,this, binding.main) {
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
//                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        }
                    }

                }, 2000) // Delay to simulate network call


            } else {
                binding.progressbar.visibility = View.GONE

                if (email.isEmpty()) {
                    Utils.fieldFocus(binding.emailInput, "Email field cannot be empty")
                }else if(password.isEmpty()) {
                    Utils.fieldFocus(binding.passwordInput, "Password field cannot be empty")
                }

            }
        }

        binding.signupButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, UserRegActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.zoom_in, R.anim.no_anim)
            startActivity(intent, options.toBundle())
        }

//        binding.forgotPassword.setOnClickListener {
//            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
//            startActivity(intent)
//        }

    }



}