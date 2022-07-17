package com.app.mypokemonapp.navigation.screenrouters

import com.app.myapplication.screens.pokemonpage.presentation.PokemonPageRouter
import com.github.terrakok.cicerone.Router

class PokemonPageRouterImpl(private val router: Router): PokemonPageRouter {

	override fun navigateBack() {
		router.exit()
	}
}