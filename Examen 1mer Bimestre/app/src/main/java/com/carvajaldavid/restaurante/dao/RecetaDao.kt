package com.carvajaldavid.restaurante.dao

import androidx.lifecycle.LiveData
import androidx.room.*

import com.carvajaldavid.restaurante.Ingredientes
import com.carvajaldavid.restaurante.Receta

@Dao
interface RecetaDao {
    @Query("SELECT * from recetas_table ORDER BY id ASC")
    fun getRecetas(): LiveData<List<Receta>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(receta: Receta)

    @Query("DELETE FROM recetas_table")
    suspend fun deleteAll()
}