package com.example.spinnerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textTypingMain = findViewById<EditText>(R.id.editText)
        val buttonSend = findViewById<Button>(R.id.btnSend)
        var spinnerLanguajes: Spinner = findViewById<Spinner>(R.id.languajesSpinner)
        var arrayLanguajes = mutableListOf<String>()

        buttonSend.setOnClickListener {
            var contentTextTypingMain = textTypingMain.text.toString()
            if (!contentTextTypingMain.isNullOrEmpty()) {
                if (contentTextTypingMain != " ") {
                    arrayLanguajes.add(textTypingMain.text.toString())
                    var arrayAdapter =
                        ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayLanguajes)
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinnerLanguajes.adapter = arrayAdapter
                }
            }

        }
    }
}