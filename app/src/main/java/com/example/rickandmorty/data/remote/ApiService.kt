package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.model.CharacterList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://rickandmortyapi.com/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CharacterApiService {
    @GET("character?")
    suspend fun getCharacter(@Query("limit")amount: Int): CharacterList
}

object CharacterApi {
    val retrofitService: CharacterApiService by lazy {
        retrofit.create(CharacterApiService::class.java)
    }
}