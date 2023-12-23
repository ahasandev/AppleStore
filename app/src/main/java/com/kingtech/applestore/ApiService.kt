package com.kingtech.applestore

import com.kingtech.applestore.data.Product
import com.kingtech.applestore.data.ResponseProducts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

        @GET(PRODUCTS)
        suspend fun getAllProduct(): Response<ResponseProducts>
        @GET(PRODUCT)
        suspend fun getProduct(@Path("id") id: Int): Response<Product>

}