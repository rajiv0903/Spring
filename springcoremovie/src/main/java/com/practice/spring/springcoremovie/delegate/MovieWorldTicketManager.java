package com.practice.spring.springcoremovie.delegate;

import com.practice.spring.springcoremovie.exception.MovieWorldException;
import com.practice.spring.springcoremovie.facade.MovieWorldTicketFacade;

public class MovieWorldTicketManager {
	
	private MovieWorldTicketFacade movieWorldTicketFacade;
	
	public MovieWorldTicketManager(MovieWorldTicketFacade movieWorldTicketFacade) {
		this.movieWorldTicketFacade = movieWorldTicketFacade;
	}
	
	public int reserveSeats(String movieCode, String ticketClass,
			String numberOfSeats, String date, String time)
			throws MovieWorldException {
		
		return movieWorldTicketFacade.reserveSeats(movieCode, ticketClass, numberOfSeats, date, time);
	}

}
