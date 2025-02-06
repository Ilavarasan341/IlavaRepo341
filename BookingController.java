package com.express.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.express.modelDTO.BookingDTO;
import com.express.service.BookingService;

@CrossOrigin
@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
		
		@PostMapping("/create/booking/{showId}/{CustomerId}")
		public Object createBooking(@PathVariable int showId, @PathVariable int CustomerId, @RequestBody BookingDTO bookingDTO) {
			return(bookingService.createBooking(showId,CustomerId,bookingDTO));
		}
		
		//ticket status API
		@GetMapping("/custombooking/{id}")
		public Object ticketStatus(@PathVariable int id) {
			return (bookingService.ticketStatusById(id));
			
		}
		// reservation confirmation ;
		@GetMapping("/booking/{id}")
		public Object reservation(@PathVariable int id) {
			return (bookingService.reservation(id));
		}
		

		@GetMapping("allBookings")
		public Object getAllBookings() {
			return bookingService.getAllBookings();
		}	
}
