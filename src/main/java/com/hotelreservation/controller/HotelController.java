package com.hotelreservation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotelreservation.model.ConfirmationNumber;
import com.hotelreservation.model.HotelDetails;
import com.hotelreservation.model.ReservationDetails;

@RestController
public class HotelController {

	@RequestMapping("/getHotelList")
	public List<HotelDetails> getListOfHotels()
	{
		return  getHotelsList();
	}
	
	@RequestMapping(value = "/reservationConfirmation", method=RequestMethod.POST,consumes="application/json")
	public ConfirmationNumber reserveHotel(@RequestBody ReservationDetails reservationDetails)
	{
		Random rand = new Random(); //instance of random class
	    int upperbound = 125;
	        //generate random values from 0-24
	    int int_random = rand.nextInt(upperbound); 
	    String reservationNumber = String.valueOf(int_random);
	    ConfirmationNumber number = new ConfirmationNumber();
	    
	    number.setReservationNumber(reservationNumber);
	   
	    
		return number;
		
	}
	
	public List<HotelDetails> getHotelsList()
	{
		List<HotelDetails> hotelsList = new ArrayList<HotelDetails>();
		try 
		{
			/*
			HotelDetails hotelDetails1 = new HotelDetails("Holiday Inn",100,true);
			HotelDetails hotelDetails2 = new HotelDetails("Marriot",100,true);
			HotelDetails hotelDetails3 = new HotelDetails("Comfort Inn",100,true);
			HotelDetails hotelDetails4 = new HotelDetails("Crowne Plaza",100,true);
			*/
			List<String> hotelNames = Arrays.asList("Holiday Inn","Marriot","Comfort Inn","Crowne Plaza");
			Random random = new Random();
			for(int i=0; i<hotelNames.size();i++)
			{
				HotelDetails hotelDetails = new HotelDetails("Holiday Inn",100,true);
				
				hotelDetails.setHotel_name(hotelNames.get(i));
				hotelDetails.setAvailability(true);
				int randomPrice = random.nextInt(200 + 50 +1) +50 ;
				hotelDetails.setPrice(randomPrice);
				hotelsList.add(hotelDetails);
				
			}
			
			/*
			hotelsList.add(hotelDetails3);
			hotelsList.add(hotelDetails1);
			hotelsList.add(hotelDetails2);
			hotelsList.add(hotelDetails4);
			*/
		}
		catch(Exception ex)
		{
			System.out.print(ex);
		}
		return hotelsList;
	}
}
