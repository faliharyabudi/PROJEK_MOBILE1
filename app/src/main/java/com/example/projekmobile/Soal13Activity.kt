package com.example.projekmobile

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Soal13Activity : AppCompatActivity() {

    private var selectedButton: Button? = null
    private var selectedAnswer: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal13)

        val btnA = findViewById<Button>(R.id.btn_a13)
        val btnB = findViewById<Button>(R.id.btn_b13)
        val btnC = findViewById<Button>(R.id.btn_c13)
        val btnD = findViewById<Button>(R.id.btn_d13)

        fun handleJawabanDipilih(button: Button, answer: String) {
            selectedButton?.background = ContextCompat.getDrawable(this, R.drawable.button_shape)
            selectedButton?.setTextColor(ContextCompat.getColor(this, R.color.putih))

            button.setBackgroundResource(R.drawable.button_selected)
            button.setTextColor(ContextCompat.getColor(this, R.color.hitam))

            selectedButton = button
            selectedAnswer = answer
        }

        btnA.setOnClickListener { handleJawabanDipilih(btnA, "A") }
        btnB.setOnClickListener { handleJawabanDipilih(btnB, "B") }
        btnC.setOnClickListener { handleJawabanDipilih(btnC, "C") }
        btnD.setOnClickListener { handleJawabanDipilih(btnD, "D") }
    }
}
