package com.example.rickandmorty.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.Repository
import com.example.rickandmorty.data.remote.CharacterApi
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){
    private val repository: Repository = Repository(CharacterApi)
    var character = repository.character

    fun  loadCharacter(amount: Int){
        viewModelScope.launch {
            repository.getCharacter(amount)
        }
    }

}