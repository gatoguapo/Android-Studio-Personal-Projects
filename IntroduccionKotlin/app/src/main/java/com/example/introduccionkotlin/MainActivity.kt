package com.example.introduccionkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    companion object {
        const val moneda = "PESOS MEXICANOS"
        const val euro = "EURO"
    }

    var saldo: Float = 300.54f
    var sueldo: Float = 764.82f
    var entero: Int = 62
    var double = 125.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DatosPersona()
        //Practica()
        var obj1: Practica1
    }

    fun Practica() {

        val fecha = "01/05/1990"
        var nombre: String = "jota"
        var vip: Boolean = true
        var inicial: Char = 'J'

        var saludo = "Hola $nombre"

        if (vip == true) {
            saludo += ", te queremos mucho $nombre"
        } else saludo += ", quieres ser vip? paga la cuota"

        MostrarSaldo()

        var mes: Int = fecha.subSequence(3, 5).toString().toInt()
        var dia = fecha.subSequence(0, 2).toString().toInt()
        if (dia == 1) {
            IngresarSueldo()
        }
        when (mes) {
            1 -> println("\n En enero esta la super oferta del 7% de interes")
            2, 3 -> println("\n En invierno no hay ofertas de inversiones")
            4, 5, 6 -> println("\n En primavera hay ofertas de inversiones con el 1.5% de interes")
            7, 8, 9 -> println("\n En verano hay ofertas de inversiones con el 2.5% de interes")
            10, 11, 12 -> println("\n En otoño hay ofertas de inversiones con el 3.5% de interes")
            else -> println("La fecha es erronea")
        }

        println(saludo)

        MostrarSaldo()
        IngresarDinero(50.5f)
        RetirarDinero(40f)
        RetirarDinero(50f)
        RetirarDinero(2000f)

        var recibos: Array<String> = arrayOf("luz","agua","gas", " ")
        recibos.set(3, "internet")
        var matriz = arrayOf(
            intArrayOf(1,2,3),//(0,0),(0,1),(0,2)
            intArrayOf(4,5,6),//(1,0),(1,1),(1,2)
            intArrayOf(7,8,9,10,11,12,13) //(2,0),(2,1),(2,2),(2,3),(2,4),(2,5),(2,6)
        )

        for (i in (0 until matriz.size)){
            println()
            for (j in (0 until matriz[i].size)){
                println("Posicion[$i][$j] : ${matriz[i][j]}")
            }
        }

        recorrerArray(recibos)

        var clientesVip: Set<Int> = setOf(1234, 5678, 4040)
        val setMezclado = setOf(2, 4.454, "casa", 'c')

        println("Clientes VIP: \n")
        println(clientesVip)
        println("Numero de clientes VIP: ${clientesVip.size}")

        println(setMezclado)
        if (clientesVip.contains(1234)) println("1234 es VIP")
        if (clientesVip.contains(1235)) println("1235 es VIP")

        var clientes: MutableSet<Int> = mutableSetOf(1234, 5678, 4040, 8970)
        println("Clientes: \n")
        println(clientes)
        println("Numero de clientes VIP: ${clientes.size}")

        clientes.add(3026)
        println(clientes)

        clientes.remove(5678)
        println(clientes)

        clientes.clear()
        println(clientes)

        var divisas: List<String> = listOf("USD", "EUR", "YEN")
        println(divisas)

        var bolsa: MutableList<String> = mutableListOf("Coca-Cola","Adidas","Amazon", "Pfizer")
        println(bolsa)

        bolsa.add("Adobe")
        println(bolsa)

        bolsa.add("Nvidia")
        println(bolsa)

        bolsa.removeAt(2)
        println(bolsa)

        println(bolsa.first())
        println(bolsa.last())
        println(bolsa.elementAt(2))
        println(bolsa.none())

        recorrerListaMutable(bolsa)

        /*
        bolsa.clear()
        println(bolsa)
        println(bolsa.none())
        */

        var mapa: Map<Int, String> = mapOf(
            1 to "España",
            2 to "Mexico",
            3 to "Colombia"
        )

        println(mapa)

        var inversiones = mutableMapOf<String, Float>()
        inversiones.put("Coca-Cola",50f)
        println(inversiones)

        var empresa: String? = null

        MostrarSaldo()
        var cantidadInvertir = 90f
        var index = 0

        while(saldo >= cantidadInvertir) {
            empresa = bolsa.elementAtOrNull(index)
            if (empresa!=null) {
                saldo -= cantidadInvertir
                println("Se ha invertido $cantidadInvertir $moneda en $empresa")
                inversiones.put(empresa, cantidadInvertir)
            }
            else break
            index++
        }

        MostrarSaldo()
        /*
        var pin: Int = 1234
        var intentos: Int = 0
        var clave_ingresada: Int = 1234

        do {
            println("Ingresa el PIN: ")
            println("Clave ingresada: ${++clave_ingresada}")
            intentos++
            if (clave_ingresada==pin) break
        } while(intentos<3 && clave_ingresada != pin)

        if (intentos==3) println("Tarjeta bloqueada")
        */

        /* Operadores de calculo
        var a:Int = 5 + 5 // 10
        var b:Int = 10 - 2 // 8
        var c:Int = 3 * 4 // 12
        var d:Int = 10 / 5 // 2
        var e:Int = 10 % 3   // 1, no se puede dividir, se queda con el resto
        var f:Int = 10 % 6 // 1, division infinita, solo se mantiene la parte entera

        var aPreIncremento: Int = 5
        var bPreDecremento: Int = 5
        var cPostIncremento: Int = 5
        var dPostDecremento: Int = 5


        println(aPreIncremento)
        println(++aPreIncremento)
        println(aPreIncremento)

        println(bPreDecremento)
        println(--bPreDecremento)
        println(bPreDecremento)

        println(cPostIncremento)
        println(cPostIncremento++)
        println(cPostIncremento)

        println(dPostDecremento)
        println(dPostDecremento--)
        println(dPostDecremento)

        saldo += sueldo //saldo = saldo + sueldo

        saldo++

        */
        /*
        a == a
        a != b
        a > b
        a < b
        a >= b
        a <= b
        */
    }

    fun MostrarSaldo() {
        println("Tienes $saldo $moneda")
    }

    fun IngresarSueldo() {
        saldo += sueldo
        println("Se ha ingresado tu sueldo de $sueldo $moneda")
        MostrarSaldo()
    }

    fun IngresarDinero(cantidad: Float) {
        saldo += cantidad
        println("Se ha ingresado tu sueldo de $cantidad $moneda")
        MostrarSaldo()
    }

    fun RetirarDinero(cantidad: Float) {
        if (VerificarCantidad(cantidad)) {
            saldo -= cantidad
            println("Se ha hecho una retirada de $cantidad $moneda")
            MostrarSaldo()
        }
        else println("Cantidad superior al saldo imposible realizar la operacion")
    }

    private fun recorrerArray(array: Array<String>){

        for (i in array)
            println(i)

        for (i in array.indices)
            println(array.get(i))

        for (i in 0..array.size-1)
            println("${i+1}: ${array.get(i)}")
    }

    private fun recorrerListaMutable(list: MutableList<String>){

        for (i in list)
            println(i)

        for (i in list.indices)
            println(list.get(i))

        for (i in 0..list.size-1)
            println("${i+1}: ${list.get(i)}")
    }

    private fun VerificarCantidad(cantidad: Float): Boolean {
        return cantidad <= saldo
    }
    fun DatosPersona() {
        val pais: String
        pais = "MEXICO" //val es una constante, por lo que no se puede modificar.
        val nombres = arrayOf("Clemente", "Chikis", "Javi", "Ramirez", "Mokina", "Chaparro", "Gatoguapo")
        val saldo = arrayOf(5000, 500, 2500, 5, 5000, 0, 10000)
        val edades = arrayOf(56, 10000, 21, 20, 20, 20 ,21)

        println(" **************************************** DATOS PERSONAS **************************************** ")
        for (i in 0 until nombres.size) {
            println("El nombre de la persona es " + nombres[i] + ", vive en " + pais + " y tiene una edad de " + edades[i] + " años")
            println("Y cuenta con un saldo de ${saldo[i]} $moneda")
            if (saldo[i] >= 5000) {
                println(nombres[i] + " tiene 5000 pesos o más")
            }
            println(" ")
        }
        println("--------------------------------------------------------------------------------------------------------")
    }
}