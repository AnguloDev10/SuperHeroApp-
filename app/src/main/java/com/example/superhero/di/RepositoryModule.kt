package com.example.superhero.di

import com.example.superhero.data.remote.SuperHeroService
import com.example.superhero.data.repository.SuperHeroRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMealRepository(
     heroService: SuperHeroService
    ): SuperHeroRepository {
        return SuperHeroRepository(heroService)
    }
}