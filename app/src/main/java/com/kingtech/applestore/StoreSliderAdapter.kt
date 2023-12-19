package com.kingtech.applestore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kingtech.applestore.data.Product
import com.kingtech.applestore.databinding.PdImgSliderBinding

class StoreSliderAdapter(private var itemlist :List<Product>) : RecyclerView.Adapter<StoreSliderAdapter.Productviewholder>() {

    class Productviewholder(val binding: PdImgSliderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Productviewholder {
        val binding = PdImgSliderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Productviewholder(binding)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: StoreSliderAdapter.Productviewholder, position: Int) {


    }






}