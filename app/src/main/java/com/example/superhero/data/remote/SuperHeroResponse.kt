package com.example.superhero.data.remote

import com.example.superhero.data.model.SuperHero
import com.google.gson.annotations.SerializedName

data class SuperHeroResponse (

    @SerializedName("results")
    val results: List<SuperHero>

        )