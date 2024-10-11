package com.maruf.kothayjabecd

import android.os.Bundle
import android.util.Log
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
        } catch (e: Exception){
            Log.e("TAG", "onCreate: $e", )
        }




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