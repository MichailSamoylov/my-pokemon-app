package com.app.mypokemonapp.screens.startscreen.data.model

import com.google.gson.annotations.SerializedName

data class Model (
	@SerializedName("name")
	val name: String,
	@SerializedName("sprites")
	val sprites: SpritesModel
)

data class SpritesModel(
	@SerializedName("front_default")
	val front_default: String
)