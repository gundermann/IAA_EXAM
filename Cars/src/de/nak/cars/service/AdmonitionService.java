package de.nak.cars.service;

import java.util.List;

import de.nak.cars.model.Admonition;

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
	 * Loads a single admonition.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a admonition or null.
	 */
	Admonition loadAdmonition(Long id);

	/**
	 * Deletes the given admonition.
	 * 
	 * @param admonition
	 *            The admonition.
	 */
	void deleteAdmonition(Admonition admonition);

	/**
	 * Loads a list of all admonitions.
	 * 
	 * @return a list which is empty if no admonition was found.
	 */
	List<Admonition> loadAllAdmonitions();

}
