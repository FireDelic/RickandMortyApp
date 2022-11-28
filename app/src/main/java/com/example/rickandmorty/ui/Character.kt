package com.example.rickandmorty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.liveData
import com.example.rickandmorty.R
import com.example.rickandmorty.data.model.CharacterList
import com.example.rickandmorty.data.remote.CharacterApi
import com.example.rickandmorty.databinding.FragmentCharacterBinding

class Character: Fragment() {
    private lateinit var binding: FragmentCharacterBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvCharacterList = viewModel.loadCharacter(6)
        viewModel.character.observe(viewLifecycleOwner) {
            println("from Observer: ")
            println(it.toString())
            listOf(rvCharacterList)
        }
    }
}