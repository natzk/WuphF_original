package com.example.wuphf

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wuphf.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso


class CardStackAdapter : RecyclerView.Adapter<CardStackAdapter.ItemViewHolder>() {

    private lateinit var items: List<ItemModel>

    fun CardStackAdapter(items: List<ItemModel>) { this.items = items }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        holder.setData(items[position])
        val itemsViewModel = items[position]
        holder.binding.itemName.text = itemsViewModel.name
        holder.binding.itemAge.text = itemsViewModel.city
    }

    override fun getItemCount(): Int {return items.size}

    class ItemViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        var image = binding.itemImage
        var name = binding.itemName
        var city = binding.itemCity
    }

    fun setData(data: ItemModel) {
        Picasso.get()
            .load(data.name)
            .fit()
            .centerCrop()
            .into()
        name.setText(data.getName())
        city.setText(data.getCity())
        image.setImage(data.getImage())
    }






  /*
    Fragments:
   V 1. Swiping Fragment -
   -------
   V 2. Favorites
    3. Saved
    --------
    4. Contacts
    5. Location - to see if you have dogs around you
   V 6. "Abouts" fragment
    7. Suggestions for adoption websites\best practices for adopting animals\suggestions for ordering food for dogs
   V 8. FAQs
    9. Adopted
  V  10. Additional information when clicking on the item




   */
}

