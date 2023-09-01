package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class BookingCalender : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_calender)

        // Sample data
        val fromDate = "2023-09-01"
        val toDate = "2023-09-05"
        val conferenceRoom = "Conference Room A"
        val bookingStatus = "Confirmed"

        // Find TextViews and EditTexts by their IDs
        val fromDateTextView = findViewById<TextView>(R.id.From_date)
        val toDateTextView = findViewById<TextView>(R.id.To_date)
        val conferenceRoomTextView = findViewById<TextView>(R.id.textView22)
        val bookingStatusTextView = findViewById<TextView>(R.id.textView24)

        // Set the sample data to the TextViews and EditTexts
        fromDateTextView.text = fromDate
        toDateTextView.text = toDate
        conferenceRoomTextView.text = conferenceRoom
        bookingStatusTextView.text = bookingStatus
    }
}
