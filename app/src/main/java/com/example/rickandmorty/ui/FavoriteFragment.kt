package com.example.rickandmorty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.rickandmorty.R
import com.example.rickandmorty.adapter.CharacterAdapter
import com.example.rickandmorty.databinding.FragmentFavoritBinding

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoritBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_favorit,
            container,
            false
        )
        binding.lifecycleOwner = this.viewLifecycleOwner
        /*
        binding = FragmentFavoriteBinding.inflate(inflater)
        binding.lifecycleOwner = this*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.saveCharacter()

        val favoriteAdapter = CharacterAdapter()
        binding.favList.adapter = favoriteAdapter

        viewModel.favouritsList.observe(viewLifecycleOwner) {
            favoriteAdapter.submitList(it)
        }

    }
}