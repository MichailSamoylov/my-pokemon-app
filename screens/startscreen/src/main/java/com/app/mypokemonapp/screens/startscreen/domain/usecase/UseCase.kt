package com.app.mypokemonapp.screens.startscreen.domain.usecase

import com.app.mypokemonapp.screens.startscreen.domain.entity.Entity
import com.app.mypokemonapp.screens.startscreen.domain.repository.Repository

class UseCase(private val repository: Repository) {

	suspend operator fun invoke(cod:Int): Entity =
		repository.getListOfPokemon(cod)
}