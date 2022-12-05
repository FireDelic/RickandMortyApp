package com.example.rickandmorty.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [com.example.rickandmorty.data.model.Character::class], version = 1)
abstract class CharacterDatabase: RoomDatabase() {

    abstract val characterDatabaseDao: CharacterDatabaseDao
}

private  lateinit var INSTANCE: CharacterDatabase

fun getDatabase(context: Context): CharacterDatabase {
    synchronized(CharacterDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                CharacterDatabase::class.java,
                "Favourite Characters"
            )
                .build()
        }
        return INSTANCE
    }
}

