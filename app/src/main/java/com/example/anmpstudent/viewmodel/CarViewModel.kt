package com.example.anmpstudent.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.anmpstudent.model.Car
import com.example.anmpstudent.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CarViewModel(application: Application):AndroidViewModel(application) {
    val carsLD = MutableLiveData<ArrayList<Car>>()
    val TAG = "volleyTagCar"
    private var queue: RequestQueue? = null

    fun refresh() {
        Log.d("CEKMASUK", "masukvolley")
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/cars/cars.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Car>>() { }.type
                val result = Gson().fromJson<List<Student>>(it, sType)
                carsLD.value = result as ArrayList<Car>?
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}