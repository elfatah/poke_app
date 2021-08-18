package com.elfatah.pokeapp.di

import com.elfatah.pokeapp.feature.pokemon.list.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PokemonListViewModel() }
}