package com.example.poo_kotlin

class SubClases {
    private var name = "Padre"

    fun presentar(): String {
    return name
    }

    class Anidada{
        private val nameAnidada = "Anidada"
        fun presentar(): String {
            return nameAnidada
        }
    }

    inner class Interna{
        private val nameInterna = "Interna"
        fun presentar(): String {
            var obj = SubClases.Anidada()
            return "Hola soy $nameInterna, hija de ${name} y hermana de ${obj.presentar()}"
        }
    }
}