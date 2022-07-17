package com.app.myapplication.screens.pokemonpage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.app.myapplication.additional.extansion.addBackPressedListener
import com.app.myapplication.screens.pokemonpage.R
import com.app.myapplication.screens.pokemonpage.databinding.FragmentPokemonPageBinding
import com.app.myapplication.screens.pokemonpage.presentation.PokemonPageState
import com.app.myapplication.screens.pokemonpage.presentation.PokemonPageViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

const val NUMBER_POKEMON_KEY = "NAME_POKEMON_KEY"
var Bundle.namePokemon: String
	get() = this.getString(NUMBER_POKEMON_KEY) ?: ""
	set(value) = this.putString(NUMBER_POKEMON_KEY, value)

class PokemonPageFragment : Fragment() {

	companion object {

		fun newInstance(
			nameOfPokemon: String
		) =
			PokemonPageFragment()
				.apply {
					val bundle = Bundle()
					bundle.namePokemon = nameOfPokemon
					arguments = bundle
				}
	}

	private val viewModel: PokemonPageViewModel by viewModel {
		parametersOf(requireArguments().namePokemon)
	}

	private lateinit var binding: FragmentPokemonPageBinding

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		binding = FragmentPokemonPageBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel.state.observe(viewLifecycleOwner, ::handleState)
		addBackPressedListener {
			viewModel.navigateBack()
		}
	}

	private fun handleState(state: PokemonPageState) {
		when (state) {
			is PokemonPageState.Initial -> Unit
			is PokemonPageState.Loading -> renderLoading()
			is PokemonPageState.Content -> renderContent(state)
			is PokemonPageState.Error   -> renderError()
		}
	}

	private fun renderLoading() {
		with(binding) {
			progressBar.visibility = View.VISIBLE
			content.visibility = View.GONE
		}
	}

	private fun renderError() {
		Toast.makeText(requireContext(), getString(R.string.error_message), Toast.LENGTH_LONG).show()
	}

	private fun renderContent(state: PokemonPageState.Content) {
		with(binding) {
			progressBar.visibility = View.GONE
			content.visibility = View.VISIBLE

			name.text = state.entity.name
			type.text = state.entity.type
			wight.text = state.entity.weight
			height.text = state.entity.height
			Picasso
				.get()
				.load(state.entity.sprites.front_default)
				.resize(600, 600)
				.into(icon)
		}
	}
}