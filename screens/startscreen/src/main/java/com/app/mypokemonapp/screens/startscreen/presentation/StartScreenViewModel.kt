package com.app.mypokemonapp.screens.startscreen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mypokemonapp.screens.startscreen.domain.entity.Entity
import com.app.mypokemonapp.screens.startscreen.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class StartScreenViewModel(
	private val router: StartScreenRouter,
	private val useCase: UseCase
) : ViewModel() {

	private companion object {

		const val firstNumberOfPokemon = 1
		const val countOfPokemonRequestInOneTime = 15
	}

	private val _state = MutableLiveData<StartScreenState>(StartScreenState.Initial)
	val state: LiveData<StartScreenState> = _state

	private val errorHandler = CoroutineExceptionHandler { _, _ ->
		_state.postValue(StartScreenState.Error)
	}

	init {
		getListOfPokemon()
	}

	private fun getListOfPokemon() {
		_state.value = StartScreenState.Loading
		viewModelScope.launch(errorHandler) {

			val startRange =  firstNumberOfPokemon
			val endRange = countOfPokemonRequestInOneTime

			val tempList = mutableListOf<Entity>()
			for (i in startRange..endRange) {
				tempList.add(useCase(i))
			}
			_state.value = StartScreenState.Content(tempList)
		}
	}

	fun updateList(){
		val tempState = _state.value as? StartScreenState.Content ?: return
		viewModelScope.launch(errorHandler) {
			val startRange = tempState.listOfPokemon.size + firstNumberOfPokemon
			val endRange = tempState.listOfPokemon.size + countOfPokemonRequestInOneTime
			val tempList = tempState.listOfPokemon.toMutableList()
			for (i in startRange..endRange) {
				tempList.add(useCase(i))
			}
			_state.value = StartScreenState.Content(tempList)
		}
	}

	fun navigateToItem(nameOfPokemon:String) {
		router.navigateItem(nameOfPokemon)
	}
}