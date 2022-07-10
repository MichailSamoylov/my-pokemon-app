package com.app.mypokemonapp.screens.startscreen.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.mypokemonapp.screens.startscreen.databinding.FragmentStartBinding
import com.app.mypokemonapp.screens.startscreen.databinding.ListItemViewBinding
import com.app.mypokemonapp.screens.startscreen.domain.entity.Entity
import com.squareup.picasso.Picasso
import java.text.FieldPosition

class StartScreenViewHolder(
	private val binding: ListItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {

	companion object {

		const val POKEMON_ICON_HEIGHT = 600
		const val POKEMON_ICON_WIGHT = 600

		fun from(parent: ViewGroup): StartScreenViewHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = ListItemViewBinding.inflate(inflater, parent, false)
			return StartScreenViewHolder(binding)
		}
	}

	fun bind(
		entity: Entity,
		navigateItem: (nameOfPokemon:String) -> Unit
	) {
		with(binding) {
			pokemonName.text = entity.name
			Picasso
				.get()
				.load(entity.sprites.front_default)
				.resize(POKEMON_ICON_WIGHT, POKEMON_ICON_HEIGHT)
				.into(pokemonImage)

			root.setOnClickListener {
				navigateItem(entity.name)
			}
		}
	}
}