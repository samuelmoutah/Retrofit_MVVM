package com.rjt.retrofitmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rjt.retrofitmvvm.model.Category
import com.rjt.retrofitmvvm.model.CategoryObject
import com.rjt.retrofitmvvm.network.ApiInterface
import com.rjt.retrofitmvvm.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    // Encapsulation in OOPs
    // the reason for this MutableLiveData private is we don't want any Views (Activities/Fragments) to change the internal data
    // (List of Categories coming from the API Server, original data)
    private val _listOfCategories = MutableLiveData<List<Category>>()


    // Getter
    val listOfCategories: LiveData<List<Category>>
        get() = _listOfCategories

    init {
        getListOfCategories()
    }

    private fun getListOfCategories() {

        // business logic

        //call getClient() and creating api interface and call method
        val call = ApiService.getClient().create(ApiInterface::class.java).getCategoryAll()

        /**
         * Asynchronously send the request and notify {@code callback} of its response or if an error
         * occurred talking to the server, creating the request, or processing the response.
         */

        // Anonymous object in Kotlin (or in Java is anonymous class)
        call.enqueue(object : Callback<CategoryObject> {
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<CategoryObject>, t: Throwable) {
                Log.e("sam", t.message)
            }

            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(
                call: Call<CategoryObject>,
                response: Response<CategoryObject>
            )
            {
                _listOfCategories.value = response.body()?.data
            }

        })
    }


}