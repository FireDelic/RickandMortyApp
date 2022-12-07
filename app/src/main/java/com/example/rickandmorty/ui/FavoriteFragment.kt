package com.example.rickandmorty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.rickandmorty.R
import com.example.rickandmorty.adapter.FavoriteAdapter
import com.example.rickandmorty.databinding.FragmentFavoritBinding

class FavoriteFragment : Fragment() {

    //Für den Inflater
    private lateinit var binding: FragmentFavoritBinding
    private val viewModel: MainViewModel by activityViewModels()


    //Hier wird der Screen aufgeblasen!! ( quasi Inflated )
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
        return binding.root
    }

    //Screen wird inflated und mit dem Recycler bestückt bzw. verbunden
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Hier wird der Recycler meiner Favoriten angeschlossen
        val favoriteAdapter = FavoriteAdapter()
        binding.favList.adapter = favoriteAdapter

        viewModel.favouritsList.observe(
            viewLifecycleOwner
        )
        {
            favoriteAdapter.submitList(it)
        }
    /*
        binding.favList.setOnClickListener {

            findNavController().navigate(FavoriteFragmentDirections.actionFavoritFragmentToCharacterDetail(charID))
        }
*/
    }
}