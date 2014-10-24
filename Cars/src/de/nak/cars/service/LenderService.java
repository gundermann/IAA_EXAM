package de.nak.cars.service;

import java.util.List;

import de.nak.cars.model.Lender;

/**
 * Lender service interface.
 * 
 * @author Christian Leppelt
 */
public interface LenderService {

	/**
	 * Creates or updates a lender.
	 * 
	 * @param lender
	 *            The lender.
	 */
	void saveLender(Lender lender);

	/**
	 * Loads a single lender.
	 * 
	 * @param matrikelnumber
	 *            The identifier.
	 * @return a lender or null.
	 */
	Lender loadLender(Long matrikelnumber);

	/**
	 * Deletes the given lender.
	 * 
	 * @param lender
	 *            The lender.
	 */
	void deleteLender(Lender lender);

	/**
	 * Loads a list of all lenders.
	 * 
	 * @return a list which is empty if no lender was found.
	 */
	List<Lender> loadAllLenders();

}
