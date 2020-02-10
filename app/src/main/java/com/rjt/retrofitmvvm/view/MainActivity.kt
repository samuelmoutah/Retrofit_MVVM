package com.rjt.retrofitmvvm.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rjt.retrofitmvvm.R
import com.rjt.retrofitmvvm.adapter.AdapterCategory
import com.rjt.retrofitmvvm.model.CategoryObject
import com.rjt.retrofitmvvm.network.ApiInterface
import com.rjt.retrofitmvvm.network.ApiService
import com.rjt.retrofitmvvm.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


///**
// * Epic: Grab the data from API using Retrofit and display data in recycler view
// *
// * 1. User Story : How can we get data? ->
// *      a. we need model class. @@
// *      b. create ApiService - base url and choose converter (gson) @@
// *      c. interface - declare endpoint @@
// *      d. test if get data correctly @@
// *
// * 2. User Story: Display data in recycler view
// *      a. adapter @@
// *      b. "big" layout @@
// *      c. row layout @@
// *      d. Put everything together
// * */

/**
 * Epic: Get Data from API using Retrofit, MVVM, LiveData
 *
 * 1. User Story : How can we get data? ->
 *      a. we need model class. @@
 *      b. create ApiService - base url and choose converter (gson) @@
 *      c. interface - declare endpoint @@
 *      d. test if get data correctly @@
 *
 * 2. User Story: Display data in recycler view
 *      a. adapter @@
 *      b. "big" layout @@
 *      c. row layout @@
 *      d. Put everything together
 *
 * 3. User Story: Generate MVVM
 *      a. create Model @@
 *      b. create View @@
 *      c. create ViewModel
 * 3. User Story:
 * */

class MainActivity : AppCompatActivity() {

    lateinit var adapterCategory: AdapterCategory

    lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Providing ViewModel using ViewModelProviders
        // accessing to viewmodel from this activity
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mainViewModel.listOfCategories.observe(this, Observer {
            adapterCategory = AdapterCategory(applicationContext, it)
            recycler_view.adapter = adapterCategory
        })
    }
}
