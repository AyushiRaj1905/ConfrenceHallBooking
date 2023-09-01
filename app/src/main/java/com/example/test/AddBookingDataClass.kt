package com.example.test

import com.google.gson.annotations.SerializedName

data class AddBookingDataClass(
    @SerializedName("Booking_Id") val bookingId:String,
    @SerializedName("booking_date") val bookingDate:String,
    @SerializedName("Booking_Form") val bookingfrom:String,
    @SerializedName("Booking_To") val  bookingto:String,
    @SerializedName ("Booking_Period") val bookingperiod:String,
    @SerializedName("Booking_Details") val  bookingdetails:String,
    @SerializedName ("Booking_Purpose") val bookingpurpose:String,
    @SerializedName("Participants_Count") val pcount:String,
    @SerializedName("Confrence_RoomNo") val confroom:String,
    @SerializedName("Employee_No") val empNo:String

)