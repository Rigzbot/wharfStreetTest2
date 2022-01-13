package com.example.test2

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test2.util.SavedPreference
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()


        if(SavedPreference.getEmail(this) != "") {
            goToMainActivity()
        }

        setupViews()
    }

    private fun setupViews() {
        emailEt = findViewById(R.id.email_et)
        passwordEt = findViewById(R.id.password_et)
        button = findViewById(R.id.login_button)

        button.setOnClickListener {
            loginUser()
        }
    }

    private fun goToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun loginUser() {
        val emailText = emailEt.text
        val passwordText = passwordEt.text

        if(TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText)){
            Toast.makeText(this, "Fields cannot be empty. Please type both values.", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            SavedPreference.setEmail(this, emailText.toString())
            SavedPreference.setPassword(this, passwordText.toString())
            goToMainActivity()
        } catch (e: Exception) {
            Toast.makeText(this, "Login failed! Please try again.", Toast.LENGTH_SHORT).show()
        }
    }
}