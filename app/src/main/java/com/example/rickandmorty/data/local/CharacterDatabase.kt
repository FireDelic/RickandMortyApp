package com.example.rickandmorty.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmorty.data.model.Character
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Character::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {

    abstract val characterDatabaseDao: CharacterDatabaseDao
}

private  lateinit var INSTANCE: CharacterDatabase

@OptIn(InternalCoroutinesApi::class)
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

