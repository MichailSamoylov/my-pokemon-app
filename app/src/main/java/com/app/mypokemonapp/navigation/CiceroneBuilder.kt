package com.app.mypokemonapp.navigation

import com.app.mypokemonapp.screens.startscreen.getStartScreen
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

fun buildCicerone(): Cicerone<Router> =
	Cicerone.create().apply {
		router.newRootScreen(getStartScreen())
	}