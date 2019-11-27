package com.example.retrofit_demo.services

import com.example.retrofit_demo.Destination
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


//define functions which will map to webservice end point urls
interface DestinationService {

    //method name
    @GET("destinations")

    fun getDestinationlist():Call<List<Destination>>

    @GET("destinations/{id}")
    //http://baseurl/destination/47
    fun getDestinationid(@Path("id")id:Int):Call<Destination>




}