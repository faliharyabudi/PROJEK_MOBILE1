package com.example.projekmobile

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Soal11Activity : AppCompatActivity() {

    private var score = 0
    private var selectedButton: Button? = null
    private var selectedAnswer: String? = null
    private lateinit var jawabanBenar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal11)

        // Ambil skor dari soal sebelumnya
        score = intent.getIntExtra("score", 0)

        // Inisialisasi tombol
        val btnA = findViewById<Button>(R.id.btn_a11)
        val btnB = findViewById<Button>(R.id.btn_b11)
        val btnC = findViewById<Button>(R.id.btn_c11)
        val btnD = findViewById<Button>(R.id.btn_d11)
        val arrowNext = findViewById<ImageView>(R.id.arrow_lvl1)
        val btnBack = findViewById<ImageView>(R.id.img_back)

        // Bagian Efek Hover
        fun handleJawabanDipilih(button: Button, answer: String) {

            selectedButton?.background = ContextCompat.getDrawable(this, R.drawable.button_shape)
            selectedButton?.setTextColor(ContextCompat.getColor(this, R.color.putih))

            // Ubah warna tombol yang diklik
            button.setBackgroundResource(R.drawable.button_selected)
            button.setTextColor(ContextCompat.getColor(this, R.color.hitam))

            // Simpan referensi tombol dan jawaban
            selectedButton = button
            selectedAnswer = answer
        }

        // Listener untuk semua tombol pilihan jawaban
        btnA.setOnClickListener { handleJawabanDipilih(btnA, "A") }
        btnB.setOnClickListener { handleJawabanDipilih(btnB, "B") }
        btnC.setOnClickListener { handleJawabanDipilih(btnC, "C") }
        btnD.setOnClickListener { handleJawabanDipilih(btnD, "D") }
    }
}
