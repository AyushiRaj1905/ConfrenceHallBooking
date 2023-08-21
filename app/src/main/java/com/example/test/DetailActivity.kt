package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }


    fun QueryBooking(view: View) {

        val i = Intent(this, QueryBooking::class.java)
        startActivity(i)
    }

    fun AddBooking(view: View) {


            val i = Intent(this, AddBooking::class.java)
            startActivity(i)
    }
    fun AddCalender(view: View) {


        val i = Intent(this, BookingCalender::class.java)
        startActivity(i)
    }
}