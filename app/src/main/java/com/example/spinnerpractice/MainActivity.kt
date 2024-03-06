package com.example.spinnerpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendSpinner()

        var textTypingMain = findViewById<EditText>(R.id.editText)
        var spinnerLanguajes: Spinner = findViewById<Spinner>(R.id.languajesSpinner)
        var SpinnerTake = false
        val intentSpinner = Intent(this@MainActivity, messageLanguaje::class.java)

        spinnerLanguajes.setOnTouchListener{ _, _ ->
            SpinnerTake = true
            false
        }
        spinnerLanguajes.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view:View?, position: Int, id: Long) {
                if (SpinnerTake) {
                    val selectedItem = spinnerLanguajes.selectedItem.toString()
                    intentSpinner.putExtra("Seleccion", selectedItem)
                    startActivity(intentSpinner)
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    fun sendSpinner() {
        var textTypingMain = findViewById<EditText>(R.id.editText)
        val buttonSend = findViewById<Button>(R.id.btnSend)
        var spinnerLanguajes: Spinner = findViewById<Spinner>(R.id.languajesSpinner)
        var arrayLanguajes = mutableListOf<String>()
        buttonSend.setOnClickListener {
            var contentTextTypingMain = textTypingMain.text.toString().trim()
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