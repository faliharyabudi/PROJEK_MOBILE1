package com.example.projekmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Soal31Activity : AppCompatActivity() {

    private var selectedButton: Button? = null
    private var selectedAnswer: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal31)

        val btnA = findViewById<Button>(R.id.btn_a24)
        val btnB = findViewById<Button>(R.id.btn_b24)
        val btnC = findViewById<Button>(R.id.btn_c24)
        val btnD = findViewById<Button>(R.id.btn_d24)

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

        btnA.setOnClickListener { handleJawabanDipilih(btnA, "A") }
        btnB.setOnClickListener { handleJawabanDipilih(btnB, "B") }
        btnC.setOnClickListener { handleJawabanDipilih(btnC, "C") }
        btnD.setOnClickListener { handleJawabanDipilih(btnD, "D") }

        var score = intent.getIntExtra("score", 0)
        val jawabanBenar = "A" // Watt

        val arrowNext = findViewById<ImageView>(R.id.arrow_lvl1)
        arrowNext.setOnClickListener {
            if (selectedAnswer != null) {
                if (selectedAnswer == jawabanBenar) {
                    score += 20
                }

                val intent = Intent(this, Soal32Activity::class.java)
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
                val intent = Intent(this, HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }

            dialog.show()
        }
    }
}
