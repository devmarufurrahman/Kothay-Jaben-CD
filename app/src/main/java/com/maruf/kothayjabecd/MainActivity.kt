package com.maruf.kothayjabecd

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
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
            sliderShow()
        } catch (e: Exception){
            Log.e("TAG", "onCreate: $e", )
        }

        binding.action1.actionView.setOnClickListener {
            Toast.makeText(this, "app share", Toast.LENGTH_SHORT).show()
        }


    }

    private fun sliderShow() {
        val imageList = ArrayList<SlideModel>() // Create image list

// imageList.add(SlideModel("String Url" or R.drawable)
// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(SlideModel("https://cdn.grabon.in/gograbon/images/web-images/uploads/1618575517942/food-coupons.jpg" ))
        imageList.add(SlideModel("https://images.squarespace-cdn.com/content/v1/5a5dbe4632601eb31977f947/1633327221357-NWREEQY82IAW2PFJXUM0/AirAsia_Food_EverydaySale_PR_4Oct-31Oct2021-1200x628_EN.jpg"))
        imageList.add(SlideModel("https://britishmums.com/dubai/wp-content/uploads/2020/11/GMP-Ads-nov-10-01-05-1276x640.jpg"))
        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrJ-UUTz8C1RmXsUw8D9ZScere-xbvXWqqkf_VzbmFkTOIZwMA-V-3_43IU-uHjR-OBhQ&usqp=CAU"))
        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR91P2r6mo3OcUP7qRGPNUpUKv0BEIys2XCTCtJa68BPZFwFhjV6TkvrtsCMPOojsQIvZQ&usqp=CAU"))
        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmBSGt_OVivn_MBZw7m_qm7ulqetVPxy66zjHTtmvnini0_y9zL9_MjYGKNtCMz8LCmSY&usqp=CAU"))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
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