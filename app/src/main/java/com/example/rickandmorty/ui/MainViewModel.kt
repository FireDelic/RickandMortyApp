package com.example.rickandmorty.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.Repository
import com.example.rickandmorty.data.local.getDatabase
import com.example.rickandmorty.data.remote.CharacterApi
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application){

    //Initialisieren der ROOM Datenbank als auch der API
    private val database = getDatabase(application)
    private val repository: Repository = Repository(CharacterApi, database)

    // LIVE Daten der jeweiligen Liste die recycelt wird
    val characterList = repository.character
    val favouritsList = repository.favs

    //Methode um die aktuellen Charactere zu laden
    fun loadCharacter() {
        viewModelScope.launch {
            repository.getCharacter()
        }
    }

   //Methode um die einen Character in meiner Favoritenliste zu speichern
    fun saveCharacter(character: com.example.rickandmorty.data.model.Character){
        viewModelScope.launch {
            repository.saveCharacter(character)
        }
    }

   //Diese Methode löscht den Favoriten wieder aus der Favoritenliste
    fun deleteFav(id: Int) {
        viewModelScope.launch {
            repository.deleteFav(id)
        }
    }


}
