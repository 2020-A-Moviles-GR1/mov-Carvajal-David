package com.carvajaldavid.restaurante.dao

import androidx.room.*

import com.carvajaldavid.restaurante.Ingredientes

@Dao
interface IngredientesDao {
    @Insert
    fun insert(vararg ingredientes: Array<Ingredientes?>)


    @Update
    fun update(vararg ingredientes: Ingredientes?)


    @Delete
    fun delete(vararg ingredientes: Ingredientes?)

    @Query("Select * FROM ingredientes")
    fun loadAllUsers(): Array<Ingredientes>
}