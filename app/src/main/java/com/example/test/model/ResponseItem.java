package com.example.test.model;

import com.google.gson.annotations.SerializedName;

public class ResponseItem{

	@SerializedName("Booking_to")
	private String bookingTo;

	@SerializedName("Booking_Id")
	private String bookingId;

	@SerializedName("Booked_Purpose")
	private String bookedPurpose;

	@SerializedName("Booking_Period")
	private String bookingPeriod;

	@SerializedName("Booking_Day")
	private String bookingDay;

	@SerializedName("Participant_count")
	private String participantCount;

	@SerializedName("Booked_Details")
	private String bookedDetails;

	@SerializedName("Booking_Date")
	private String bookingDate;

	@SerializedName("Booking_from")
	private String bookingFrom;

	public String getBookingTo(){
		return bookingTo;
	}

	public String getBookingId(){
		return bookingId;
	}

	public String getBookedPurpose(){
		return bookedPurpose;
	}

	public String getBookingPeriod(){
		return bookingPeriod;
	}

	public String getBookingDay(){
		return bookingDay;
	}

	public String getParticipantCount(){
		return participantCount;
	}

	public String getBookedDetails(){
		return bookedDetails;
	}

	public String getBookingDate(){
		return bookingDate;
	}

	public String getBookingFrom(){
		return bookingFrom;
	}
}