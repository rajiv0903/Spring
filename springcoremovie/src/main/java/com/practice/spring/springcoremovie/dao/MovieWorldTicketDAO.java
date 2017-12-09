package com.practice.spring.springcoremovie.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.practice.spring.springcoremovie.exception.MovieWorldException;
import com.practice.spring.springcoremovie.vo.TicketVO;

public class MovieWorldTicketDAO {

	/*private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

	public void saveReservationDetails(final TicketVO ticketVO) throws MovieWorldException {

		/*try {*/
		String queryBookedTicket = "insert into booked_ticket (movieCode, ticketClass, "
				+ "numberOfSeats, date, time) values (?,?,?,?,?)";
		
		int availableSeats = getAvailableSeats(ticketVO);
		
		/*if(availableSeats <= Integer.parseInt(ticketVO.getNumberOfSeats())) {
			throw new RuntimeException("Requested number of seats is not available");
		}*/
		if(availableSeats < 0) {
			throw new RuntimeException("Requested number of seats is not available");
		}

		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(queryBookedTicket, new Object[] { 
				ticketVO.getMovieCode(), ticketVO.getTicketClass(),
				ticketVO.getNumberOfSeats(), ticketVO.getDate(), ticketVO.getTime() });
		/*}
		catch(Exception exe) {
			System.err.println("::::::::::::::::::::::::::::::::::::::::");
			throw new MovieWorldException(exe.getMessage());
		}*/
	}

	public void updateAvailableSeats(final TicketVO ticketVO) throws MovieWorldException {

		String queryAvailableTicket = "update available_ticket set numberOfSeats =? where movieCode=? and  ticketClass =? "
				+ " and date=? and time=?";
		
		int availableSeats = getAvailableSeats(ticketVO);
		
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(queryAvailableTicket, new Object[] { 
				(availableSeats- Integer.parseInt(ticketVO.getNumberOfSeats())),
				ticketVO.getMovieCode(), ticketVO.getTicketClass(),
						ticketVO.getDate(), ticketVO.getTime() });

	}
	
	private int getAvailableSeats(final TicketVO ticketVO) throws MovieWorldException {
		
		  String sql = "SELECT numberOfSeats FROM available_ticket WHERE movieCode = ? and "
		  		+ " ticketClass=? and date=? and time=?";
		  
		  //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		  int count = jdbcTemplate.queryForObject(
		                          sql, new Object[] { 
		                        		  ticketVO.getMovieCode(),
		                        		  ticketVO.getTicketClass(),
		                        		  ticketVO.getDate(),
		                        		  ticketVO.getTime()
		                        		  }, Integer.class);
		  return count;
	}

}
