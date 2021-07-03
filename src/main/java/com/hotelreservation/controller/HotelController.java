package com.hotelreservation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public String reserveHotel(@RequestBody ReservationDetails reservationDetails)
	{
		return reservationDetails.getHotel_name();
		
	}
	
	public List<HotelDetails> getHotelsList()
	{
		List<HotelDetails> hotelsList = new ArrayList<HotelDetails>();
		try 
		{
			
			List<String> hotelNames = Arrays.asList("Holiday Inn","Marriot","Comfort Inn","Crowne Plaza");
			Random random = new Random();
			for(int i=0; i<hotelNames.size();i++)
			{
				HotelDetails hotelDetails = new HotelDetails();
				hotelDetails.setHotel_name(hotelNames.get(i));
				hotelDetails.setAvailability(true);
				int randomPrice = random.nextInt(200 + 50 +1) +50 ;
				hotelDetails.setPrice(randomPrice);
				hotelsList.add(hotelDetails);			
			}			
		}
		catch(Exception ex)
		{
			System.out.print(ex);
		}
		return hotelsList;
	}
}
