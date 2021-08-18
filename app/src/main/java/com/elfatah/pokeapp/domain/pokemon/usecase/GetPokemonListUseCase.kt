package com.elfatah.pokeapp.domain.pokemon.usecase

import com.elfatah.pokeapp.domain.pokemon.model.Pokemon
import com.elfatah.pokeapp.domain.pokemon.repository.PokemonRepository
import io.reactivex.rxjava3.core.Observable

class GetPokemonListUseCase(
    private val pokemonRepository: PokemonRepository
) : BaseUseCase<GetPokemonListUseCase.Params, List<Pokemon>>() {
    data class Params(
        val offset: Int,
        val limit: Int
    )

    override fun build(params: Params): Observable<List<Pokemon>> {
        return pokemonRepository.getPokemonList(params.offset, params.limit)
    }
}