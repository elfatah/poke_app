package com.elfatah.pokeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elfatah.pokeapp.BuildConfig
import com.elfatah.pokeapp.data.pokemon.model.PokemonDao
import com.elfatah.pokeapp.data.pokemon.model.PokemonEntity

@Database(
    entities = [PokemonEntity::class],
    version = BuildConfig.DATABASE_VERSION
)
abstract class PokeDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}