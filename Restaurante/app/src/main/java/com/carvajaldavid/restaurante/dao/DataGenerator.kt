package com.carvajaldavid.restaurante.dao

import com.carvajaldavid.restaurante.Ingredientes


class DataGenerator {

    fun generateIngredientes(): Array<Ingredientes?> {

        val ingredientes: Array<Ingredientes?> = arrayOfNulls<Ingredientes>(4)
        ingredientes[0] = ingredientesInstance(1, "Carne", 2,1,true)
        ingredientes[1] = ingredientesInstance(2, "Mantequilla", 3,2,false)
        ingredientes[2] = ingredientesInstance(3, "Tomate", 5,3,true)
        ingredientes[3] = ingredientesInstance(4, "Aceite", 7,2,true)

        return ingredientes

    }

    private fun ingredientesInstance(id: Int, nombre: String, peso: Int,cantidad: Int, existencia: Boolean): Ingredientes {

        return Ingredientes(
            id,
            nombre,
            peso,
            cantidad,
            existencia
        )
    }



}