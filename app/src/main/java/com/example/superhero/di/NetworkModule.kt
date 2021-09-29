package com.example.superhero.di

import com.example.superhero.data.remote.SuperHeroService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val API_BASE_URL = "https://www.superheroapi.com/api.php/10157703717092094/search/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Provides
    @Singleton
    fun provideSuperHeroService(retrofit: Retrofit): SuperHeroService{
        return retrofit.create(SuperHeroService::class.java)

    }
}