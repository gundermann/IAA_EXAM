package de.nak.cars.service;

import java.util.List;

import de.nak.cars.model.PublicationType;

public interface PublicationTypeService {

	/**
	 * Creates or updates a publication type.
	 * 
	 * @param publicationtype
	 *            The publication type.
	 */
	void savePublicationType(PublicationType publicationType);

	/**
	 * Loads a single publication type.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a publication type or null.
	 */
	PublicationType loadPublicationType(Long id);

	/**
	 * Deletes the given publication type.
	 * 
	 * @param publicationtype
	 *            The publication type.
	 */
	void deletePublicationType(PublicationType publicationType);

	/**
	 * Loads a list of all publication types.
	 * 
	 * @return a list which is empty if no publication type was found.
	 */
	List<PublicationType> loadAllPublicationTypes();

}
