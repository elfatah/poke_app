package com.elfatah.pokeapp.data.pokemon.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elfatah.pokeapp.domain.pokemon.model.NamedApiResource
import com.elfatah.pokeapp.domain.pokemon.model.Pokemon
import com.elfatah.pokeapp.domain.pokemon.model.PokemonSprites

@Entity(tableName = "PokemonEntity")
data class PokemonEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val isDefault: Boolean,
    val order: Int,
    val weight: Int,
    val species: String,
    val abilities: String,
    val forms: String,
    val gameIndices: String,
    val heldItems: String,
    val moves: String,
    val stats: String,
    val types: String,
    val sprites: String?
)

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