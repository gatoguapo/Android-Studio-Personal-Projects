package com.example.poo_kotlin

enum class dias(val laboral: Boolean, val jornada: Int) {
    LUNES(true, 8), MARTES(true, 8), MIERCOLES(true, 5),
    JUEVES(true, 8), VIERNES(true, 4), SABADO(false, 0), DOMINGO(false, 0);

    fun saludo(): String {
        when (this) {
            LUNES -> return "empezando con alegria!!"
            MARTES -> return "ya queda menos!!"
            MIERCOLES -> return "sabias que los miercoles son los dias mas productivos?"
            JUEVES -> return "esta noche es juernes!!"
            VIERNES -> return "hoy es viernes y tu body lo sabe baby"
            else -> return "a quemar lo del findeeee!!"
        }
    }

}