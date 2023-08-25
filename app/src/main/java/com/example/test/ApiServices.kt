package com.example.test
import com.example.test.model.DataItem
import retrofit2.Call
import retrofit2.http.GET



interface ApiService{

    @GET("api/FetchRoomData")
    fun getAllData(): Call<List<Property>>

    @GET("posts")
    fun getPostData():Call<List<DataItem>>

}

