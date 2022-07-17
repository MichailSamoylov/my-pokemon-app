package com.app.myapplication.screens.pokemonpage.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.myapplication.screens.pokemonpage.domain.usecase.PokemonPageUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class PokemonPageViewModel(
	private val router: PokemonPageRouter,
	private val useCase: PokemonPageUseCase,
	private val nameOfPokemon: String
) : ViewModel() {

	private val _state = MutableLiveData<PokemonPageState>(PokemonPageState.Initial)
	val state: LiveData<PokemonPageState> = _state

	private val errorHandler = CoroutineExceptionHandler { _, throwable ->
		println(throwable)
		_state.value = PokemonPageState.Error
	}

	init{
		getPokemonParameters()
	}

	private fun getPokemonParameters(){
		_state.value = PokemonPageState.Loading
		viewModelScope.launch(errorHandler) {
			_state.value = PokemonPageState.Content(
				useCase.invoke(nameOfPokemon)
			)
		}
	}
	fun navigateBack() {
		router.navigateBack()
	}
}