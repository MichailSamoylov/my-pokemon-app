package com.app.mypokemonapp.navigation.screenrouters

import com.app.myapplication.screens.pokemonpage.getPokemonPageScreen
import com.app.mypokemonapp.screens.startscreen.presentation.StartScreenRouter
import com.github.terrakok.cicerone.Router

class StartScreenRouterImpl(private val router:Router):StartScreenRouter {

	override fun navigateItem(nameOfPokemon:String) {
		router.navigateTo(getPokemonPageScreen(nameOfPokemon))
	}
}