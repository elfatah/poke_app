package com.elfatah.pokeapp.feature.pokemon.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.elfatah.pokeapp.R
import com.elfatah.pokeapp.util.Resource
import kotlinx.android.synthetic.main.fragment_pokemon_list_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListFragment : Fragment() {
    private val pokemonListViewModel: PokemonListViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon_list_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonListViewModel.pokemonListLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(
                        requireContext(),
                        "error",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is Resource.Loading -> Unit
                is Resource.Success -> {
                    tvtext.text = it.data.size.toString()
                    Log.e("pokemon", it.data.firstOrNull().toString())

                }
            }
        }
        pokemonListViewModel.getPokemonList()
    }
}