package com.lti.airfuselage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_booking_record")
public class CustomerBookingRecord {

	@Id
	@GeneratedValue
	private int key;
	
	@Column(length = 30)
	private String name;
	
	private int age;
	
	@Column(length = 10)
	private String type;
	
	private int seatNumber;
	
	private int bookingFare;
	
	@Column(length = 12)
	private String status;
	
	@ManyToOne 
	@JoinColumn(name="pnr")
	private BookingRecord bookingPnr;
	
	//addflightid and date
	//search available seats on the basis id and date

	public CustomerBookingRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CustomerBookingRecord(String name, int age, String type, int seatNumber, int bookingFare, String status,
			BookingRecord bookingPnr) {
		super();
		this.name = name;
		this.age = age;
		this.type = type;
		this.seatNumber = seatNumber;
		this.bookingFare = bookingFare;
		this.status = status;
		this.bookingPnr = bookingPnr;
	}



	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getBookingFare() {
		return bookingFare;
	}

	public void setBookingFare(int bookingFare) {
		this.bookingFare = bookingFare;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BookingRecord getBookingPnr() {
		return bookingPnr;
	}

	public void setBookingPnr(BookingRecord bookingPnr) {
		this.bookingPnr = bookingPnr;
	}

	@Override
	public String toString() {
		return "CustomerBookingRecord [key=" + key + ", name=" + name + ", age=" + age + ", type=" + type
				+ ", seatNumber=" + seatNumber + ", bookingFare=" + bookingFare + ", status=" + status + ", bookingPnr="
				+ bookingPnr + "]";
	}
	
	
	
	
}

