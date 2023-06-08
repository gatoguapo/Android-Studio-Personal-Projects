package com.example.poo_kotlin

import android.annotation.SuppressLint

open class Person (var name: String = "Anonimo", var passport: String? = null, var height: Float) : thanks(){

    var alive: Boolean = true

    @SuppressLint("NotConstructor")
    fun Person() {
        name = "Juan"
        passport = "B8WA821"
    }

    fun die() {
        alive = false
    }

    fun checkPolice(fn: (Float)->Boolean): Boolean {
        return fn(height)
    }
}

class Athlete (name: String, passport: String?, var sport: String, height: Float): Person(name, passport, height){

}