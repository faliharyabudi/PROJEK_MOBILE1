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
        val btnBack = findViewById<ImageView>(R.id.img_back)

        // navigasi tombol back
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // navigasi tombol LEVEL 1 ke Soal11Activity
        val btnLevel1 = findViewById<RelativeLayout>(R.id.btn_lvl1)
        btnLevel1.setOnClickListener {
            val intent = Intent(this, Soal11Activity::class.java)
            startActivity(intent)
        }

        // navigasi tombol LEVEL 2 ke Soal21Activity
        val btnLevel2 = findViewById<RelativeLayout>(R.id.btn_lvl2)
        btnLevel2.setOnClickListener {
            val intent = Intent(this, Soal21Activity::class.java)
            startActivity(intent)
        }

        // navigasi tombol LEVEL 3 ke Soal31Activity
        val btnLevel3 = findViewById<RelativeLayout>(R.id.btn_lvl3)
        btnLevel3.setOnClickListener {
            val intent = Intent(this, Soal31Activity::class.java)
            startActivity(intent)
        }
    }
}
