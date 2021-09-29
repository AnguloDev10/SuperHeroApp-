package com.example.superhero.screens.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.superhero.Routes
import com.example.superhero.screens.heros.Heroes
import com.example.superhero.screens.heros.HeroesViewModel

@Composable
fun Main() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Heroes.route){
        composable(Routes.Heroes.route) {
            val superHeroesViewModel : HeroesViewModel = hiltViewModel()
            superHeroesViewModel.fetchSuperHeroes()
            Heroes(superHeroesViewModel){

            }
            //TODO-APP: screen detail

        }

    }

}