package com.app.myapplication.screens.pokemonpage.data.datasource

import com.app.myapplication.screens.pokemonpage.data.api.PokemonPageApi
import com.app.myapplication.screens.pokemonpage.data.model.PokemonPageModel

class PokemonPageDataSourceImpl(private val api:PokemonPageApi):PokemonPageDataSource {

	override suspend fun get(nameOfPokemon:String): PokemonPageModel =
		api.get(nameOfPokemon)
}