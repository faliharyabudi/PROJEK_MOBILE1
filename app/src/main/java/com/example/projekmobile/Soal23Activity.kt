package com.example.projekmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Soal23Activity : AppCompatActivity() {

    private var selectedButton: Button? = null
    private var selectedAnswer: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal23)

        val btnA = findViewById<Button>(R.id.btn_a23)
        val btnB = findViewById<Button>(R.id.btn_b23)
        val btnC = findViewById<Button>(R.id.btn_c23)
        val btnD = findViewById<Button>(R.id.btn_d23)

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

        var score = intent.getIntExtra("score", 0)
        val jawabanBenar = "B" // Jawa Timur

        val arrowNext = findViewById<ImageView>(R.id.arrow_lvl1)
        arrowNext.setOnClickListener {
            if (selectedAnswer != null) {
                if (selectedAnswer == jawabanBenar) {
                    score += 20
                }
                val intent = Intent(this, Soal24Activity::class.java) // lanjut ke soal 24
                intent.putExtra("score", score)
                startActivity(intent)
            } else {
                val layout = layoutInflater.inflate(R.layout.custom_toast, null)
                val toast = Toast(applicationContext)
                toast.duration = Toast.LENGTH_SHORT
                toast.view = layout
                toast.show()
            }
        }

        val btnBack = findViewById<ImageView>(R.id.img_back)
        btnBack.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.dialog_exit, null)
            val dialog = android.app.AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(true)
                .create()

            val btnYakin = dialogView.findViewById<Button>(R.id.btn_yakin)
            btnYakin.setOnClickListener {
                val intent = Intent(this, Soal22Activity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }

            dialog.show()
        }
    }
}
