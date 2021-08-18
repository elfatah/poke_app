package com.elfatah.pokeapp.data.pokemon.source

import com.elfatah.pokeapp.domain.pokemon.model.Pokemon
import io.reactivex.rxjava3.core.Observable

interface PokemonDataSource {
    fun getPokemonList(offset: Int, limit: Int): Observable<List<Pokemon>>
    fun getPokemonDetail(id: Int): Observable<Pokemon>
}