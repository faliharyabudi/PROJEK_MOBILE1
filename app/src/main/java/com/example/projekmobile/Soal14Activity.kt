package com.example.projekmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Soal14Activity : AppCompatActivity() {

    private var score = 0
    private var selectedButton: Button? = null
    private var selectedAnswer: String? = null
    private lateinit var jawabanBenar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal14)

        // Hover tombol jawaban
        val btnA = findViewById<Button>(R.id.btn_a14)
        val btnB = findViewById<Button>(R.id.btn_b14)
        val btnC = findViewById<Button>(R.id.btn_c14)
        val btnD = findViewById<Button>(R.id.btn_d14)

        var selectedButton: Button? = null
        var selectedAnswer: String? = null

        fun handleJawabanDipilih(button: Button, answer: String) {
            // Reset tampilan tombol sebelumnya
            selectedButton?.background = ContextCompat.getDrawable(this, R.drawable.button_shape)
            selectedButton?.setTextColor(ContextCompat.getColor(this, R.color.putih))

            // Ubah tampilan tombol yang dipilih
            button.setBackgroundResource(R.drawable.button_selected)
            button.setTextColor(ContextCompat.getColor(this, R.color.hitam))

            selectedButton = button
            selectedAnswer = answer
        }

        // Listener tombol
        btnA.setOnClickListener { handleJawabanDipilih(btnA, "A") }
        btnB.setOnClickListener { handleJawabanDipilih(btnB, "B") }
        btnC.setOnClickListener { handleJawabanDipilih(btnC, "C") }
        btnD.setOnClickListener { handleJawabanDipilih(btnD, "D") }

        // Logika score
        val jawabanBenar = "A"
        var score = intent.getIntExtra("score", 0)
        val arrowNext = findViewById<ImageView>(R.id.arrow_lvl1)

        arrowNext.setOnClickListener {
            if (selectedAnswer != null) {
                if (selectedAnswer == jawabanBenar) {
                    score += 20
                }
                val intent = Intent(this, Soal15Activity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
            }
        }
    }
}