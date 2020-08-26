package com.lti.airfuselage.dao;

import java.util.List;

import com.lti.airfuselage.dto.SeatParameters;
import com.lti.airfuselage.model.BookingRecord;

public interface BookingAndSeatsDAO {

	public void booking(BookingRecord records);
	
	public List<Integer> bookedSeatsList(SeatParameters sp);
}
