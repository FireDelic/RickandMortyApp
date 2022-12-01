package com.example.rickandmorty.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Character(

    @PrimaryKey()
    @Json val id: Int,
    @Json val image: String,
    @Json val name: String,
    @Json val status: String,
    @Json val species: String
)
