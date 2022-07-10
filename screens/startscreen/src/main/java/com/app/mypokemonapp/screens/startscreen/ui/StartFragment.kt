package com.app.mypokemonapp.screens.startscreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.app.mypokemonapp.screens.startscreen.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.app.mypokemonapp.screens.startscreen.databinding.FragmentStartBinding
import com.app.mypokemonapp.screens.startscreen.domain.entity.Entity
import com.app.mypokemonapp.screens.startscreen.presentation.StartScreenState
import com.app.mypokemonapp.screens.startscreen.presentation.StartScreenViewModel

class StartFragment : Fragment() {

	companion object {

		fun newInstance() = StartFragment()
	}

	private val viewModel: StartScreenViewModel by viewModel()
	private var adapter: StartScreenListAdapter = StartScreenListAdapter {}
	private lateinit var binding: FragmentStartBinding

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		super.onCreateView(inflater, container, savedInstanceState)
		binding = FragmentStartBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		adapter = StartScreenListAdapter(viewModel::navigateToItem)
		super.onViewCreated(view, savedInstanceState)
		setObservers()
	}

	private fun setObservers() {
		viewModel.state.observe(viewLifecycleOwner, ::bindState)
		binding.recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
			override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
				super.onScrollStateChanged(recyclerView, newState)
				if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
					viewModel.updateList()
				}
			}
		})
	}

	private fun bindState(state: StartScreenState) {
		when (state) {
			is StartScreenState.Initial -> renderInitial()

			is StartScreenState.Loading -> renderLoading()

			is StartScreenState.Content -> renderContent(state.listOfPokemon)

			is StartScreenState.Error   -> renderError()
		}
	}

	private fun renderError() {
		Toast.makeText(requireContext(), getString(R.string.error_message), Toast.LENGTH_LONG).show()
	}

	private fun renderInitial() {
		with(binding) {
			recycler.visibility = View.GONE
			progressBar.visibility = View.VISIBLE
		}
	}

	private fun renderLoading() {
		with(binding) {
			recycler.visibility = View.GONE
			progressBar.visibility = View.VISIBLE
		}
	}

	private fun renderContent(list: List<Entity>) {
		with(binding) {
			if(adapter.currentList.isEmpty()) {
				recycler.visibility = View.VISIBLE
				progressBar.visibility = View.GONE
				adapter = StartScreenListAdapter(viewModel::navigateToItem)
				recycler.adapter = adapter
				adapter.submitList(list.toMutableList())
			}else{
				adapter.onCurrentListChanged(adapter.currentList, list)
				adapter.submitList(list.toMutableList())
			}
		}
	}
}