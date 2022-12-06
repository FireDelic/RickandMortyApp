package com.example.rickandmorty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.rickandmorty.databinding.FragmentCharacterdetailBinding

class CharacterDetail : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentCharacterdetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterdetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val charID = requireArguments().getInt("charID", 1)
        val selectedChar = viewModel.characterList.value!!.find { it.id == charID }
        if (selectedChar != null) {
            val imageUri = selectedChar.image.toUri().buildUpon().scheme("https").build()
            binding.charImage.load(imageUri)
            binding.charId.text = charID.toString()
            binding.charName.text = selectedChar.name
            binding.charSpecies.text = selectedChar.species
            binding.charStatus.text = selectedChar.status
        }

        binding.btnSave.setOnClickListener {
            if (selectedChar != null) {
                viewModel.saveCharacter(selectedChar)
            }
        }

        binding.btnDelete.setOnClickListener{
            if (selectedChar != null) {
                viewModel.deleteFav(selectedChar.id)
            }
        }
    }
}