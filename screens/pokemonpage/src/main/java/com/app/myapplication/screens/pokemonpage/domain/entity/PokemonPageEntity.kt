package com.app.myapplication.screens.pokemonpage.domain.entity

data class PokemonPageEntity(
	val name: String,
	val type: String,
	val weight: String,
	val height: String,
	val sprites: Sprites
)

data class Sprites(
	val front_default: String
)
