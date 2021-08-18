package com.elfatah.pokeapp.data.pokemon.source

import com.elfatah.pokeapp.domain.pokemon.model.Pokemon
import com.elfatah.pokeapp.domain.pokemon.repository.PokemonRepository
import io.reactivex.rxjava3.core.Observable

class PokemonRepositoryImpl(
    private val localPokemonDataSource: PokemonDataSource,
    private val networkPokemonDataSource: PokemonDataSource
) : PokemonRepository {
    override fun getPokemonList(offset: Int, limit: Int): Observable<List<Pokemon>> {
        return networkPokemonDataSource.getPokemonList(offset, limit)
            .startWith(localPokemonDataSource.getPokemonList(offset, limit))
    }

    override fun getPokemonDetail(id: Int): Observable<Pokemon> {
        TODO("Not yet implemented")
    }
}