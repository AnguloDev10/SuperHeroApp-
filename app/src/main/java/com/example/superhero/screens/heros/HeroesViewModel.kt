package com.example.superhero.screens.heros

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superhero.data.model.SuperHero
import com.example.superhero.data.repository.SuperHeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HeroesViewModel  @Inject constructor(private  val heroRepository: SuperHeroRepository):
        ViewModel(){
            private var _heroes = MutableLiveData<List<SuperHero>>()
            val heroes get() = _heroes

            fun fetchSuperHeroes(){
                viewModelScope.launch {
                    _heroes.postValue(heroRepository.fetchSuperheros())
                }
            }
        }