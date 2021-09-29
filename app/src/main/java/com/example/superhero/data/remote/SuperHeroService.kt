package com.example.superhero.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface  SuperHeroService {
    @GET("batman")
    suspend fun fetchSuperheroes(): Response<SuperHeroResponse>
}