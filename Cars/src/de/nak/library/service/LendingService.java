package de.nak.library.service;

import java.util.List;

import de.nak.library.model.Lender;
import de.nak.library.model.Lending;
import de.nak.library.model.Publication;

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
	List<Lending> searchDelayedLendings();

	/**
	 * Search all lendings which belong to a given publication.
	 * 
	 * @param publication
	 *            The publication.
	 * @return a list which is empty if no lending was found.
	 */
	List<Lending> searchByPublication(Publication publication);

	/**
	 * Search all lendings which belong to a given lender.
	 * 
	 * @param lender
	 *            The lender.
	 * @return a list which is empty if no lending was found.
	 */
	List<Lending> searchByLender(Lender lender);

	/**
	 * Search all publications which can be lend.
	 * 
	 * @return a list which is empty if no publication was found.
	 */
	List<Publication> searchAllAvailablePublications();

	/**
	 * Extends the return date of a given lending by 2 weeks. Adds one extension
	 * to the Lending. Removes the admonition process if there is one.
	 * 
	 * @param lending
	 *            The lending.
	 */
	void extend(Lending lending);

	/**
	 * Initializes a given lending by setting the initial value for every
	 * attribute.
	 * 
	 * @param lending
	 *            The lending to complete.
	 * @param lenderId
	 *            The data base id of the lender.
	 * @param publicationId
	 *            The data base id of the publication.
	 * @return the completed lending.
	 */
	Lending initializeLending(Lending lending, Long lenderId, Long publicationId);

	/**
	 * Deletes a given lending. Reduces the quantity of the publication attached
	 * to the lending.
	 * 
	 * @param lending
	 *            The lending to delete.
	 */
	void finishLendingIfLost(Lending lending);
}
