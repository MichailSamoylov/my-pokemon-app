package com.app.mypokemonapp.screens.startscreen.di

import com.app.myapplication.network.retrofit.apiProvide
import com.app.mypokemonapp.screens.startscreen.data.api.Api
import com.app.mypokemonapp.screens.startscreen.data.datasource.DataSource
import com.app.mypokemonapp.screens.startscreen.data.datasource.DataSourceImpl
import com.app.mypokemonapp.screens.startscreen.data.repository.RepositoryImpl
import com.app.mypokemonapp.screens.startscreen.domain.repository.Repository
import com.app.mypokemonapp.screens.startscreen.domain.usecase.UseCase
import com.app.mypokemonapp.screens.startscreen.presentation.StartScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val startScreenModule = module {
	factory<Repository> { RepositoryImpl(dataSource = get()) }
	factory<DataSource> { DataSourceImpl(api = get()) }
	viewModel {
		StartScreenViewModel(
			router = get(),
			useCase = get()
		)
	}
	factory { UseCase(repository = get()) }
	factory<Api> { apiProvide().create(Api::class.java) }
}

