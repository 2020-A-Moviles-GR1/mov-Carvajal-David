package com.example.miprimeraapp_mov

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



}