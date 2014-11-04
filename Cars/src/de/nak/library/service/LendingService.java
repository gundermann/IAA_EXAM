package de.nak.library.service;

import java.util.List;

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
	 * Search all lendings which belong to a publication.
	 * 
	 * @return a list which is empty if no lending was found.
	 */
	List<Lending> searchByPublication(Publication publication);

	/**
	 * Recalculates and sets the return date for a given lending.
	 * 
	 * @param lending
	 *            The lending.
	 */
	void adjustReturnDate(Lending lending);

	/**
	 * Tells whether an admonition process exists for a given lending.
	 * 
	 * @param lending
	 *            The lending.
	 */
	boolean hasAdmonitionProcess(Lending lending);

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
	 * Search all publications without a lending.
	 * 
	 * @return a list which is empty if no publication was found.
	 */
	List<Publication> loadAllAvailablePublications();

	void finishLendingByReturn(Lending lending);

	void finishLendingByLoss(Lending lending);
}