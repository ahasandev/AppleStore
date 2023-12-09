package com.kingtech.applestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kingtech.applestore.data.ResponseProducts
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _allProductResponse = MutableLiveData<ResponseProducts>()
    val allProductResponse: LiveData<ResponseProducts> = _allProductResponse


    fun getAllProduct() {

        viewModelScope.launch {
            val data = RetrofitClient.getApiDAO().getAllProduct().body()
            _allProductResponse.postValue(data!!)

        }


    }

}