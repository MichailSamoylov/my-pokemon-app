package com.app.mypokemonapp.screens.startscreen.data.api

import com.app.mypokemonapp.screens.startscreen.data.model.Model
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

	@GET("pokemon/{cod}")
	suspend fun getPokemonList(@Path("cod") cod:Int): Model
}