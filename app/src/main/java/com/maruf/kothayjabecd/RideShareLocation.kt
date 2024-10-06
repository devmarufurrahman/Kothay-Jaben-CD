package com.maruf.kothayjabecd

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.OnSuccessListener
import java.io.IOException

class RideShareLocation : FragmentActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
//    private lateinit var binding: Ac
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private lateinit var destination_area: TextView
    private lateinit var selectedOrNot: TextView
    private lateinit var backRideShare: Button

    private var event_longitude: String? = null
    private var event_latitude: String? = null
    private var address: String? = null
    private var lastLat: Double = 0.0
    private var lastLong: Double = 0.0
    private var user_latitude: Double = 0.0
    private var user_longitude: Double = 0.0
    private var destinationLocation: LatLng? = null
    private var userLocation: LatLng? = null
    private var km: Float = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ride_share_location)

        // ID selection
        destination_area = findViewById(R.id.destination_area)
        selectedOrNot = findViewById(R.id.selectedOrNot)
        backRideShare = findViewById(R.id.backRideShare)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        backRideShare.setOnClickListener {
            val intent = Intent(this@RideShareLocation, RideShareActivity::class.java)
            intent.putExtra("distance", km)
            intent.putExtra("destination", address)
            startActivity(intent)
            finish()
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
//                1
//            )
//            return
//        }

//        mMap.isMyLocationEnabled = true

        mMap.setOnMapClickListener { latLng ->
            mMap.clear()
            destinationLocation = latLng
            val markerOptions = MarkerOptions().apply {
                position(destinationLocation!!)
                icon(setIcon(this@RideShareLocation, R.drawable.user_location))
                title("Destination Location")
            }
            mMap.addMarker(markerOptions)
            // Route calculation
            getCalculateRoute()
        }

        fetchMyLocation()
    }

    private fun fetchMyLocation() {
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                andrManifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            return
//        }

//        val task = fusedLocationProviderClient.lastLocation
//        task.addOnSuccessListener(OnSuccessListener { location ->
//            if (location != null) {
//                lastLat = location.latitude
//                lastLong = location.longitude
//                userLocation = LatLng(lastLat, lastLong)
//
//                val cameraPosition = CameraPosition.Builder()
//                    .target(userLocation)
//                    .zoom(16.0f)
//                    .build()
//
//                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
//                mMap.addMarker(
//                    MarkerOptions()
//                        .position(userLocation!!)
//                        .title("Current Location")
//                        .icon(setIcon(this@RideShareLocation, R.drawable.user_location))
//                )
//            }
//        })
    }

    private fun setIcon(context: Activity, drawableID: Int): BitmapDescriptor {
        val drawable = ActivityCompat.getDrawable(context, drawableID)!!
        drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
        val bitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

    private fun getCalculateRoute() {
        val startPoint = Location("Start Point").apply {
            latitude = lastLat
            longitude = lastLong
        }

        val endPoint = Location("End Point").apply {
            latitude = destinationLocation!!.latitude
            longitude = destinationLocation!!.longitude
        }

        val distance = startPoint.distanceTo(endPoint)
        km = (distance / 1000).toFloat()

        Log.d("distance", km.toString())
        Log.d("distance_raw", distance.toString())

        val geocoder = Geocoder(this)
//        try {
//            val addressList: List<Address> = geocoder.getFromLocation(
//                destinationLocation!!.latitude,
//                destinationLocation!!.longitude,
//                1
//            )
//
//            address = addressList[0].getAddressLine(0)
//            destination_area.text = "Area: $address"
//            selectedOrNot.text = "Your destination is selected"
//
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
    }


}