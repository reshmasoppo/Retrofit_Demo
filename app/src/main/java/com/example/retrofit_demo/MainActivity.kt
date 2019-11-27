package com.example.retrofit_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofit_demo.services.DestinationService
import com.example.retrofit_demo.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//https://www.youtube.com/watch?v=TC68Fw8ZlhM&list=PLlxmoA0rQ-LzEmWs4T99j2w6VnaQVGEtR&index=23
//https://www.journaldev.com/13639/retrofit-android-example-tutorial

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadDestinations()
        loadDestinations1()
    }
    private fun loadDestinations()
    {
       val destinationService:DestinationService=ServiceBuilder.builService(DestinationService::class.java)
        val requestcall:Call<List<Destination>> = destinationService.getDestinationlist()//(_>call Destinationservice ->RETURN Call objects- fetch destination from server
        requestcall.enqueue(object :Callback<List<Destination>> {

            override fun onFailure(call: Call<List<Destination>>?, t: Throwable?) {

          Toast.makeText(this@MainActivity,"failed to retrive items",Toast.LENGTH_SHORT).show()
      }
     override fun onResponse(call: Call<List<Destination>>?, response: Response<List<Destination>>?)
       {
        if (response!!.isSuccessful)
        {
        val destinationlist:List<Destination> =response.body()
            //destnyrecycler.adapter=DestinationAdapter(destinationlist)
        }
      }


    })
}
    private fun loadDestinations1()
    {
        val destinationService:DestinationService=ServiceBuilder.builService(DestinationService::class.java)

        //val requestcall:Call<List<Destination>> = destinationService.getDestinationlist()//(_>call Destinationservice ->RETURN Call objects- fetch destination from server

        val requestcall:Call<Destination> = destinationService.getDestinationid(id = 1)

        requestcall.enqueue(object :Callback<Destination> {
            override fun onFailure(call: Call<Destination>?, t: Throwable?) {
                Toast.makeText(this@MainActivity,"failed to retrive items",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Destination>?, response: Response<Destination>?) {

                if (response!!.isSuccessful)
                {
                    val destination:Destination =response.body()
                    destination.let {
                       // email.setText( destination.email)
                       // pwd.setText( destination.password)

                    }

                }

            }

        })
}}