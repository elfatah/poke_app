package com.elfatah.pokeapp.domain.pokemon.repository

import com.elfatah.pokeapp.domain.pokemon.model.Pokemon
import io.reactivex.rxjava3.core.Observable

interface PokemonRepository {
    fun getPokemonList(offset: Int, limit: Int): Observable<List<Pokemon>>
    fun getPokemonDetail(id: Int): Observable<Pokemon>
}