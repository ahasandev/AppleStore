package com.kingtech.applestore

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kingtech.applestore.data.Product
import com.kingtech.applestore.databinding.FragmentProductBinding


class ProductFragment :BaseFragment<FragmentProductBinding>(FragmentProductBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()
    var itemlist: List<Product> = listOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllProduct()

        val manager = GridLayoutManager(requireContext(), 2)
        binding.rcvslistitem.layoutManager = manager
        binding.rcvslistitem.adapter = ListAdapter(itemlist)

        viewModel.allProductResponse.observe(requireActivity()) { response ->

            if (response != null) {
                itemlist = response as List<Product>
            }

            binding.rcvslistitem.adapter = ListAdapter(itemlist)

        }


    }
}