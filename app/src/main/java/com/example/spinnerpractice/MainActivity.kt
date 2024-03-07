package com.example.spinnerpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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

        var arrayLanguajes = mutableListOf("Seleccion")
        var textTypingMain = findViewById<EditText>(R.id.editText)
        val buttonSend = findViewById<Button>(R.id.btnSend)
        var spinnerLanguajes = findViewById<Spinner>(R.id.languajesSpinner)
        val intentSpinner = Intent(this, messageLanguaje::class.java)


        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayLanguajes)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLanguajes.adapter = arrayAdapter

        buttonSend.setOnClickListener {
            var contentTextTypingMain = textTypingMain.text.toString()
            if (contentTextTypingMain.isNotEmpty()) {
                if(contentTextTypingMain != " ") {
                    arrayLanguajes.add(contentTextTypingMain)
                    arrayAdapter.notifyDataSetChanged()
                    textTypingMain.text.clear()
                }
            }
        }

        spinnerLanguajes.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view:View?, position: Int, id: Long) {

                val selectedItem = spinnerLanguajes.selectedItem.toString()
                if (selectedItem != "Seleccion") {
                    intentSpinner.putExtra("Seleccion", selectedItem)
                    startActivity(intentSpinner)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }
}