package com.example.app_cda_b2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.setFragmentResultListener

class ProfileDetails: AppCompatActivity() {
//    @Suppress("DEPRECATION")
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)

        // Get profile from MainActivity

        val profile = intent.getParcelableExtra<Profile>("profile")
        val nameTextView = findViewById<TextView>(R.id.name)
        val ageTextView = findViewById<TextView>(R.id.age)
        nameTextView.text = "Nom: ${profile?.name}"
        ageTextView.text = "Nom: ${profile?.age}"

        // Create dialog btn
        findViewById<Button>(R.id.show_dialog_btn).setOnClickListener {
            val fragment = ConfirmDeleteDialogFragment()
            fragment.listener = object: ConfirmDeleteDialogFragment.ConfirmDeleteListener{
                override fun onDialogPositiveClick() {
                    val fragment = FileListDialogFragment()
                    fragment.show(fragmentManager, "fileListDialogFragment")
                }

                override fun onDialogNegativeClick() {
                }
            }
            fragment.show(fragmentManager, "fileListDialogFragment")
        }

    }
}