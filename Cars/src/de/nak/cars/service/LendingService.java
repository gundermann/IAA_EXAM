package de.nak.cars.service;

import java.util.List;

import de.nak.cars.model.Lending;

/**
 * Lending service interface.
 * 
 * @author Christian Leppelt
 */
public interface LendingService {

	/**
	 * Creates or updates a lending.
	 * 
	 * @param lending
	 *            The lending.
	 */
	void saveLending(Lending lending);

	/**
	 * Loads a single lending.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a lending or null.
	 */
	Lending loadLending(Long id);

	/**
	 * Deletes the given lending.
	 * 
	 * @param lending
	 *            The lending.
	 */
	void deleteLending(Lending lending);

	/**
	 * Loads a list of all lendings.
	 * 
	 * @return a list which is empty if no lending was found.
	 */
	List<Lending> loadAllLendings();

	/**
	 * Search all lendings with a return delay.
	 * 
	 * @return a list which is empty if no lending was found.
	 */
	List<Lending> loadDelayedLendings();

	/**
	 * Recalculates and sets the return date for the given lending.
	 * 
	 * @param lending
	 *            The lending.
	 */
	void adjustReturnDate(Lending lending);

}
