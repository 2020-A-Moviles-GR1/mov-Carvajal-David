package com.example.examenrestaurante


public class Platos(
    var NombrePlato:String,
    var valor:Float
){
    override fun toString(): String {
        return "Platos(Nombre='$NombrePlato', Valor=$valor.)"
    }
}

