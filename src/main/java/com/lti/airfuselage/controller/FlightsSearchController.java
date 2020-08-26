package com.lti.airfuselage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airfuselage.dto.AvailableSeatsListClass;
import com.lti.airfuselage.dto.SearchParameters;
import com.lti.airfuselage.dto.SeatParameters;
import com.lti.airfuselage.model.Flights;
import com.lti.airfuselage.service.BookingAndSeatSelectionService;
import com.lti.airfuselage.service.FlightsSearchService;

@RestController
@CrossOrigin
public class FlightsSearchController {
	
	@Autowired
	private BookingAndSeatSelectionService basss;
	
	@Autowired
	private FlightsSearchService fss;
	
	@RequestMapping(path = "/fetchFlights.api", method = RequestMethod.GET , produces = "application/json")
	public List<Flights> getAllFLights()
	{
		List<Flights> itemsList=fss.allFlights();
		return itemsList;
	}
	
	@RequestMapping(path = "/getFlights.api", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<Flights> getSearchFLights(@RequestBody SearchParameters sp)
	{
		List<Flights> itemsList=fss.getSearchResult(sp);
		return itemsList;
	}

	@RequestMapping(path = "/addflight.api", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Status Flights(@RequestBody Flights fl) {
		Status status = new Status();
		fss.addNewFlight(fl);
		status.setStatus("Row added successfully");
		return status;
	}
	
	@RequestMapping(path = "/availableseats.api", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public AvailableSeatsListClass availableSeats(@RequestBody SeatParameters sp)
	{
		return basss.getAvailableSeatsList(sp);
	}
	
	
	
	public static class Status {
		private String status;
		
		public String getStatus() {
			return status;
		}
		
		public void setStatus(String status) {
			this.status = status;
		}
}
}
