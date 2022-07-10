package com.app.mypokemonapp.di

import com.app.mypokemonapp.navigation.screenrouters.StartScreenRouterImpl
import com.app.mypokemonapp.screens.startscreen.presentation.StartScreenRouter
import org.koin.dsl.module

val navigateModule = module {
	factory<StartScreenRouter> { StartScreenRouterImpl(get()) }
}