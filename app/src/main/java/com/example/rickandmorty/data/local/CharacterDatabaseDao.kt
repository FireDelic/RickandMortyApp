package com.example.rickandmorty.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CharacterDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character:com.example.rickandmorty.data.model.Character)

    @Query("SELECT * FROM Character ")
    fun getAll(): LiveData<List<com.example.rickandmorty.data.model.Character>>

    @Query("DELETE FROM Character WHERE id = :id")
    suspend fun deleteById(id: Int)


}