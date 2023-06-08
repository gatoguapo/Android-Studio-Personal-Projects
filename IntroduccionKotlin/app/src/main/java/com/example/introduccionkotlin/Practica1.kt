package com.example.introduccionkotlin

import java.util.Scanner

class Practica1 constructor(){
    var sc = Scanner(System.`in`)
    var equipos = arrayOfNulls<String>(2)
    var jugadores1 = arrayOfNulls<String>(11)
    var jugadores2 = arrayOfNulls<String>(11)
    var edades1 = arrayOfNulls<Int>(11)
    var edades2 = arrayOfNulls<Int>(11)

    fun CapturaDatos() {
        println("----------------------------------------------------------------------------")
        println(" *** Este programa captura el nombre de los jugadores de tus equipos *** ")
        println(" Introduzca el nombre del equipo 1 ")
        equipos[1] = sc.nextLine()
        println(" Introduzca el nombre del equipo 2 ")
        equipos[2] = sc.nextLine()
        println(" *** Introduza los jugadores del equipo ${equipos[1]} *** ")
        for (i in 0 until jugadores1.size) {
            println("Jugador "+(i+1)+":")
            jugadores1[i] = sc.nextLine()
        }
        println(" *** Introduza los jugadores del equipo ${equipos[2]} *** ")
        for (i in 0 until jugadores2.size) {
            println("Jugador "+(i+1) +":")
            jugadores2[i] = sc.nextLine()
        }
        println(" *** Introduza las edad de los jugadores del equipo ${equipos[1]} *** ")
        for (i in 0 until edades1.size) {
            println("Jugador "+(i+1)+" edad:")
            edades1[i] = sc.nextInt()
        }
        println(" *** Introduza las edad de los jugadores del equipo ${equipos[2]} *** ")
        for (i in 0 until edades2.size) {
            println("Jugador "+(i+1)+" edad:")
            edades2[i] = sc.nextInt()
        }
        println("----------------------------------------------------------------------------")
        println(" ")
    }

    fun MuestraDatos() {
        println(" El equipo 1 es "+equipos[1])
        println(" Y sus datos son los siguientes ")
        for (i in 0 until jugadores1.size) {
            println("Nombre del jugador "+(i+1)+": "+jugadores1[i])
            println("Edad del jugador "+(i+1)+": "+edades1[i])
        }
        println(" ")
        println(" El equipo 2 es "+equipos[2])
        println(" Y sus datos son los siguientes ")
        for (i in 0 until jugadores2.size) {
            println("Nombre del jugador "+(i+1)+": "+jugadores2[i])
            println("Edad del jugador "+(i+1)+": "+edades2[i])
        }
    }

}