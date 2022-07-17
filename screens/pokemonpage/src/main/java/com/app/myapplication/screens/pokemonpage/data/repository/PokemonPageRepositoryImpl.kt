package com.app.myapplication.screens.pokemonpage.data.repository

import com.app.myapplication.screens.pokemonpage.data.datasource.PokemonPageDataSource
import com.app.myapplication.screens.pokemonpage.data.mapper.toEntity
import com.app.myapplication.screens.pokemonpage.domain.entity.PokemonPageEntity
import com.app.myapplication.screens.pokemonpage.domain.repository.PokemonPageRepository

class PokemonPageRepositoryImpl(private val dataSource: PokemonPageDataSource):PokemonPageRepository {

	override suspend fun getPokemonParameter(nameOfPokemon:String): PokemonPageEntity =
		dataSource.get(nameOfPokemon).toEntity()
}