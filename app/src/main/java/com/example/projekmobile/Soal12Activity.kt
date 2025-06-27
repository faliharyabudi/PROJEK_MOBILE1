package com.example.projekmobile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.app.AlertDialog
import android.widget.Button

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
    }
}
