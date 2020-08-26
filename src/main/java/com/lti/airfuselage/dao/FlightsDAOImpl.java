package com.lti.airfuselage.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airfuselage.dto.SearchParameters;
import com.lti.airfuselage.model.Flights;


@Component("flightChart")
public class FlightsDAOImpl implements FlightsDAO 
{
	
	@PersistenceContext	//@Autowired does not work for injecting EntityManager
	private EntityManager entityManager;


	
	@Override
	@Transactional
	public void addNewFlight(Flights fl) {
		entityManager.persist(fl);
		
	}

	
	@Override
	public List<Flights> getEconomySearchResult(SearchParameters sp) {
		
		String queryString = "select f from Flights f where f.economySeatsLeft>= :n1 "
				+ "and to_char(trunc(f.departureSchedule))= :dt1 and f.source= :s1 and f.destination= :d1 and f.status='running' ";
		//select * from flight_chart 
		//where economyseatsleft>=3 
		//and trunc(DEPARTURESCHEDULE)='20-SEP-20' and source='Lucknow' and destination='Mumbai';
		
		System.out.println(sp.getDateOfFlight());
		SimpleDateFormat form=new SimpleDateFormat("dd-MMM-yy");
		System.out.println(form.format(sp.getDateOfFlight()).toUpperCase());//20-Sep-20-->20-SEP-20
		
		List<Flights> itemsList=entityManager.createQuery(queryString)
				.setParameter("n1",sp.getNumberOfPassengers())
				.setParameter("dt1", form.format(sp.getDateOfFlight()).toUpperCase())
				.setParameter("s1",sp.getSource() ).setParameter("d1", sp.getDestination()).getResultList();
		return itemsList;
	}

	
	@Override
	public List<Flights> getBusinessSearchResult(SearchParameters sp) {
		String queryString = "select f from Flights f where f.businessSeatsLeft>= :n1 "
				+ "and to_char(trunc(f.departureSchedule))= :dt1 and f.source= :s1 and f.destination= :d1 and f.status='running' ";
		//select * from flight_chart 
		//where economyseatsleft>=3 
		//and trunc(DEPARTURESCHEDULE)='20-SEP-20' and source='Lucknow' and destination='Mumbai';
		
		System.out.println(sp.getDateOfFlight());
		SimpleDateFormat form=new SimpleDateFormat("dd-MMM-yy");
		System.out.println(form.format(sp.getDateOfFlight()).toUpperCase());
		
		List<Flights> itemsList=entityManager.createQuery(queryString)
				.setParameter("n1",sp.getNumberOfPassengers())
				.setParameter("dt1", form.format(sp.getDateOfFlight()).toUpperCase())
				.setParameter("s1",sp.getSource() ).setParameter("d1", sp.getDestination()).getResultList();
		return itemsList;
	}

	@Override
	public List<Flights> getAllFlights() {
		
		Query q=entityManager.createQuery("select f from Flights f");
		List<Flights> li=q.getResultList();
		return li;
	}


	@Override
	public List<String> getCabinType(int flightId) {
		String query="select f.cabin from Flights f where f.flightId= :f1";
		List<String> cabin=entityManager.createQuery(query).setParameter("f1", flightId).getResultList();
		return cabin;
	}




}
