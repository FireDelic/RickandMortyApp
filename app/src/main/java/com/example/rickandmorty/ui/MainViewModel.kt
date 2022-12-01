package com.example.rickandmorty.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.Repository
import com.example.rickandmorty.data.remote.CharacterApi
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){

    private val repository: Repository = Repository(CharacterApi)
    private val database: Repository = repository

    val characterList = repository.character
    val favouritsList = repository

    fun loadCharacter(){
        viewModelScope.launch {
            repository.getCharacter()
        }
    }

    fun saveCharacter(){
        viewModelScope.launch {
           favouritsList.contains(database)
        }
    }


}