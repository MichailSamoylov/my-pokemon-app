package com.app.myapplication.screens.pokemonpage.data.api

import com.app.myapplication.screens.pokemonpage.data.model.PokemonPageModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonPageApi {

	@GET("pokemon/{name}")
	suspend fun get(@Path("name") name: String): PokemonPageModel
}