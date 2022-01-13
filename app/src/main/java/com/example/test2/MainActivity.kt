package com.example.test2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.test2.util.SavedPreference
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var email: String
    private lateinit var emailTv: TextView
    private lateinit var logoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        email = SavedPreference.getEmail(this)!!
        setUpViews()
    }

    private fun setUpViews() {
        emailTv = findViewById(R.id.email_tv)
        logoutButton = findViewById(R.id.logout_button)

        emailTv.text = email

        logoutButton.setOnClickListener {
            logoutUser()
        }
    }

    private fun goToLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun logoutUser() {
        try {
            SavedPreference.setEmail(this, "")
            SavedPreference.setPassword(this, "")
            goToLoginActivity()
        } catch (e: Exception) {
            Toast.makeText(this, "logout failed! Please try again.", Toast.LENGTH_SHORT).show()
        }
    }
}