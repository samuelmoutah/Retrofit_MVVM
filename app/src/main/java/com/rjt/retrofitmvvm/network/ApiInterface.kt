package com.rjt.retrofitmvvm.network

import com.rjt.retrofitmvvm.model.Category
import com.rjt.retrofitmvvm.model.CategoryObject
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface  {

    @GET("category")

    // returning an instance of call of type category object
    fun getCategoryAll() : Call<CategoryObject>

}