package com.example.rickandmorty.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.model.CharacterList
import com.example.rickandmorty.data.remote.CharacterApi

class Repository(private val api: CharacterApi) {

    private val _character = MutableLiveData<CharacterList>()
    val character: LiveData<CharacterList>
        get() = _character

    suspend fun getCharacter(amount: Int){
        try {
            val result = api.retrofitService.getCharacter(amount)
            _character.value = result
        } catch (e: Exception){
            Log.e(TAG, "Error loading Character from API: $e")
        }
    }
}