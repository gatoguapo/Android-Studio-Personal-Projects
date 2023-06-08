package com.example.poo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

typealias aliasObjeto = SubClases.Anidada
typealias aliasDato = MutableMap<Int, ArrayList<String>>
typealias aliasFuncion = (a: Int, b: Int) -> Int

class MainActivity : AppCompatActivity() {
    private lateinit var pok: Pokemon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usuario = "    soy   yo   "
        println("$usuario (${usuario.length}) - ${usuario.noSpace()} (${usuario.noSpace().length})")

        var array: Array<Int> = arrayOf(5, 4, 3, 2, 1)

        val array2 = IntArray(3)
        array2[0] = 10
        array2[1] = 20
        array2[2] = 30

        println("array2: "); array2.show();

        val array3: IntArray = intArrayOf(1, 2, 3, 4, 5)
        println("array3: "); array3.show()

        println("La suma de 80 y 20 es ${calculadora(80, 20, ::suma)}")
        println("La resta de 80 y 20 es ${calculadora(80, 20, ::resta)}")
        println("La multiplicacion de 80 y 20 es ${calculadora(80, 20, ::multiplicacion)}")
        println("La division de 80 y 20 es ${calculadora(80, 20, ::division)}")

        val jota = Person("Jota", "A5786283", 1.62f)
        if (jota.checkPolice(::inColombia)) println("${jota.name} puede ser policia en colombia")
        if (jota.checkPolice(::inSpain)) println("${jota.name} puede ser policia en colombia")

        var funcion = { x: Int, y: Int -> x + y }
        println("La suma de 80 y 20 con variable es ${calculadora(80, 20, funcion)}")

        funcion = { x: Int, y: Int -> x - y }
        println("La resta de 80 y 20 con variable es ${calculadora(80, 20, funcion)}")

