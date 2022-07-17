package com.app.myapplication.screens.pokemonpage.presentation

import com.app.myapplication.screens.pokemonpage.domain.entity.PokemonPageEntity

sealed class PokemonPageState{
	object Initial:PokemonPageState()

	object Loading:PokemonPageState()

	data class Content(
		val entity:PokemonPageEntity
	):PokemonPageState()

	object Error:PokemonPageState()
}
