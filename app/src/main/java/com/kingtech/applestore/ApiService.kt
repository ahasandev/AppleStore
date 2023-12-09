package com.kingtech.applestore

import com.kingtech.applestore.data.ResponseProducts
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

        @GET(PRODUCTS)
        suspend fun getAllProduct(): Response<ResponseProducts>


}