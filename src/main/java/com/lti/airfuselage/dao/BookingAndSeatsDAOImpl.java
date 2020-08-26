package com.lti.airfuselage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airfuselage.dto.SeatParameters;
import com.lti.airfuselage.model.BookingRecord;

@Component("bookingRecord")
public class BookingAndSeatsDAOImpl implements BookingAndSeatsDAO{

	@PersistenceContext	//@Autowired does not work for injecting EntityManager
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void booking(BookingRecord records) {
		entityManager.persist(records);
		
	}

	@Override
	public List<Integer> bookedSeatsList(SeatParameters sp) {
		String query="select c.seatNumber from CustomerBookingRecord c "
				+ "where c.bookingPnr.pnr IN (select b.pnr from BookingRecord b where "
				+ "b.flightId= :f1) and c.status='booked'";
		//select seatnumber from customerbookingrecord
		//where pnr IN (select pnr from booking_record where flightid=1) and status='booked';

		List<Integer> li=entityManager.createQuery(query).setParameter("f1", sp.getFlightNumber()).getResultList();
		
		return li;
	}

}
