package com.lti.airfuselage.dao;

import java.util.List;

import com.lti.airfuselage.dto.SearchParameters;
import com.lti.airfuselage.model.Flights;

public interface FlightsDAO {

	public void addNewFlight(Flights fl);

	public List<Flights> getEconomySearchResult(SearchParameters sp);
	
	public List<Flights> getBusinessSearchResult(SearchParameters sp);

	public List<Flights> getAllFlights();
	
	public List<String> getCabinType(int flightId);

}