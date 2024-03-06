package com.example.spinnerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class messageLanguaje : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_languaje)

        var txtView = findViewById<TextView>(R.id.textView2)
        val selection = intent.getStringExtra("Seleccion")
        txtView.text = "Elemento Seleccionado $selection"

        backtoFirst()
    }

    fun backtoFirst() {
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
    }
}