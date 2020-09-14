package com.example.miprimeraapp_mov

import java.util.*

class PokemonHttp (
    var createdAt: Long,
    var updatedAt: Long,
    var id:Int,
    var nombre: String,
    var usuario: Integer
){
     var fechaCreacion : Date
    var fechaActualizacion: Date

    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }

}