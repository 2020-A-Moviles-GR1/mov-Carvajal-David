package com.example.miprimeraapp_mov

class RestauranteEntrenador(
    var nombre:String,      //nombre
    var Apellido: String    //valor plato
    //var valorPlato: Boolean
){
    override fun toString():String{
        return "${nombre} ${this.Apellido}"
    }

}