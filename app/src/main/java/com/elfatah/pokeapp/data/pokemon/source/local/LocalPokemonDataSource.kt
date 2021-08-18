package com.elfatah.pokeapp.data.pokemon.source.local

import com.elfatah.pokeapp.data.pokemon.model.PokemonDao
import com.elfatah.pokeapp.data.pokemon.model.toPokemon
import com.elfatah.pokeapp.data.pokemon.source.PokemonDataSource
import com.elfatah.pokeapp.domain.pokemon.model.Pokemon
import io.reactivex.rxjava3.core.Observable

class LocalPokemonDataSource(private val pokemonDao: PokemonDao) : PokemonDataSource {
    override fun getPokemonList(offset: Int, limit: Int): Observable<List<Pokemon>> {
        return pokemonDao.getAllPokemon().map { it.map { it.toPokemon() } }.toObservable()
    }

    override fun getPokemonDetail(id: Int): Observable<Pokemon> {
        return pokemonDao.getPokemon(id).map { it.toPokemon() }.toObservable()
    }
}