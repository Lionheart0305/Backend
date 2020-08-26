package com.lti.airfuselage.service;

import java.util.List;

import com.lti.airfuselage.dto.SearchParameters;
import com.lti.airfuselage.model.Flights;

public interface FlightsSearchService {

	public List<Flights> allFlights();
	
	public List<Flights> getSearchResult(SearchParameters sp);
	
	public void addNewFlight(Flights fl);
}
