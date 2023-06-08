package com.example.materialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.materialdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnIniSesion.setOnClickListener {
            val numControl = binding.editTextNumCtrl.editText?.text.toString()
            val password = binding.editTextPassword.editText?.text.toString()

            Toast.makeText(this, "Numero de control:$numControl, Contraseña:$password", Toast.LENGTH_LONG).show()
        }

        setContentView(binding.root)
    }
}