package com.example.rickandmorty.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.Repository
import com.example.rickandmorty.data.local.getDatabase
import com.example.rickandmorty.data.remote.CharacterApi
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application){

    private val database = getDatabase(application)
    private val repository: Repository = Repository(CharacterApi, database)


    val characterList = repository.character
    val favouritsList = repository.character

    fun loadCharacter() {
        viewModelScope.launch {
            repository.getCharacter()
        }
    }

    fun saveCharacter(character: com.example.rickandmorty.data.model.Character){
        viewModelScope.launch {
            repository.saveCharacter(character)
        }
    }


}
