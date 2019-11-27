package com.example.retrofit_demo.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {


    private const val URL="http://10.0.2.2:9000/"

    //IT HELPS TO CREATE RETROFIT BUILDER

private val okHTTP:OkHttpClient.Builder =OkHttpClient.Builder()

    //create retrofit builder  & integrate gson with your retrofit

    private  val builder: Retrofit.Builder=Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).client(
        okHTTP.build())

        //create retrofit instance
    private  val retrofit= builder.build()

    fun <T> builService(serviceType:Class<T>):T
    {
        return retrofit.create(serviceType) //we call the functions we have defined in the interface such as getdestinations()
    }



}