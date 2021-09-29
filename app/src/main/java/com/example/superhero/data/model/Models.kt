package com.example.superhero.data.model

import com.google.gson.annotations.SerializedName

data class SuperHero (
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: Image
)

data class Image (
    @SerializedName("url")
    val url: String
)

data class Powerstats (
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

