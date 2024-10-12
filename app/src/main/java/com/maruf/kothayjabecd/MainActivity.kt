package com.maruf.kothayjabecd

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.maruf.kothayjabecd.databinding.ActivityMainBinding
import com.maruf.kothayjabecd.databinding.ServiceItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        try {
            servicesFun()
            actionFun()
        } catch (e: Exception){
            Log.e("TAG", "onCreate: $e", )
        }

        binding.action1.actionView.setOnClickListener {
            Toast.makeText(this, "app share", Toast.LENGTH_SHORT).show()
        }


    }

    private fun actionFun() {
//        action 1 binding
        binding.action1.actionTitle.text = "Invite Friends"
        binding.action1.actionSubtitle.text = "Share this app with friends and family for rewards!"
        binding.action1.actionIcon.setImageResource(R.drawable.invite_icon)

//        action 2 binding
        binding.action2.actionTitle.text = "Discover"
        binding.action2.actionSubtitle.text = "Fast and reliable express delivery at your service!"
        binding.action2.actionIcon.setImageResource(R.drawable.express_delivery)

//        action3Binding
        binding.action3.actionTitle.text = "Points"
        binding.action3.actionSubtitle.text = "Earn points and redeem rewards!"
        binding.action3.actionIcon.setImageResource(R.drawable.points)

    }

    private fun servicesFun() {
        // Bind the bikeService layout and modify its views
        binding.bikeService.serviceText.text = "Bike"
        binding.bikeService.serviceIcon.setImageResource(R.drawable.bike)

        // Bind the foodService layout and modify its views
        binding.foodService.serviceText.text = "Food"
        binding.foodService.serviceIcon.setImageResource(R.drawable.food)

        // Bind the parcelService layout and modify its views
        binding.parcelService.serviceText.text = "Parcel"
        binding.parcelService.serviceIcon.setImageResource(R.drawable.parcel)

        // Bind the allService layout and modify its views
        binding.allService.serviceText.text = "All"
        binding.allService.serviceIcon.setImageResource(R.drawable.all)

    }
}