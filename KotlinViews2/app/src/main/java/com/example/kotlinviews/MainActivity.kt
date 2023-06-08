package com.example.kotlinviews

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var textViewEjemplo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeInterface()
        makeListeners()
    }

    private fun makeInterface() {
        textViewEjemplo = findViewById(R.id.textViewEjemplo)
        textViewEjemplo.apply {
            text = "Cambiado desde codigo!"
            setTextColor(Color.RED)
            setTypeface(Typeface.MONOSPACE, Typeface.BOLD)
        }
    }
    private fun makeListeners() {
        textViewEjemplo.setOnClickListener {
            Toast.makeText(this,"TextView Clicked!",Toast.LENGTH_LONG).show()
            textViewEjemplo.setTextColor(Color.GREEN)
        }
    }
}