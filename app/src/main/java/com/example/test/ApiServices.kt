package com.example.test
import com.example.test.model.DataItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService{

    @GET("FetchRoomData")
    fun getAllData(): Call<List<Property>>

    @POST("FetchRoomData2")
    fun postQueryFetchRequest(@Body mQueryBookingDate: QueryBookingDate): Call<List<Property>>

    @GET("posts")
    fun getPostData():Call<List<DataItem>>

}

