package com.elfatah.pokeapp.di

import com.elfatah.pokeapp.data.pokemon.source.PokemonRepositoryImpl
import com.elfatah.pokeapp.domain.pokemon.repository.PokemonRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    factory<PokemonRepository> {
        PokemonRepositoryImpl(
            localPokemonDataSource = get(named(LOCAL_DATASOURCE)),
            networkPokemonDataSource = get(named(NETWORK_DATASOURCE))
        )
    }
}