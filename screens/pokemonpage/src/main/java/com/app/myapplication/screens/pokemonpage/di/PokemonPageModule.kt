package com.app.myapplication.screens.pokemonpage.di

import com.app.myapplication.network.retrofit.apiProvide
import com.app.myapplication.screens.pokemonpage.data.api.PokemonPageApi
import com.app.myapplication.screens.pokemonpage.data.datasource.PokemonPageDataSource
import com.app.myapplication.screens.pokemonpage.data.datasource.PokemonPageDataSourceImpl
import com.app.myapplication.screens.pokemonpage.data.repository.PokemonPageRepositoryImpl
import com.app.myapplication.screens.pokemonpage.domain.repository.PokemonPageRepository
import com.app.myapplication.screens.pokemonpage.domain.usecase.PokemonPageUseCase
import com.app.myapplication.screens.pokemonpage.presentation.PokemonPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pokemonPageModule = module {
	factory<PokemonPageRepository> { PokemonPageRepositoryImpl(get()) }
	factory<PokemonPageDataSource> { PokemonPageDataSourceImpl(get()) }
	factory<PokemonPageApi> { apiProvide().create(PokemonPageApi::class.java) }
	factory { PokemonPageUseCase(get()) }
	viewModel { (nameOfPokemon: String) ->
		PokemonPageViewModel(
			router = get(),
			useCase = get(),
			nameOfPokemon = nameOfPokemon
		)
	}
}