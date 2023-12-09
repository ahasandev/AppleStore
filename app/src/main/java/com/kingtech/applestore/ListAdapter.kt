package com.kingtech.applestore

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kingtech.applestore.data.ResponseProducts
import com.kingtech.applestore.databinding.ItemBinding

class ListAdapter(private var itemlist :List<ResponseProducts.Product>) : RecyclerView.Adapter<ListAdapter.Itemviewholder>() {

    class Itemviewholder(var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Itemviewholder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Itemviewholder(binding)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Itemviewholder, position: Int) {
        val item = itemlist[position]

        holder.binding.itemtext.text=item.title
        val id = item.id
        val name = item.title
        val image = item.thumbnail
        val price = item.price
        val discount = item.discountPercentage
        val discription = item.description
        val stock = item.stock
        val rating = item.rating
        holder.binding.itemprice.text= "$"+item.price.toString()
        holder.binding.itemimg.load(item.thumbnail)
        holder.binding.root.setOnClickListener{ view ->

            view.findNavController().navigate(R.id.action_productFragment_to_productDetailsFragment,
                Bundle().apply {
                    putInt("itemId", id!!)
                    putString("name", name!!)
                    putString("image", image!!)
                    putDouble("discount", discount!!)
                    putInt("price", price!!)
                    putString("discription", discription!!)
                    putInt("stock", stock!!)


                }
            )
        }

    }



}


