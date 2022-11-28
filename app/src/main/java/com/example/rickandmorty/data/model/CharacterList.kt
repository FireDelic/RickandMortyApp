package com.example.rickandmorty.data.model

import com.squareup.moshi.Json

data class CharacterList(
    @Json(name= "results")
    val charList: List<Character>
)
