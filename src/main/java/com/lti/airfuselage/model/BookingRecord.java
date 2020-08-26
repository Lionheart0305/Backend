package com.lti.airfuselage.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="booking_record")
public class BookingRecord {

	@Id
	@GeneratedValue
	private int pnr;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Kolkata")
	private Date dateOfBooking;
	
	private int flightId;
	
	private long userId;
	
	private int bookingAmount;
	
	private int refundAmount;

	@OneToMany(cascade = CascadeType.ALL)
	private List<CustomerBookingRecord> customers;
	
	public BookingRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public BookingRecord(Date dateOfBooking, int flightId, long userId, int bookingAmount, int refundAmount) {
		super();
		this.dateOfBooking = dateOfBooking;
		this.flightId = flightId;
		this.userId = userId;
		this.bookingAmount = bookingAmount;
		this.refundAmount = refundAmount;
	}



	public List<CustomerBookingRecord> getCustomers() {
		return customers;
	}



	public void setCustomers(List<CustomerBookingRecord> customers) {
		this.customers = customers;
	}



	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(int bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	public int getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}
	
	
	
}

