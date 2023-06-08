package com.example.poo_kotlin

import android.annotation.SuppressLint

open class Pokemon(
    protected var name: String = "Pok",
    protected var attackPower: Float = 30f,
    protected var life: Float = 100f
) : thanks(){

    @SuppressLint("NotConstructor")
    fun Pokemon(name: String, attackPower: Float) {
        this.name = name
        this.attackPower = attackPower
        this.life = 100f
        println("Hola!! Soy ${this.name}")
    }

    internal fun getName(): String {
        return name
    }

    internal fun getAttackPower(): Float {
        return attackPower
    }

    internal fun getLife(): Float {
        return life
    }

    internal fun setLife(life: Float) {
        this.life = life
    }

    fun cure() {
        this.life = 100f
        this.thanksCure()
    }

    fun evolve(name: String) {
        this.name = name
        this.attackPower *= 1.20f
        println("Hola!! Soy ${this.name}")
    }

    open fun attack() {
        println("Al ataqueeeee!!")
    }
}

class WaterPokemon(n: String = "Pok", aP: Float = 30f, l: Float = 100f) : Pokemon(n, aP, l) {
    private var maxResistance: Int = 500
    private var submergedTime: Int = 0

    @SuppressLint("NotConstructor")
    fun WaterPokemon(n: String, aP: Float, mR: Int) {
        this.name = n
        this.attackPower = aP
        this.life = 100f
        this.maxResistance = mR
        println("Hola!! Soy ${this.name}")
    }

    fun breathe() {
        this.submergedTime = 0
    }

    fun inmerse() {
        this.submergedTime++
    }

    override fun attack() {
        println("Ataque con chorro")
    }
}

class FirePokemon(n:String = "Pok", aP: Float = 30f, l:Float = 100f) : Pokemon(n, aP, l) {
    private var ballTemperature: Int = 90
    lateinit var ballFire: BallFire
    var numBall: Int = 0
    @SuppressLint("NotConstructor")
    fun FirePokemon(n: String, aP: Float, bT: Int) {
        this.name = n
        this.attackPower = aP
        this.life = 100f
        this.ballTemperature = bT
    }

    override fun attack() {
        super.attack()
        println("Ataque con fuego!!")
        println("Bola ${++numBall}")
        ballFire = BallFire(ballTemperature)
        ballFire.throwBall()
    }
}

class BallFire(private var temp:Int = 100) {
    fun throwBall() {
        println("Tirando bola con temperatura $temp")
    }
}

class EarthPokemon(n:String = "Pok", aP: Float = 30f, l:Float = 100f) : Pokemon(n, aP, l), sayBay, sayBay2, sayBay3 {
    private var depth: Int = 150
    override var dato: Int
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun sayBye() {
        TODO("Not yet implemented")
    }

    fun EarthPokemon (n: String, aP: Float, d: Int) {
        this.name = n
        this.attackPower = aP
        this.life = 100f
        this.depth = d
    }
}

abstract class thanks() {
    fun thanksCure() {
        println("Gracias por curarme!")
    }
}

interface sayBay{
    var dato: Int

    fun sayBye() {
        println("ByeBye!")
    }
}

interface sayBay2{
    fun sayBye() {
        println("ByeBye!")
    }
}

interface sayBay3{
    fun sayBye() {
        println("ByeBye!")
    }
}

