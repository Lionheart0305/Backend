package com.lti.airfuselage;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.airfuselage.dao.BookingAndSeatsDAO;
import com.lti.airfuselage.dao.FlightsDAO;
import com.lti.airfuselage.dao.UserRepository;
import com.lti.airfuselage.dto.SearchParameters;
import com.lti.airfuselage.dto.SeatParameters;
import com.lti.airfuselage.model.BookingRecord;
import com.lti.airfuselage.model.CustomerBookingRecord;
import com.lti.airfuselage.model.Flights;
import com.lti.airfuselage.model.SystemAdmin;
import com.lti.airfuselage.model.User;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class AirFuselageApplicationTests {

	@Autowired
	private FlightsDAO fdi;
	
	@Autowired
	private BookingAndSeatsDAO basd;
	
	@Autowired
	private UserRepository userRepo;
	
	
	
	@Test
	void contextLoads() throws ParseException {
		
		SearchParameters sp=new SearchParameters();
		sp.setCabinSelected("economy");
		sp.setSource("Mumbai");
		sp.setDestination("Pune");
		sp.setNumberOfPassengers(3);
		sp.setDateOfFlight((new SimpleDateFormat("yy-MM-dd")).parse("20-10-20"));
		List<Flights> li=fdi.getEconomySearchResult(sp);
		for(Flights fl:li)
		{
			System.out.println(fl);
		}
	}
	
	@Test
	void testForBookingImpl()
	{
		BookingRecord bd=new BookingRecord(new Date(),22,9648557255L,10000,0);
		List<CustomerBookingRecord> li=new ArrayList<CustomerBookingRecord>();
		li.add(new CustomerBookingRecord("Shivam",23,"adult",6,4000,"booked",bd));
		li.add(new CustomerBookingRecord("Angel",22,"adult",7,4000,"booked",bd));
		li.add(new CustomerBookingRecord("Arunima",24,"adult",10,4000,"booked",bd));
		
		bd.setCustomers(li);
		
		basd.booking(bd);
	}
	
	@Test
	void testForSeatsBooked()
	{
		SeatParameters sp=new SeatParameters();
		sp.setFlightNumber(22);
		List<Integer> li=basd.bookedSeatsList(sp);
		for(int x: li)
		{
			System.out.println(x);
		}
			
	}

	@Test
	void cabinTypeByFlightID()
	{
		//ArrayList<String> li=(ArrayList<String>) fdi.getCabinType(22);
		//List<String> li=fdi.getCabinType(22);
		String type=fdi.getCabinType(22).get(0);
		System.out.println(type);
			
	}
	
	@Test
	void add() {
		Flights f=new Flights();
		f.setFlightNumber("1");
		f.setSource("Mumbai");
		f.setDestination("Pune");
		f.setDuration(1.30);
		f.setDepartureSchedule(Timestamp.from(Instant.parse("2020-10-20T17:10:10Z")));
		f.setArrivalSchedule(Timestamp.from(Instant.parse("2020-10-20T18:10:10Z")));
		f.setCabin("Economy");
		f.setStatus("running");
		f.setInitialEconomyfare(1200);
		f.setInitialBusinessfare(0);
		f.setEconomySeatsLeft(60);
		f.setBusinessSeatsLeft(0);
		
		fdi.addNewFlight(f);
		System.out.println(f);
	}
	
	@Test
	void addAdmin() {
		SystemAdmin admin = new SystemAdmin();
		admin.setFirstName("Admin");
		admin.setLastName("Singh");
		admin.setEmail("admin@lti");
		admin.setPassword("Admin");
		admin.setDateOfBirth(LocalDate.of(1990, 11, 20));
		admin.setMobileNumber("9758830865");

		userRepo.addAdmin(admin);
	}
	
	@Test
	void register() {

		User u = new User();
		u.setFirstName("Sam");
		u.setLastName("Munro");
		u.setEmail("sam@lti");
		u.setPassword("12345");
		u.setDateOfBirth(LocalDate.of(1999, 10, 20));
		u.setMobileNumber("78451865655");

		userRepo.add(u);

	}


}