        println(
            "La suma de 80 y 20 con lambda es ${
                calculadora(
                    80,
                    20,
                    { x: Int, y: Int -> x + y })
            }"
        )
        println(
            "La resta de 80 y 20 con lambda es ${
                calculadora(
                    80,
                    20
                ) { x: Int, y: Int -> x - y }
            }"
        )
        println("La potencia de 2 elevado a 5 con lambda es ${
            calculadora(
                2, 5
            ) { x, y ->
                var valor = 1
                for (i in 1..y) valor *= x

                valor
            }
        }")

        val res1 =  valueTry(10,2)
        println(res1)
        val res2 =  valueTry(10,0)
        println(res2)

        val password ="1234"
        @Throws(IllegalPasswordException::class)
        if (password.length<6) {
            //throw IllegalPasswordException("Password muy corta!!")
        }
        else println("Password segura :)")

        var array4 = IntArray(10) { 5 }
        println("array 4: ${array4.show()}")
        var array5 = IntArray(10) { it }
        println("array 5: ${array5.show()}")
        var array6 = IntArray(10) { it * 2 }
        println("array 6: ${array6.show()}")
        var array7 = IntArray(10) { i -> i * 3 }
        println("array 7: ${array7.show()}")

        var suma = 0
        recorrerArray(array7) {
            suma += it
        }
        println("La suma de todos los elementos del array7 es $suma")

        var ramirez: Person = Person("Ramirez", "A256CSA", 0f)
        var anonimo: Person = Person("Ramirez", "A256CSA", 0f)
        println(ramirez.alive)
        println(ramirez.name)
        println(ramirez.passport)

        ramirez.die()
        ramirez.height = 1.65f
        ramirez.passport = "DFS76FS7"

        ramirez.let {
            it.die()
            it.height = 1.65f
            it.passport = "DFS76FS7"
        }

        ramirez.apply {
            die()
            height = 1.70f
            passport = "43HG5378E"
        }

        var pais: String? = "Russia"
        pais = pais?.uppercase() ?: "DESCONOCIDO"
        println(pais)

        var ciudad: String? = null
        ciudad = ciudad?.uppercase() ?: "DESCONOCIDA"
        println(ciudad)

        var estado: String? = null
        ?: "DESCONOCIDO"
        println(estado)

        val calle: String by lazy { "Nueva" }

        var direccion = "$pais - $ciudad - $calle"
        println(direccion)

        anonimo.Person()
        anonimo.name = "Pablo"
        println(anonimo.alive)
        println(anonimo.name)
        println(anonimo.passport)

        ramirez.die()
        println(ramirez.alive)

        //var pele:Athlete = Athlete("Pele", "ASD23FDS", "Futbol")

        //println(pele.alive)
        //println(pele.name)
        //println(pele.passport)
        //println(pele.sport)

        var anidada = aliasObjeto()
        println(anidada.presentar())

        var saludos: aliasDato = mutableMapOf()
        saludos[0] = arrayListOf("Hola", "Adios")
        saludos[1] = arrayListOf("Hi", "Bye")

        for ((id, palabras) in saludos) {
            println("$id, $palabras")
        }

        var bicho: Pokemon = Pokemon()
        println(bicho.getName())
        println(bicho.getAttackPower())
        bicho.setLife(50f)
        println(bicho.getLife())


        println(fernanda.saludo())
        fernanda.apodo = "SuperFer"
        println(fernanda.saludo())

        var sol = star("Sol", 696340f, "Via Lactea")
        println(sol)

        var (name_star2, radius_star2, galaxy2) = star("Sol2", 696340f, "Via Lactea2")
        println("Datos de la star 2 desestructurada: $name_star2, $radius_star2, $galaxy2")

        var (name_star3, radius_star3) = star("Sol3", 696340f, "Via Lactea3")
        println("Datos de la star 3 desestructurada: $name_star3, $radius_star3")

        var (name_star4, _, galaxy4) = star("Sol4", 696340f, "Via Lactea4")
        println("Datos de la star 4 desestructurada: $name_star4, $galaxy4")

        var componente = star("Sol5", 696340f, "Via Lactea5")
        println("Datos de star 5 con componentes: ${componente.component1()}, ${componente.component2()}, ${componente.component3()}")

        var betelgeuse: star = star("Betelgeuse", 617100000f, "Orion")
        betelgeuse.alive = false
        println(betelgeuse.alive)

        var nueva = star()
        println(nueva)

        var hoy: dias = dias.LUNES
        var semana = dias.values()

        for (i in semana) {
            println(i)
        }

        println(dias.valueOf("MIERCOLES"))
        println(hoy.name)
        println(hoy.ordinal)

        println(hoy.saludo())
        println(hoy.laboral)
        println(hoy.jornada)
    }

    object fernanda {
        var apodo = "fer"
        fun saludo() {
            println("Hola me llaman $apodo")
        }
    }

    class IllegalPasswordException(message: String): Exception(message)

    private fun valueTry(a: Int, b: Int): Any{
        var res =
            try {
                println("Division $a/$b")

                a/b
            } catch(e: Exception) {
                println("ERROR EN DIVISION")

                "Division no permitida"
            } finally {
                println("Pase lo que pase se ejecuta esta linea :P")
            }
        return res
    }

    private fun String.noSpace(): String {
        return this.replace(" ", "")
    }

    private fun IntArray.show() {
        print("[")
        for (i in this) print("$i ")
        println("]")
    }

    private fun Person.checkPolice(fn: (Float) -> Boolean): Boolean {
        return fn(height)
    }

    private fun calculadora(n1: Int, n2: Int, fn: (Int, Int) -> Int): Int {
        return fn(n1, n2)
    }

    private fun suma(x: Int, y: Int) = x + y
    private fun resta(x: Int, y: Int) = x - y
    private fun multiplicacion(x: Int, y: Int) = x * y
    private fun division(x: Int, y: Int) = x / y

    private fun inColombia(h: Float): Boolean {
        return h >= 1.6f
    }

    private fun inSpain(h: Float): Boolean {
        return h >= 1.65f
    }

    private fun recorrerArray(array: IntArray, fn: (Int) -> Unit) {
        for (i in array) {
            fn(i)
        }
    }
}