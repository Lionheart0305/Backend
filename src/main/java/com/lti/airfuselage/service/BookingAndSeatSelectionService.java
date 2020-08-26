package com.lti.airfuselage.service;

import com.lti.airfuselage.dto.AvailableSeatsListClass;
import com.lti.airfuselage.dto.SeatParameters;

public interface BookingAndSeatSelectionService {

	public AvailableSeatsListClass getAvailableSeatsList(SeatParameters sp);
}
