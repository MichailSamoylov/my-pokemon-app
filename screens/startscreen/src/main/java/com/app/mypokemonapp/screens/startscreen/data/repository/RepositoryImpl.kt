package com.app.mypokemonapp.screens.startscreen.data.repository

import com.app.mypokemonapp.screens.startscreen.data.datasource.DataSource
import com.app.mypokemonapp.screens.startscreen.data.mapper.toEntity
import com.app.mypokemonapp.screens.startscreen.domain.entity.Entity
import com.app.mypokemonapp.screens.startscreen.domain.repository.Repository

class RepositoryImpl(private val dataSource: DataSource) : Repository {

	override suspend fun getListOfPokemon(cod:Int): Entity =
		dataSource.get(cod).toEntity()
}