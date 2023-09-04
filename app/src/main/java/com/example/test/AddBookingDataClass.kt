package com.example.test

import com.google.gson.annotations.SerializedName

data class AddBookingDataClass(
    @SerializedName("Booking_Id") val bookingId:String,
    @SerializedName("booking_date") val bookingDate:String,
    @SerializedName("Booking_from") val bookingfrom:String,
    @SerializedName("Booking_To") val  bookingto:String,
    @SerializedName ("Booking_Period") val bookingperiod:String,
    @SerializedName("Booked_Details") val  bookingdetails:String,
    @SerializedName ("Booked_Purpose") val bookingpurpose:String,
    @SerializedName("Participant_count") val pcount:String,
    @SerializedName("conference_room") val confrenceRoomId:String,
    @SerializedName("Emp_No") val empNo:String

)