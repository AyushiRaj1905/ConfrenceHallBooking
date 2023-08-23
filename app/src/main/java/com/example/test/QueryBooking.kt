package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.StringBuilder

class QueryBooking : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>
     val BASE_URL = "http://localhost:44324/api/";
private  lateinit var apiService:ApiService;
    private lateinit var displaybookingId:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_query_booking)
        manager = LinearLayoutManager(this)
        displaybookingId= findViewById(R.id.textView26);


        getAllApiRoomData()
    }

    private fun getAllApiRoomData() {
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java);
        val retrofitData = retrofitBuilder.getAllData();
        retrofitData.enqueue(object : Callback<List<Property>?> {

            override fun onResponse(call: Call<List<Property>?>, response: Response<List<Property>?>) {
                val responseBody = response.body()!!
                val str = StringBuilder();
                str.append("Api Data\n");
                for(mydata in responseBody){
                     str.append(mydata.Booking_Id);
                    str.append("\n");
                }

                displaybookingId.text= str;
                Toast.makeText(this@QueryBooking,str,Toast.LENGTH_LONG).show();
            }
            override fun onFailure(call: Call<List<Property>?>, t: Throwable?) {
                Log.v("retrofit", "call failed")
                Toast.makeText(this@QueryBooking,"Api Call rror",Toast.LENGTH_LONG).show();

            }
        })
    }
}


   /* fun getAllData(){
        Api.retrofitService.getAllData().enqueue(object: Callback<List<Property>>{
            override fun onResponse(
                call: Call<List<Property>>,
                response: Response<List<Property>>
            ) {
                if(response.isSuccessful){
                    recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply{
                        myAdapter = MyAdapter(response.body()!!)
                        layoutManager = manager
                        adapter = myAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Property>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }*/






