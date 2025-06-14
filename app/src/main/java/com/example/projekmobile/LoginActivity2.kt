package com.example.projekmobile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBackLoginListener()
        btnRegisterListener()
    }

    private fun btnBackLoginListener() {
        val imgBack = findViewById<ImageView>(R.id.img_back)
        imgBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun btnRegisterListener() {
        val txtLogin = findViewById<TextView>(R.id.txt_login)
        txtLogin.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
