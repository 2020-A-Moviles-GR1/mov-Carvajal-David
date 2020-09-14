package com.example.miprimeraapp_mov

import java.util.*
import kotlin.collections.ArrayList

class UsuarioHttp(
    var id: Int,
    var createdAt: Long,
    var updatedAt:Long,
    var cedula: String,
    var nombre: String,
    var correo: String,
    var estadoCivil: String,
    var password: String,
    var pokemos: ArrayList<PokemonHttp>
){
    var fechaCreacion: Date
    var fechaActualizacion: Date

    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }


}