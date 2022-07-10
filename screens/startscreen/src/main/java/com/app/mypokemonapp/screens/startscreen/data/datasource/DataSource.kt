package com.app.mypokemonapp.screens.startscreen.data.datasource

import com.app.mypokemonapp.screens.startscreen.data.model.Model

interface DataSource {

	suspend fun get(cod:Int):Model
}