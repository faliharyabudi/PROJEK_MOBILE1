package com.example.projekmobile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, 80, 0, 0)
            insets
        }

        supportActionBar?.hide()

        // tombol back ke MainActivity
        val imgBack = findViewById<ImageView>(R.id.img_back)
        imgBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        // tombol masuk ke Soal11Activity
        val btnLevel1 = findViewById<RelativeLayout>(R.id.btn_a24)
        btnLevel1.setOnClickListener {
            val intent = Intent(this, Soal11Activity::class.java)
            startActivity(intent)
        }
    }
}
