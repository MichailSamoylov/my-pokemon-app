package com.app.mypokemonapp.screens.startscreen.data.mapper

import com.app.mypokemonapp.screens.startscreen.data.model.Model
import com.app.mypokemonapp.screens.startscreen.domain.entity.Entity
import com.app.mypokemonapp.screens.startscreen.domain.entity.Sprites

fun Model.toEntity():Entity =
	Entity(
		name = this.name,
		sprites = Sprites(this.sprites.front_default)
	)