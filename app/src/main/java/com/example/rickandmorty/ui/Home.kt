package com.example.rickandmorty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.databinding.FragmentHomeBinding

class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCharacter.setOnClickListener {
            findNavController().navigate(HomeDirections.actionHomeToCharacter())
        }

        binding.buttonFavorite.setOnClickListener {
            findNavController().navigate(HomeDirections.actionHomeToFavoritFragment())
        }

        binding.buttonLocation.setOnClickListener {
            Toast.makeText(context, "Sorry, but this Feature is in Development", Toast.LENGTH_SHORT).show()
        }

        binding.buttonEpisode.setOnClickListener {
            Toast.makeText(context, "Sorry, but this Feature is in Development", Toast.LENGTH_SHORT ).show()
        }
    }
}