package de.nak.library.service;

import de.nak.library.model.AdmonitionProcess;

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
	 * Deletes the given admonition process and every attached admonition.
	 * 
	 * @param admonitionProcess
	 *            The admonition process.
	 */
	void deleteAdmonitionProcess(AdmonitionProcess admonitionProcess);

	/**
	 * Creates an admonition process.
	 * 
	 * @return the created admonition process.
	 */
	AdmonitionProcess createAdmonitionProcess();

	/**
	 * Adds an admonition with the current time to the given admonition process.
	 * 
	 * @param admonitionProcess
	 *            The admonition process.
	 * @return the admonition process with the added admonition.
	 */
	AdmonitionProcess addAdmonition(AdmonitionProcess admonitionProcess);

}
