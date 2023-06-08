package com.example.practicaskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preguntaUno()
        preguntaDos()
        preguntaTres()
        preguntaCuatro()
        preguntaCinco()
    }

    fun preguntaUno() {
        println(" *** Pregunta 1 *** ")
        var index: Int = 9
        do {
            println(index)
            index--
            if (index == 0) println(index)
        } while (index != 0)
    }

    fun preguntaDos() {
        println(" *** Pregunta 2 *** ")
        var index: Int = 1
        do {
            index++
            if (index % 2 == 0) println(index)
        } while (index != 10)
    }

    fun preguntaTres() {
        println(" *** Pregunta 3 *** ")
        var platillos: Array<String> =
            arrayOf("Pizza", "Hamburgesa", "Sushi", "Boneless", "Papas Fritas")
        for (i in 0 until platillos.size) {
            println("PLatillo ${i + 1}: ${platillos.get(i)}")
        }
    }

    fun preguntaCuatro() {
        println(" *** Pregunta 4 *** ")
        var platillos: Map<String, Int> = mapOf(
            "Pizza" to 185,
            "Hamburguesa" to 150,
            "Sushi" to 165,
            "Boneless" to 120,
            "Papas Fritas" to 75
        )
        val listView = platillos.map { "${it.key} cuesta ${it.value} pesos" }
        listView.forEach { println(it) }
    }

    fun preguntaCinco() {
        println(" *** Pregunta 5 *** ")
        var platillos = arrayOf(
            arrayOf("Pizza", 185, arrayOf("Harina", "Tomate", "Peperoni", "Queso")),
            arrayOf(
                "Hamburguesa",
                150,
                arrayOf(
                    "Pan de Hamburguesa",
                    "Tomate",
                    "Carne para hamburguesa",
                    "Queso",
                    "Lechuga"
                )
            ),
            arrayOf("Sushi", 165, arrayOf("Arroz", "Algas", "Philadelfia", "Camaron", "Salmon")),
            arrayOf(
                "Boneless",
                120,
                arrayOf("Pechuga de Pollo", "Galleta Molida", "Salsa Buffalo")
            ),
            arrayOf("Papas Fritas", 75, arrayOf("Papas"))
        )

        for (i in 0 until platillos.size) {
            for (j in 0 until platillos.size) {
                println()
                when (j) {
                    0 -> {
                        print("$i: ${platillos[i][j]}")
                    }
                    1 -> {
                        print("$${platillos[i][j]}")
                    }
                    2 -> {
                        print("Incredientes: ")
                        var ingredientes: Array<String> = platillos[i][j] as Array<String>
                        for (i in ingredientes) {
                            print("$i - ")
                        }
                    }
                }
            }
        }
    }
}