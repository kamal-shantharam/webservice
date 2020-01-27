package com.trainings.restinjection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.trainings.restinjection.model.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {

	List<Passenger> passengers = new ArrayList<>();
	int currentId = 123;

	public List<Passenger> getPassengers(int start, int size) {
		System.out.println(start);
		System.out.println(size);
		return passengers;
	}
	
//	public void addPassenger(Passenger passenger) {
//		Passenger newPassenger = new Passenger();
//		newPassenger.setId(currentId++);
//		newPassenger.setName(passenger.getName());
//		passengers.add(newPassenger);
//	}

	public void addPassenger(String firstName, String lastName, String agent, HttpHeaders headers) {
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(agent);
		
		MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
		Set<String> keySet = requestHeaders.keySet();
		for (String key : keySet) {
			System.out.println(key);
			System.out.println(headers.getHeaderString(key));
		}
		
		System.out.println("-------Cookies---------");
		
		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> cookiesKeySet = cookies.keySet();
		for(String key : cookiesKeySet) {
			System.out.println(key);
			System.out.println(cookies.get(key).getValue());
		}
		
	}

}
