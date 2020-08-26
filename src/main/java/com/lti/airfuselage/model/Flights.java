package com.lti.airfuselage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="flight_chart")
public class Flights {

	@Id
	@SequenceGenerator(name = "seq_fl", allocationSize = 1, initialValue = 20201)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fl")
	private int flightId;
	
	@Column(length = 10)
	private String flightNumber;//i
	@Column(length = 15)
	private String source;//i
	@Column(length = 15)
	private String destination;//i
	
	private double duration;//i
	
	
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Kolkata")
	private Date departureSchedule;//i//DateTime hint

	
	//to be used while testing using Postman
	// "depart": "2019-05-14T11:48:42.457",
	 // "arrive" : "2019-05-14T15:48:42.457"
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Kolkata")
	private Date arrivalSchedule;//i
	
	@Column(length = 10)
	private String cabin;//i----e-----b
	
	@Column(length = 10)
	private String status;//running
	private int initialEconomyfare;//i
	private int initialBusinessfare;//0---i
	private int economySeatsLeft;//60---40
	private int businessSeatsLeft;//0---20
	
	
	
	public Flights() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public Date getDepartureSchedule() {
		return departureSchedule;
	}
	public void setDepartureSchedule(Date departureSchedule) {
		this.departureSchedule = departureSchedule;
	}
	public Date getArrivalSchedule() {
		return arrivalSchedule;
	}
	public void setArrivalSchedule(Date arrivalSchedule) {
		this.arrivalSchedule = arrivalSchedule;
	}
	public String getCabin() {
		return cabin;
	}
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getInitialEconomyfare() {
		return initialEconomyfare;
	}
	public void setInitialEconomyfare(int initialEconomyfare) {
		this.initialEconomyfare = initialEconomyfare;
	}
	public int getInitialBusinessfare() {
		return initialBusinessfare;
	}
	public void setInitialBusinessfare(int initialBusinessfare) {
		this.initialBusinessfare = initialBusinessfare;
	}
	public int getEconomySeatsLeft() {
		return economySeatsLeft;
	}
	public void setEconomySeatsLeft(int economySeatsLeft) {
		this.economySeatsLeft = economySeatsLeft;
	}
	public int getBusinessSeatsLeft() {
		return businessSeatsLeft;
	}
	public void setBusinessSeatsLeft(int businessSeatsLeft) {
		this.businessSeatsLeft = businessSeatsLeft;
	}
	@Override
	public String toString() {
		return "Flights [flightId=" + flightId + ", flightNumber=" + flightNumber + ", source=" + source
				+ ", destination=" + destination + ", duration=" + duration + ", departureSchedule=" + departureSchedule
				+ ", arrivalSchedule=" + arrivalSchedule + ", cabin=" + cabin + ", status=" + status
				+ ", initialEconomyfare=" + initialEconomyfare + ", initialBusinessfare=" + initialBusinessfare
				+ ", economySeatsLeft=" + economySeatsLeft + ", businessSeatsLeft=" + businessSeatsLeft + "]";
	}
	
	
	
}
