package com.app.mypokemonapp.screens.startscreen.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.app.mypokemonapp.screens.startscreen.domain.entity.Entity

class StartScreenListAdapter(
	private val navigateToItem: (nameOfPokemon:String) -> Unit
) : ListAdapter<Entity, StartScreenViewHolder>(VacationsListDiffCallBack) {

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): StartScreenViewHolder =
		StartScreenViewHolder.from(parent)

	override fun onBindViewHolder(holder: StartScreenViewHolder, position: Int) {
		holder.bind(this.getItem(position), navigateToItem)
	}
}

object VacationsListDiffCallBack : DiffUtil.ItemCallback<Entity>() {

	override fun areItemsTheSame(oldItem: Entity, newItem: Entity) =
		oldItem == newItem

	override fun areContentsTheSame(oldItem: Entity, newItem: Entity) =
		oldItem.name == newItem.name && oldItem.sprites == newItem.sprites
}