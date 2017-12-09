package com.practice.spring.springcoremovie.bo;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.practice.spring.springcoremovie.dao.MovieWorldTicketDAO;
import com.practice.spring.springcoremovie.exception.MovieWorldException;
import com.practice.spring.springcoremovie.vo.TicketVO;

public class MovieWorldTicketBO {

	private MovieWorldTicketDAO movieWorldTicketDAO;

	private PlatformTransactionManager transactionManager;

	public MovieWorldTicketBO(MovieWorldTicketDAO movieWorldTicketDAO) {
		this.movieWorldTicketDAO = movieWorldTicketDAO;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	/**
	 *  					Dirty Reads	Non-Repeatable Reads Phantom Reads
	 *  READ_UNCOMMITTED		yes			yes					yes
	 *  READ_COMMITTED			no			yes					yes
	 *  REPEATABLE_READ			no			no					yes
	 *  SERIALIZABLE			no			no					no
	 */
/*	@Transactional(isolation=Isolation.SERIALIZABLE)
	public int reserveSeats(TicketVO ticketVO) throws MovieWorldException {

		int count = 0;
		movieWorldTicketDAO.updateAvailableSeats(ticketVO);
		movieWorldTicketDAO.saveReservationDetails(ticketVO);
		count = 1;
		return count;
	}*/
	
	public int reserveSeats(TicketVO ticketVO) throws MovieWorldException {

		int count = 0;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			movieWorldTicketDAO.updateAvailableSeats(ticketVO);
			movieWorldTicketDAO.saveReservationDetails(ticketVO);
			transactionManager.commit(status);

		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(status);
			throw e;
		} catch (MovieWorldException e) {
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(status);
			throw e;
		} catch (Exception e) {
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(status);
			throw e;
		}
		count = 1;
		return count;
	}

}
