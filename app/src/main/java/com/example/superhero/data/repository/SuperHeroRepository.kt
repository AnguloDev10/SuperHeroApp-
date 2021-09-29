package com.example.superhero.data.repository

import com.example.superhero.data.model.SuperHero
import com.example.superhero.data.remote.SuperHeroService
import javax.inject.Inject

class SuperHeroRepository @Inject constructor(
    private val superHeroService: SuperHeroService
){
    suspend fun fetchSuperheros(): List<SuperHero>{
        val response = superHeroService.fetchSuperheroes()
        if (response.isSuccessful && response.body() != null){
            return response.body()!!.results
        }
        return listOf()
    }
}