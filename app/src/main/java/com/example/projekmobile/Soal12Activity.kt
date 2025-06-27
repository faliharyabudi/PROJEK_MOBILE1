package com.example.projekmobile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.app.AlertDialog
import android.widget.Button
import androidx.core.content.ContextCompat

class Soal12Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal12)

        val btnBack = findViewById<ImageView>(R.id.img_back)

        // Navigasi tombol back
        btnBack.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.dialog_exit, null)
            val dialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(true)
                .create()

            val btnYakin = dialogView.findViewById<Button>(R.id.btn_yakin)
            btnYakin.setOnClickListener {
                val intent = Intent(this, HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }

            dialog.show()
        }

        //Efek Hover
        val btnA = findViewById<Button>(R.id.btn_a12)
        val btnB = findViewById<Button>(R.id.btn_b12)
        val btnC = findViewById<Button>(R.id.btn_c12)
        val btnD = findViewById<Button>(R.id.btn_d12)

        var selectedButton: Button? = null
        var selectedAnswer: String? = null

        fun handleJawabanDipilih(button: Button, answer: String) {
            // Reset tampilan tombol sebelumnya
            selectedButton?.background = ContextCompat.getDrawable(this, R.drawable.button_shape)
            selectedButton?.setTextColor(ContextCompat.getColor(this, R.color.putih))

            // Tampilkan efek hover di tombol yang baru dipilih
            button.setBackgroundResource(R.drawable.button_selected)
            button.setTextColor(ContextCompat.getColor(this, R.color.hitam))

            selectedButton = button
            selectedAnswer = answer
        }

        // Listener klik pada semua tombol jawaban
        btnA.setOnClickListener { handleJawabanDipilih(btnA, "A") }
        btnB.setOnClickListener { handleJawabanDipilih(btnB, "B") }
        btnC.setOnClickListener { handleJawabanDipilih(btnC, "C") }
        btnD.setOnClickListener { handleJawabanDipilih(btnD, "D") }

        //Navigasi ke soal selanjutnya
        val arrowNext = findViewById<ImageView>(R.id.arrow_lvl1)

        // Skor awal yang dibawa dari soal sebelumnya
        var score = intent.getIntExtra("score", 0)

        // Jawaban benar soal 12 adalah "D"
        val jawabanBenar = "D"

        // Navigasi ke soal 13
        arrowNext.setOnClickListener {
            // Cek apakah jawaban sudah dipilih
            if (selectedAnswer != null) {
                if (selectedAnswer == jawabanBenar) {
                    score += 20
                }

                val intent = Intent(this, Soal13Activity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
            } else {

            }
        }
    }
}
