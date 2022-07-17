package com.app.myapplication.screens.pokemonpage

import com.app.myapplication.screens.pokemonpage.ui.PokemonPageFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun getPokemonPageScreen(nameOfPokemon:String) = FragmentScreen { PokemonPageFragment.newInstance(nameOfPokemon) }