package de.nak.cars.service;

import java.util.List;

import de.nak.cars.model.AdmonitionProcess;

/**
 * Admonition process service interface.
 * 
 * @author Christian Leppelt
 */
public interface AdmonitionProcessService {

	/**
	 * Creates or updates a admonitionProcess.
	 * 
	 * @param admonitionProcess
	 *            The admonitionProcess.
	 */
	void saveAdmonitionProcess(AdmonitionProcess admonitionProcess);

	/**
	 * Loads a single admonitionProcess.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a admonitionProcess or null.
	 */
	AdmonitionProcess loadAdmonitionProcess(Long id);

	/**
	 * Deletes the given admonitionProcess.
	 * 
	 * @param admonitionProcess
	 *            The admonitionProcess.
	 */
	void deleteAdmonitionProcess(AdmonitionProcess admonitionProcess);

	/**
	 * Loads a list of all admonitionProcesss.
	 * 
	 * @return a list which is empty if no admonitionProcess was found.
	 */
	List<AdmonitionProcess> loadAllAdmonitionProcesss();

}
