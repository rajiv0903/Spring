package com.practice.spring.springcoremovie.facade;

import java.text.SimpleDateFormat;

import com.practice.spring.springcoremovie.bo.MovieWorldTicketBO;
import com.practice.spring.springcoremovie.exception.MovieWorldException;
import com.practice.spring.springcoremovie.vo.TicketVO;

public class MovieWorldTicketFacade {

	private MovieWorldTicketBO movieWorldTicketBO;

	public MovieWorldTicketFacade(MovieWorldTicketBO movieWorldTicketBO) {
		this.movieWorldTicketBO = movieWorldTicketBO;
	}

	public int reserveSeats(String movieCode, String ticketClass,
			String numberOfSeats, String date, String time)
			throws MovieWorldException {
		
		TicketVO ticketVO;
		
		try {
			ticketVO = new TicketVO();
			ticketVO.setMovieCode(movieCode);
			ticketVO.setTicketClass(ticketClass);
			ticketVO.setNumberOfSeats(numberOfSeats);
			ticketVO.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
			ticketVO.setTime(time);
		}
		catch(Exception exe) {
			throw new MovieWorldException("Exception Occur", exe);
		}
		
		return movieWorldTicketBO.reserveSeats(ticketVO);
		
	}

}
