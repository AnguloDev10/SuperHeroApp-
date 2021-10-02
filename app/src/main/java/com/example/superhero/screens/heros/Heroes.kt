package com.example.superhero.screens.heros

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

import com.example.superhero.data.model.SuperHero
import org.intellij.lang.annotations.JdkConstants

@Composable
fun Heroes(
    heroesViewModel: HeroesViewModel,
    selectHero: (name : String) -> Unit,

){
    val superheroes: List<SuperHero> by heroesViewModel.heroes.observeAsState(listOf())
    HeroesList(heroes = superheroes, selectHero = selectHero)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeroesList(heroes: List<SuperHero>, selectHero: (id: String) -> Unit){
    LazyVerticalGrid(cells = GridCells.Fixed(2)){
       items(heroes){
           hero->
           SuperheRow(hero = hero, selectHero = selectHero)
       }
    }

}
@Composable
fun SuperheRow(hero: SuperHero, selectHero: (name: String) -> Unit){
    Card(
        modifier = Modifier
            .padding(4.dp),
        elevation = 2.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {

                }) {
               SuperHeroImage(hero = hero)
              Text(hero.name)
        }

    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SuperHeroImage(hero: SuperHero){
    Image(
        painter = rememberImagePainter(hero.image.url),
        contentDescription = null,
        modifier = Modifier.size(128.dp)
    )
}