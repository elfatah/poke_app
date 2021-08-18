package com.elfatah.pokeapp.data.pokemon.model

import androidx.room.*
import io.reactivex.rxjava3.core.Single

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemon(pokemonEntity: List<PokemonEntity>)

    @Query("SELECT * FROM PokemonEntity")
    fun getAllPokemon(): Single<List<PokemonEntity>>

    @Query("DELETE FROM PokemonEntity")
    fun deleteAllPokemon()

    @Query("SELECT * FROM PokemonEntity  WHERE id == :id LIMIT 1")
    fun getPokemon(id: Int): Single<PokemonEntity>

    @Transaction
    fun replaceAllPokemon(pokemonEntity: List<PokemonEntity>) {
        deleteAllPokemon()
        insertPokemon(pokemonEntity)
    }
}