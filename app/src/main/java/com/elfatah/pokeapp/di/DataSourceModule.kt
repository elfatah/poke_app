package com.elfatah.pokeapp.di

import com.elfatah.pokeapp.data.pokemon.source.PokemonDataSource
import com.elfatah.pokeapp.data.pokemon.source.local.LocalPokemonDataSource
import com.elfatah.pokeapp.data.pokemon.source.network.NetworkPokemonDataSource
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val NETWORK_DATASOURCE = "NETWORK_DATASOURCE"
const val LOCAL_DATASOURCE = "LOCAL_DATASOURCE"

val dataSourceModule = module {
    factory<PokemonDataSource>(named(NETWORK_DATASOURCE)) {
        NetworkPokemonDataSource(get())
    }
    factory<PokemonDataSource>(named(LOCAL_DATASOURCE)) {
        LocalPokemonDataSource()
    }
}
