package com.carvajaldavid.restaurante

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

class DataCompanion {
    companion object {

        val urlPrincipal = "192.168.100.246:1337 "
        var list_receta = arrayListOf<Receta>()
        var list_ingredientes = arrayListOf<Ingredientes>()

        fun obtenerReceta() {
            //var list = arrayListOf<String>()
            val url = urlPrincipal + "/receta"
            url.httpGet().responseString { request, response, result ->
                when (result) {
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http-get", "Datos: ${data}")
                        val receta = Klaxon().parseArray<RecetaHttp>(data)
                        if (receta != null) {
                            list_receta.clear()
                            receta.forEach {
                                Log.i("http-get", "Datos: ${it.nombre}")
                                val thing =
                                    it.nombre
                                //arreglotest.add(thing)
                                //list_ingredientes.add(thing)
                                //Log.i("http-get", "TEST ${list_ciudadesHt}")
                            }
                        }
                    }
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http-get", "Error: ${ex.message}")
                    }
                }

            }
            //Log.i("http-get", "Est mierda: ${list}")
            //return list
        }








            var ingredientes: Array<Ingredientes?> = arrayOfNulls<Ingredientes>(5)
            var receta: Array<Receta?> = arrayOfNulls<Receta>(5)


            fun leerIngredientes(): Array<Ingredientes?> {
                return ingredientes
            }
            fun leerRecetas(): Array<Receta?> {
                return receta
            }
            fun eliminarDatos(){
                ingredientes = emptyArray()
                receta = emptyArray()


            }
            fun generarIngredientes(): Array<Ingredientes?> {

                ingredientes[0] = ingredientesInstance(1, "Carne", 2,1,true)
                ingredientes[1] = ingredientesInstance(2, "Mantequilla", 3,2,false)
                ingredientes[2] = ingredientesInstance(3, "Tomate", 5,3,true)
                ingredientes[3] = ingredientesInstance(4, "Aceite", 7,2,true)
                ingredientes[4] = ingredientesInstance(5, "Aceite de oliva", 7,2,true)

                return ingredientes
            }
            fun actualizarIngredientes(): Array<Ingredientes?> {

                ingredientes[4] = ingredientesInstance(5, "Aceite de oliva virge", 7,2,true)

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
            fun generarReceta(): Array<Receta?> {

                receta[0] = recetaInstante(1, 5, "Carne Molida","HOY",1)
                receta[1] = recetaInstante(2, 5, "Carne al jugo","HOY",1)
                receta[2] = recetaInstante(3, 5, "Carne salteada","HOY",1)
                receta[3] = recetaInstante(4, 5, "Camaron","HOY",1)
                receta[4] = recetaInstante(5, 5, "Tallarin con queso","HOY",1)

                return receta
            }
            fun actualizarReceta(id:Int,nombre:String): Array<Receta?> {

                receta[id-1] = recetaInstante(id, 5, nombre,"HOY",1)

                return receta
            }
            private fun recetaInstante(id: Int, numeroIngredientes: Int, nombre: String,fechaRealiza: String, tiempo: Int): Receta {

                return Receta(
                    id,
                    numeroIngredientes,
                    nombre,
                    fechaRealiza,
                    tiempo,
                    generarIngredientes()
                )
            }
    }
}

