package de.nak.library.service;

import de.nak.library.model.Admonition;

/**
 * Admonition service interface.
 * 
 * @author Christian Leppelt
 */
public interface AdmonitionService {

	/**
	 * Creates or updates a admonition.
	 * 
	 * @param admonition
	 *            The admonition.
	 */
	void saveAdmonition(Admonition admonition);

	/**
	 * Deletes the given admonition.
	 * 
	 * @param admonition
	 *            The admonition.
	 */
	void deleteAdmonition(Admonition admonition);

}
