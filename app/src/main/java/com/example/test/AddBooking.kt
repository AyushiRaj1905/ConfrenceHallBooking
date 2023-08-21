package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import java.text.SimpleDateFormat
import java.util.*

class AddBooking : AppCompatActivity() {
    private lateinit var spinnerTextSize: Spinner
    private lateinit var booking_hrs: Spinner
    private lateinit var booking_mins: Spinner
    private lateinit var booking_date: EditText
    private var year = 0
    private var month = 0
    private var day = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_booking) // Corrected layout name
        booking_date = findViewById(R.id.booking_date)
        val calendar = Calendar.getInstance()
        booking_date.setOnClickListener(View.OnClickListener {
            year = calendar.get(Calendar.YEAR)
            month = calendar.get(Calendar.MONTH)
            day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(this@AddBooking, DatePickerDialog.OnDateSetListener { datePicker: DatePicker, i: Int, i1: Int, i2: Int ->
                calendar.set(i, i1, i2) // Update the calendar with the selected date
                booking_date.setText(SimpleDateFormat.getDateInstance().format(calendar.time))
            }, year, month, day)
            datePickerDialog.show()
        })

        spinnerTextSize = findViewById(R.id.spinnerTextSize)
        val textSizes = resources.getStringArray(R.array.conference_hall)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, textSizes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTextSize.adapter = adapter

        booking_hrs = findViewById(R.id.booking_hrs)
        val hours = resources.getStringArray(R.array.hours)
        val hoursAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, hours)
        hoursAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        booking_hrs.adapter = hoursAdapter

        booking_mins = findViewById(R.id.booking_mins)
        val mins = resources.getStringArray(R.array.mins)
        val minsAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mins)
        minsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        booking_mins.adapter = minsAdapter
    }
}
