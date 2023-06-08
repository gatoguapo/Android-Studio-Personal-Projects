package com.example.ejerciciodepoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var deportista: Deportista = Deportista("Ramirez", 1.60f, 58.30f, 21)
        deportista.descansar()

        println("*****************")
        var runner = Runner("Mbappe", 1.60f, 58.30f, 21, "100 mts planos", 7.50f)
        runner.competir()
        runner.correr()
        runner.descansar()

        println("*****************")
        var ciclista = Ciclista("Lance Armstrong", 1.60f, 58.30f, 34, "Contrareloj", 15.5f)
        ciclista.competir()
        ciclista.pedalear()
        ciclista.descansar()

        println("*****************")
        var nadador = Nadador("Paloma", 1.60f, 58.30f, 27, "Mariposa", 10.5f)
        nadador.competir()
        nadador.nadar()
        nadador.descansar()

        println("*****************")
        var triatleta = Triatleta("200 mts curvos", 8f, "Montaña", 13f, "Crol", 10f)
        triatleta.correr()
        triatleta.pedalear()
        triatleta.nadar()
    }
}