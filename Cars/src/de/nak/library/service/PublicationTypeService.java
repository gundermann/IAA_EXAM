package de.nak.library.service;

import java.util.List;

import de.nak.library.model.PublicationType;

/**
 * Publication type service interface.
 * 
 * @author Christian Leppelt
 */
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

	/**
	 * Searches for a publication type by a given name.
	 * 
	 * @param typeName
	 *            The publication type name.
	 * @return a publication type. Returns null if no publication type was
	 *         found.
	 */
	PublicationType searchByName(String typeName);

}
