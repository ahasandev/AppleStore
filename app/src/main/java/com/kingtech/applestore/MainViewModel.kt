package com.kingtech.applestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kingtech.applestore.data.Product
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _allProductResponse = MutableLiveData<Product>()
    val allProductResponse: LiveData<Product> = _allProductResponse


    fun getAllProduct() {

        viewModelScope.launch {
            val data = RetrofitClient.getApiDAO().getAllProduct().body()
            _allProductResponse.postValue(data!!)

        }


    }
    private val _productResponse = MutableLiveData<Product>()
    val productResponse: LiveData<Product> = _productResponse


    fun getProduct(pid:Int) {

        viewModelScope.launch {
            val data = RetrofitClient.getApiDAO().getProduct(pid).body()
            _productResponse.postValue(data!!)

        }


    }

}