package com.app.myapplication.screens.pokemonpage.domain.repository

import com.app.myapplication.screens.pokemonpage.domain.entity.PokemonPageEntity

interface PokemonPageRepository {

	suspend fun getPokemonParameter(nameOfPokemon:String):PokemonPageEntity
}