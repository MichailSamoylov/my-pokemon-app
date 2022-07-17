package com.app.myapplication.screens.pokemonpage.data.mapper

import com.app.myapplication.screens.pokemonpage.data.model.PokemonPageModel
import com.app.myapplication.screens.pokemonpage.domain.entity.PokemonPageEntity
import com.app.myapplication.screens.pokemonpage.domain.entity.Sprites

fun PokemonPageModel.toEntity() =
	PokemonPageEntity(
		name = name,
		type = this.types.last().type.name,
		weight= weight,
		height = height,
		sprites = Sprites(sprites.front_default)
	)