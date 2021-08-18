package com.elfatah.pokeapp.data.pokemon.source.local

import com.elfatah.pokeapp.data.pokemon.source.PokemonDataSource
import com.elfatah.pokeapp.domain.pokemon.model.NamedApiResource
import com.elfatah.pokeapp.domain.pokemon.model.Pokemon
import com.elfatah.pokeapp.domain.pokemon.model.PokemonSprites
import io.reactivex.rxjava3.core.Observable

class LocalPokemonDataSource : PokemonDataSource {
    override fun getPokemonList(offset: Int, limit: Int): Observable<List<Pokemon>> {
        return Observable.just(listOf())
    }

    override fun getPokemonDetail(id: Int): Observable<Pokemon> {

        //TODO will implement local dbase later
        return Observable.just(
            Pokemon(
                id = 1,
                name = "maman",
                baseExperience = 2,
                height = 1,
                isDefault = true,
                order = 2,
                weight = 1,
                species = NamedApiResource("", "", 1),
                abilities = listOf(),
                forms = listOf(),
                gameIndices = listOf(),
                heldItems = listOf(),
                moves = listOf(),
                stats = listOf(),
                types = listOf(),
                sprites = PokemonSprites(null, null, null, null, null, null, null, null)
            )
        )
    }
}