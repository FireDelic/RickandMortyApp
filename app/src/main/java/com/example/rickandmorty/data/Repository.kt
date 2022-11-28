package com.example.rickandmorty.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.model.Character
import com.example.rickandmorty.data.remote.CharacterApi

class Repository(private val api: CharacterApi) {

    private val _character = MutableLiveData<List<Character>>()
    val character: LiveData<List<Character>>
        get() = _character

    suspend fun getCharacter(){
        try {
            val result = api.retrofitService.getCharacter()
            _character.value = result.charList
        } catch (e: Exception){
            Log.e(TAG, "Error loading Character from API: $e")
        }
    }
}