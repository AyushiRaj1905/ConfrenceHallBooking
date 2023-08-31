package com.example.test

import com.google.gson.annotations.SerializedName

data class QueryBookingDate(
    @SerializedName("Booking_from_date") val startDate: String,
    @SerializedName("Booking_to_date") val endDate: String
)
