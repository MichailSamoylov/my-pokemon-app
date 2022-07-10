package com.app.mypokemonapp.screens.startscreen.presentation

import com.app.mypokemonapp.screens.startscreen.domain.entity.Entity

sealed class StartScreenState {

	object Initial : StartScreenState()

	object Loading : StartScreenState()

	data class Content(
		val listOfPokemon: List<Entity>
	) : StartScreenState()

	object Error : StartScreenState()

}