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
    @POST("AddBooking")
    fun addBookingRequest(@Body mAddBookingDataClass: AddBookingDataClass):Call<String>

    @GET("posts")
    fun getPostData():Call<List<DataItem>>

}

