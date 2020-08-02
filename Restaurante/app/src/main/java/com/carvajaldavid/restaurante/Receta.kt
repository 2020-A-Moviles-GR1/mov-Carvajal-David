package com.carvajaldavid.restaurante
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recetas_table")
data class Receta(
    @PrimaryKey var id: Int,
    var numeroIngredientes: Int?,
    var nombre: String?,
    var fechaRealiza: String?,
    var tiempo: Int?,
    @Embedded val Ingredientes: Array<Ingredientes?>

)