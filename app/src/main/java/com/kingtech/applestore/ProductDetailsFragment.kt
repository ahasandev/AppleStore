package com.kingtech.applestore

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.kingtech.applestore.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val id= requireArguments().getInt("itemId")
        viewModel.getProduct(id)
        setProductObserver()



    }

    @SuppressLint("SetTextI18n")
    private fun setProductObserver(){
        viewModel.productResponse.observe(viewLifecycleOwner){ product ->

            binding.apply {
                pdprice.text = "$${product.price}"
                pdtitle.text = product.title
                pddiscount.text ="${product.discountPercentage}"
                pddiscribtion.text =product.description
            }

        }

    }




}