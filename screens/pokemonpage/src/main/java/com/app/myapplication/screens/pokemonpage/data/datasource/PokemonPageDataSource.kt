package com.app.myapplication.screens.pokemonpage.data.datasource

import com.app.myapplication.screens.pokemonpage.data.model.PokemonPageModel

interface PokemonPageDataSource {

	suspend fun get(nameOfPokemon:String):PokemonPageModel
}