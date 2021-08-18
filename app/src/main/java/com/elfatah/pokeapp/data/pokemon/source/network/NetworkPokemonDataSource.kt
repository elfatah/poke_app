package com.elfatah.pokeapp.data.pokemon.source.network

import com.elfatah.pokeapp.data.api.PokeApi
import com.elfatah.pokeapp.data.pokemon.source.PokemonDataSource
import com.elfatah.pokeapp.domain.pokemon.model.Pokemon
import io.reactivex.rxjava3.core.Observable

class NetworkPokemonDataSource(private val pokeApi: PokeApi) : PokemonDataSource {
    override fun getPokemonList(offset: Int, limit: Int): Observable<List<Pokemon>> {
        return pokeApi.getPokemonList(offset, limit)
            .flatMapIterable { it.results }
            .flatMap { pokeApi.getPokemon(it.id) }
            .toList()
            .toObservable()
    }

    override fun getPokemonDetail(id: Int): Observable<Pokemon> {
        return pokeApi.getPokemon(id)
    }
}