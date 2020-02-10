package com.rjt.retrofitmvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {


    companion object {
        val BASE_URL = "https://apolis-grocery.herokuapp.com/api/"

        fun getClient(): Retrofit {
            var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }

    }


}