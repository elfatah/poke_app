package com.elfatah.pokeapp.feature.pokemon.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elfatah.pokeapp.domain.pokemon.model.Pokemon
import com.elfatah.pokeapp.domain.pokemon.usecase.GetPokemonListUseCase
import com.elfatah.pokeapp.util.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PokemonListViewModel : ViewModel(), KoinComponent {
    private val getPokemonListUseCase: GetPokemonListUseCase by inject()
    val pokemonListLiveData = MutableLiveData<Resource<List<Pokemon>>>()

    fun getPokemonList() {
        getPokemonListUseCase.execute(GetPokemonListUseCase.Params(0, 10))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                pokemonListLiveData.value = Resource.Success(it)
            }, {
                pokemonListLiveData.value = Resource.Error(it)
            })
    }
}