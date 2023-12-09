package com.kingtech.applestore

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import coil.load
import com.kingtech.applestore.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val id= requireArguments().getInt("itemId").toString()
       val name= requireArguments().getString("name")
       val image= requireArguments().getString("image")
       val discount= requireArguments().getInt("discount").toString()
       val price= requireArguments().getInt("price").toString()
       val discription= requireArguments().getInt("discription").toString()
       val stock= requireArguments().getInt("stock").toString()

        binding.apply {
            pdtitle.text = name
            pddiscount.text = discount
            pdprice.text = price
            productimg.load(image)
        }
    }




}