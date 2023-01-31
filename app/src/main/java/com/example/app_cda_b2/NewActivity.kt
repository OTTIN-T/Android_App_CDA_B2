package com.example.app_cda_b2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NewActivity : AppCompatActivity() {
    val TAG = "NewActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        // DEFINE ACTION
        val action = intent.action
        // Catch category
        val isUserView = intent.hasCategory("user")
        // Charge extra in bundel
        val extras: Bundle? = intent.extras
        val name = extras?.getString("name")
        val age = extras?.getInt("age")

        Log.i(TAG, "Actions: $action, isUserViewer: $isUserView, name: $name, age: $age")
    }
}