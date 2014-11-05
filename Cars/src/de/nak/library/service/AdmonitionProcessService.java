package de.nak.library.service;

import java.util.List;

import de.nak.library.model.AdmonitionProcess;
import de.nak.library.model.Lending;

/**
 * Admonition process service interface.
 * 
 * @author Christian Leppelt
 */
public interface AdmonitionProcessService {

	/**
	 * Creates or updates a admonition process.
	 * 
	 * @param admonitionProcess
	 *            The admonition process.
	 */
	void saveAdmonitionProcess(AdmonitionProcess admonitionProcess);

	/**
	 * Loads a single admonition process.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a admonition process or null.
	 */
	AdmonitionProcess loadAdmonitionProcess(Long id);

	/**
	 * Deletes the given admonition process and every attached admonition.
	 * 
	 * @param admonitionProcess
	 *            The admonition process.
	 */
	void deleteAdmonitionProcess(AdmonitionProcess admonitionProcess);

	/**
	 * Loads a list of all admonition process.
	 * 
	 * @return a list which is empty if no admonition process was found.
	 */
	List<AdmonitionProcess> loadAllAdmonitionProcesss();

	/**
	 * Search the admonition process which belongs to a given lending.
	 * 
	 * @param lending
	 *            The given lending to search by.
	 * @return a List containing one admonition process. The List is empty if no
	 *         admonition process was found.
	 */
	List<AdmonitionProcess> searchByLending(Lending lending);

	/**
	 * Adds an admonition with the current time to the given admonition process.
	 * 
	 * @param admonitionProcess
	 *            The admonition process.
	 * @return the admonition process with the added admonition.
	 */
	AdmonitionProcess addAdmonition(AdmonitionProcess admonitionProcess);

	/**
	 * Returns the number of admonitions connected to the admonition process
	 * with a given admonition process id.
	 * 
	 * @param admonitionProcessId
	 *            The data base id of the admonition process.
	 * @return the number of admonitions. Returns null if no admonition process
	 *         was found.
	 */
	Integer countAdmonitions(Long admonitionProcessId);

}
