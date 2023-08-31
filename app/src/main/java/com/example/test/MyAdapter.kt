package com.example.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val  context: Context, val userList: List<Property>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var Booking_ID:TextView

        var booking_date:TextView

        var Booking_Details:TextView

        var Booking_Purpose:TextView
        var BookingRoomImage:ImageView;




        init {

            Booking_ID=itemView.findViewById(R.id.Booking_ID)

            booking_date=itemView.findViewById(R.id.booking_date)

            Booking_Details=itemView.findViewById(R.id.Booking_Details)

            Booking_Purpose=itemView.findViewById(R.id.Booking_Purpose)
            BookingRoomImage=itemView.findViewById(R.id.image);



        }



    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var itemView=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)

        return ViewHolder(itemView)

    }



    override fun getItemCount(): Int {

        return  userList.size

    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.Booking_ID.text="Booking ID :"+userList[position].Booking_Id.toString()

        holder.booking_date.text="Booking Date : "+userList[position].Booking_Date.toString()

        holder.Booking_Details.text="Booking Details : "+userList[position].Booked_Details.toString()

        holder.Booking_Purpose.text="Booking Purpose : "+userList[position].Booked_Purpose.toString()
        holder.BookingRoomImage.setImageResource(R.drawable.hall);

    }





}

/*
class MyAdapter(private val data: List<Property>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(property:Property){
            val Booking_ID = view.findViewById<TextView>(R.id.Booking_ID)

            val booking_date = view.findViewById<TextView>(R.id.booking_date)

            Booking_ID.text = property.Booking_Id
            booking_date.text = property.Booking_Date

           // Glide.with(view.context).load(property.image).centerCrop().into(imageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }


}*/
