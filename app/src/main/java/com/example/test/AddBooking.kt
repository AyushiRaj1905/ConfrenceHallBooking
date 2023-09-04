package com.example.test

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*


class AddBooking : AppCompatActivity() {
    val BASE_URL = "http://192.168.43.211:9091/api/";


    private lateinit var mSpinnerConfrenceRoomId: Spinner
    private  lateinit var  mEditTextEmployeeId: EditText
    private  lateinit var  mEditTextEmployeeName: EditText
    private  lateinit var  mEditTextEmpDesg: EditText
    private  lateinit var  mEditTextEmpDept:EditText

    private  lateinit var  mEditText_Booking_Date:EditText
    private lateinit var  mEditText_Booking_Period: EditText
    private lateinit var mEdittextConfrenceParticipantsCount:EditText
    private lateinit var mEditText_BookingFromHrs:EditText
    private lateinit var mEditText_Booking_to:EditText
    private  lateinit var  mEditTextBookingPurpose: EditText
    private lateinit var mEditText_Booking_Details:EditText

    private lateinit var mButton_Submit:Button

    private var year = 0
    private var month = 0
    private var day = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_booking)
        //Finding Ids
        mEditTextEmployeeId = findViewById(R.id.editTextTextEmployeeId);
        mEditTextEmployeeName = findViewById(R.id.edit_text_employee_name);
        mEditTextEmpDesg = findViewById(R.id.edit_text_employe_desg);
        mEditTextEmpDept = findViewById(R.id.edit_text_employee_dept)
        mEditText_Booking_Date = findViewById(R.id.booking_date)
        mEditText_Booking_Period = findViewById(R.id.edit_text_booking_period)

        // Corrected layout name


        mEditTextBookingPurpose = findViewById(R.id.bp)
        mButton_Submit = findViewById(R.id.button2)
        mEditText_Booking_to = findViewById(R.id.hrs)
        mEditText_BookingFromHrs= findViewById(R.id.edit_text_booking_from_hrs)
        mEdittextConfrenceParticipantsCount=findViewById(R.id.edit_text_participants_count);


        val calendar = Calendar.getInstance()
        mEditText_Booking_Date.setOnClickListener(View.OnClickListener {
            year = calendar.get(Calendar.YEAR)
            month = calendar.get(Calendar.MONTH)
            day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(this@AddBooking, DatePickerDialog.OnDateSetListener { datePicker: DatePicker, i: Int, i1: Int, i2: Int ->
                calendar.set(i, i1, i2) // Update the calendar with the selected date
                mEditText_Booking_Date.setText(SimpleDateFormat.getDateInstance().format(calendar.time))
            }, year, month, day)
            datePickerDialog.show()
        })

        mSpinnerConfrenceRoomId = findViewById(R.id.spinnerHallIds);
        val textSizes = resources.getStringArray(R.array.conference_hall)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, textSizes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mSpinnerConfrenceRoomId.adapter = adapter

        mEditText_Booking_Details=findViewById(R.id.edit_text_booking_details)




    }

    override fun onStart() {
        super.onStart()
        mButton_Submit.setOnClickListener {
            // Get data from EditText fields
            val empNo = mEditTextEmployeeId.text.toString()
            val empName = mEditTextEmployeeName.text.toString()
            val empDesg = mEditTextEmpDesg.text.toString()
            val empDept = mEditTextEmpDept.text.toString()
            val bookingfrom= mEditText_BookingFromHrs.text.toString();
            val bookingto = mEditText_Booking_to.text.toString();
            val bookingDate = mEditText_Booking_Date.text.toString()
            val bookingPeriod=mEditText_Booking_Period.text.toString();
            val bookingDetails = mEditText_Booking_Details.text.toString()
            val pCount = mEdittextConfrenceParticipantsCount.text.toString();

            val bookingPurpose = mEditTextBookingPurpose.text.toString()
            val confrenceRoomId= mSpinnerConfrenceRoomId.selectedItemId.toString();


            // Now, you have all the data from EditText and Spinner fields, you can use this data as needed.
            // For example, you can display it, send it to an API, or store it in a database.

            // Display the data in a Toast message (for demonstration purposes)
            val message = "Employee No: $empNo\nEmployee Name: $empName\nConference Room: " +
                    "$confrenceRoomId\nBooking Date: $bookingDate $bookingfrom:$bookingto\n" +
                    "Booking Details: $bookingDetails\nBooking Purpose: $bookingPurpose\nBooking Day: " +
                    "$bookingDate\nParticipant Count: $pCount\n employee Designation : $empDesg\n " +
                    "mployee Department:$empDept"
            Toast.makeText(this@AddBooking, message, Toast.LENGTH_LONG).show()
            Log.d("Emplyee data input\n",message);
            val uniqueID = UUID.randomUUID().toString()
            val mBookinData= AddBookingDataClass(uniqueID,bookingDate,bookingfrom,bookingto,bookingPeriod,
                bookingDetails, bookingPurpose, pCount,confrenceRoomId,empNo)
            performAddBooking(mBookinData);
        }
    }

    private fun performAddBooking(mBookinData:AddBookingDataClass) {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        val apiService = retrofitBuilder.create(ApiService::class.java)

        val call= apiService.addBookingRequest(mBookinData);
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                val responseBody = response.body()!!

                Log.d("Response data",responseBody.toString());
                Log.d("Response", "Success post");
                Toast.makeText(this@AddBooking, "Success aDDED Booking", Toast.LENGTH_LONG).show()
                val i = Intent(this@AddBooking, DetailActivity::class.java)
                startActivity(i)
                //Toast.makeText(this@QueryBooking,responseBody.toString(),Toast.LENGTH_LONG).show();

                //findViewById<RecyclerView>(R.id.recycler_view).adapter=myAdapter

            }

            override fun onFailure(call: Call<String>, t: Throwable?) {
                if (t != null) {
                    Log.d("retrofit", "call failed"+t.message)
                }
                Toast.makeText(this@AddBooking,"Api Call error",Toast.LENGTH_LONG).show();

            }
        })    }


}
