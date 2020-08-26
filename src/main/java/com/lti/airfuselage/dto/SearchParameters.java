package com.lti.airfuselage.dto;

import java.util.Date;

public class SearchParameters {

	private int numberOfPassengers;
	private Date dateOfFlight;
	private String source;
	private String destination;
	private String cabinSelected;
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	public Date getDateOfFlight() {
		return dateOfFlight;
	}
	public void setDateOfFlight(Date dateOfFlight) {
		this.dateOfFlight = dateOfFlight;
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
	public String getCabinSelected() {
		return cabinSelected;
	}
	public void setCabinSelected(String cabinSelected) {
		this.cabinSelected = cabinSelected;
	}

	
}

