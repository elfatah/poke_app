package com.elfatah.pokeapp.data.pokemon.model

import androidx.room.Entity
import androidx.room.PrimaryKey

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