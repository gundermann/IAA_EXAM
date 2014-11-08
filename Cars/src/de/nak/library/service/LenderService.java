package de.nak.library.service;

import java.util.List;

import de.nak.library.model.Lender;

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
	 * @param lenderId
	 *            The identifier.
	 * @return a lender or null.
	 */
	Lender loadLender(Long lenderId);

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

	/**
	 * Searches a lender belonging to a given matriculation number.
	 * 
	 * @param matriculationNumber
	 *            The matriculation number.
	 * @return a lender or null.
	 */
	Lender searchLenderByMatriculationNumber(Integer matriculationNumber);

}
