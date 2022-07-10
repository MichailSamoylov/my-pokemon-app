package com.app.mypokemonapp.screens.startscreen.domain.repository

import com.app.mypokemonapp.screens.startscreen.domain.entity.Entity

interface Repository {

	suspend fun getListOfPokemon(cod:Int):Entity
}