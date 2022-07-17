package com.app.myapplication.screens.pokemonpage.domain.usecase

import com.app.myapplication.screens.pokemonpage.domain.entity.PokemonPageEntity
import com.app.myapplication.screens.pokemonpage.domain.repository.PokemonPageRepository

class PokemonPageUseCase(private val repository: PokemonPageRepository) {

	suspend operator fun invoke(nameOfPokemon:String): PokemonPageEntity =
		repository.getPokemonParameter(nameOfPokemon)
}