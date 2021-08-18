package com.elfatah.pokeapp.di

import com.elfatah.pokeapp.domain.pokemon.usecase.GetPokemonListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPokemonListUseCase(get()) }
}