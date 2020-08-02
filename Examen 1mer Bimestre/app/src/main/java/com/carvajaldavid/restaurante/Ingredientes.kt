package com.carvajaldavid.restaurante

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ingredientes(
    @PrimaryKey var id: Int,
    var nombre: String?,
    var peso: Int?,
    var cantidad: Int?,
    var existencia: Boolean? = null
)