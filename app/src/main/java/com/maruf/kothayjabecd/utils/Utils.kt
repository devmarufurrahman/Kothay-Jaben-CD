package com.maruf.kothayjabecd.utils

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import com.maruf.kothayjabecd.R


object Utils {
    fun buttonAnimation(button: Button, progressBar: ProgressBar, context: Context) {

        // Show the loading spinner and hide the button text
        button.text = ""
        progressBar.visibility = View.VISIBLE
        val setPadding = 20.dpToPx(context)
        button.setPadding(setPadding,setPadding,setPadding,setPadding)
    }


    fun animateSuccess(button: Button, progressBar: ProgressBar, successMsg: String, duration: Long, context: Context, activity: Activity):Boolean {

        // Stop loading and apply appropriate animation
        progressBar.visibility = View.GONE
        val setPadding = 0.dpToPx(context)
        button.setPadding(setPadding,setPadding,setPadding,setPadding)
        button.text = successMsg
        // Expanding animation
        val expandAnimator = ObjectAnimator.ofFloat(button, "scaleX", 1f, 1.1f)
        expandAnimator.setDuration(duration)
        expandAnimator.start()


        expandAnimator.addListener(object : android.animation.Animator.AnimatorListener {
            override fun onAnimationStart(animation: android.animation.Animator) {}

            override fun onAnimationEnd(animation: android.animation.Animator) {

            }

            override fun onAnimationCancel(animation: android.animation.Animator) {}

            override fun onAnimationRepeat(animation: android.animation.Animator) {}
        })
        return true
    }


    fun animateFailure(failMsg : String, button: Button, context: Context) {
        // Shake animation on failure
        val shake: Animation = AnimationUtils.loadAnimation(context, R.anim.shake)
        button.startAnimation(shake)

        // Reset button text after shake animation
        shake.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                button.text = failMsg
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
    }


    fun flashOverlayEffect(flashOverlay: View, context: Context, rootLayout: View, onAnimationEnd: () -> Unit){

        flashOverlay.visibility = View.VISIBLE

        // Animate the height of the flashOverlay from 0 to match_parent
        val initialHeight = rootLayout.height
        val initialWidth = rootLayout.width

//      Animate from 0 to double the height and width
        val animator = ValueAnimator.ofFloat(0f, 2f)
        animator.duration = 400 // Flash duration, you can adjust this

        animator.addUpdateListener { animation ->
            val animatedValue = animation.animatedValue as Float

            // Set the height and width of flashOverlay to double the size of the main screen
            flashOverlay.layoutParams.height = (initialHeight * animatedValue).toInt()
            flashOverlay.layoutParams.width = (initialWidth * animatedValue).toInt()

            // Request layout to apply the updated dimensions
            flashOverlay.requestLayout()
        }
        animator.start()

        // Hide overlay after animation ends
        animator.addListener(object : android.animation.Animator.AnimatorListener {

            override fun onAnimationStart(animation: android.animation.Animator) {

            }

            override fun onAnimationEnd(animation: android.animation.Animator) {
                rootLayout.setBackgroundColor(ContextCompat.getColor(context,R.color.red))
             onAnimationEnd()
            }

            override fun onAnimationCancel(animation: android.animation.Animator) {}

            override fun onAnimationRepeat(animation: android.animation.Animator) {}
        })

    }


    fun Int.dpToPx(context: Context): Int {
        return (this * context.resources.displayMetrics.density).toInt()
    }

    fun buttonFocus(btn: Button, error: String) {
        btn.error = error
        btn.isFocusable = true
        btn.isFocusableInTouchMode = true
        btn.requestFocus()
    }


    fun fieldFocus(field: EditText, error: String) {
        field.error = error
        field.requestFocus()
    }
    
}