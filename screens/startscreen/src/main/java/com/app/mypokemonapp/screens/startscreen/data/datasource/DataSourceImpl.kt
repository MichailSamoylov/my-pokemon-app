package com.app.mypokemonapp.screens.startscreen.data.datasource

import com.app.mypokemonapp.screens.startscreen.data.api.Api
import com.app.mypokemonapp.screens.startscreen.data.model.Model

class DataSourceImpl(private val api:Api): DataSource {

	override suspend fun get(cod:Int): Model =
		api.getPokemonList(cod)
}