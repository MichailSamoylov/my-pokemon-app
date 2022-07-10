package com.app.mypokemonapp.screens.startscreen

import com.app.mypokemonapp.screens.startscreen.ui.StartFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun getStartScreen() = FragmentScreen { StartFragment.newInstance() }