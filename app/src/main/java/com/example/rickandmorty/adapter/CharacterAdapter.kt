package com.example.rickandmorty.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty.R
import com.example.rickandmorty.data.model.Character
import com.example.rickandmorty.ui.CharacterFragmentDirections
import com.google.android.material.card.MaterialCardView

class CharacterAdapter(

) : RecyclerView.Adapter<CharacterAdapter.ItemViewHolder>() {
    private var dataset = listOf<Character>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Character>) {
        dataset = list
        notifyDataSetChanged()
    }

    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<ImageView>(R.id.ivChar_image)
        val textView = view.findViewById<TextView>(R.id.tvChar_name)
        val card = view.findViewById<MaterialCardView>(R.id.button_character)
    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        //Die Recyclerelemente angelegt
        holder.textView.text = item.name
        val imgUri = item.image.toUri().buildUpon().scheme("https").build()

        holder.imageView.load(imgUri) {
            error(R.drawable.broken_image)
        }

        holder.card.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(CharacterFragmentDirections.actionCharacterToCharacterDetail(item.id))
        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount() = dataset.size
}