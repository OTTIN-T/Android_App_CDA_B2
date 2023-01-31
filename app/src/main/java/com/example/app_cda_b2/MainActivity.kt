package com.example.app_cda_b2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.start_new_activity_btn)
        button.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            intent.action = Intent.ACTION_VIEW
            // Add category
            intent.addCategory("user")
            // Add extra in category
            intent.putExtra("name", "Tim")
            intent.putExtra("age", 28)
            startActivity(intent)

        }

        // Create profile Object
        val profile = Profile("Tim", 27)
        val buttonParcelable = findViewById<Button>(R.id.start_profile_activity_btn)
        buttonParcelable.setOnClickListener {
            val intentProfile = Intent(this, ProfileDetails::class.java)
            intentProfile.putExtra("profile", profile)
            startActivity(intentProfile)
        }

        Log.v(TAG, "Verbose message")
        Log.d(TAG, "Debug message")
        Log.i(TAG, "Info message")
        Log.e(TAG, "Error message")
        Log.println(Log.ASSERT,TAG,"Assert message")
    }
}