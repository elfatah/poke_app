package com.elfatah.pokeapp.data.pokemon.mapper

import com.elfatah.pokeapp.data.pokemon.model.PokemonEntity
import com.elfatah.pokeapp.domain.pokemon.model.NamedApiResource
import com.elfatah.pokeapp.domain.pokemon.model.Pokemon
import com.elfatah.pokeapp.domain.pokemon.model.PokemonSprites

fun PokemonEntity.toPokemon(): Pokemon {
    return Pokemon(
        id = id,
        name = name,
        baseExperience = baseExperience,
        height = height,
        isDefault = isDefault,
        order = order,
        weight = weight,
        species = NamedApiResource(species, "", 1),
        abilities = listOf(),
        forms = listOf(),
        gameIndices = listOf(),
        heldItems = listOf(),
        moves = listOf(),
        stats = listOf(),
        types = listOf(),
        sprites = PokemonSprites(sprites, null, null, null, null, null, null, null)
    )
}

fun Pokemon.toPokemonEntity(): PokemonEntity {
    return PokemonEntity(
        id = id,
        name = name,
        baseExperience = baseExperience,
        height = height,
        isDefault = isDefault,
        order = order,
        weight = weight,
        species = species.name,
        abilities = abilities.joinToString { it.ability.name },
        forms = forms.joinToString { it.name },
        gameIndices = gameIndices.joinToString { it.gameIndex.toString() },
        heldItems = heldItems.joinToString { it.item.name },
        moves = moves.joinToString { it.move.name },
        stats = stats.joinToString { it.stat.toString() },
        types = types.joinToString { it.type.name },
        sprites = sprites.frontDefault
    )
}