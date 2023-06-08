package com.example.ejerciciodepoo

open class Deportista(
    private var nombre: String,
    private var estatura: Float,
    private var peso: Float,
    private var edad: Int
){

    fun descansar() {
        println("$nombre esta descansando")
    }
}

open class Runner(nombre: String, estatura: Float, peso: Float, edad: Int, private var estilo: String, private var velocidad: Float): Deportista(nombre, estatura, peso, edad) {
    private var nombre: String = ""

    init {
        this.nombre = nombre
    }

    fun correr() {
        println("$nombre esta corriendo en el estilo de $estilo a una velocidad de $velocidad m/s")
    }

    fun competir() {
        println("Voy a correr!!!")
    }
}

open class Ciclista(nombre: String, estatura: Float, peso: Float, edad: Int, private var tipoBicicleta: String, private var velocidad: Float): Deportista(nombre, estatura, peso, edad) {
    private var nombre: String = ""

    init {
        this.nombre = nombre
    }

    fun pedalear() {
        println("$nombre esta pedaleando con una bici $tipoBicicleta a una velocidad de $velocidad m/s")
    }

    fun competir() {
        println("Voy a pedalear!!!")
    }
}

open class Nadador(nombre: String, estatura: Float, peso: Float, edad: Int, private var estilo: String, var velocidad: Float): Deportista(nombre, estatura, peso, edad) {
    private var nombre: String = ""

    init {
        this.nombre = nombre
    }

    fun nadar() {
        println("$nombre esta nadando en el estido de $estilo a una velocidad de $velocidad m/s")
    }

    fun competir() {
        println("Voy a nadar!!!")
    }
}

interface RunnerTri {
    var estiloRunner: String
    var velocidadRunner: Float

    fun correr() {
        println("El triatleta esta corriendo en el estilo de $estiloRunner a una velocidad de $velocidadRunner m/s")
    }
}

interface CiclistaTri {
    var estiloBici: String
    var velocidadBici: Float

    fun pedalear() {
        println("El triatleta esta pedaleando con una bici $estiloBici a una velocidad de $velocidadBici m/s")
    }
}

interface NadadorTri {
    var estiloNadadador: String
    var velocidadNadador: Float

    fun nadar() {
        println("El triatleta esta nadando en el estilo de $estiloNadadador a una velocidad de $velocidadNadador m/s")
    }
}
class Triatleta(override var estiloRunner: String, override var velocidadRunner: Float,
                override var estiloBici: String, override var velocidadBici: Float,
                override var estiloNadadador: String, override var velocidadNadador: Float):RunnerTri, CiclistaTri, NadadorTri {

}