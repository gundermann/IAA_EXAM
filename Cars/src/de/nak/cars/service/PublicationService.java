package de.nak.cars.service;

import java.util.List;

import de.nak.cars.model.Author;
import de.nak.cars.model.Keyword;
import de.nak.cars.model.Publication;

/**
 * Publication service interface.
 * 
 * @author Christian Leppelt
 */
public interface PublicationService {

	/**
	 * Creates or updates a publication.
	 * 
	 * @param publication
	 *            The publication.
	 */
	void savePublication(Publication publication);

	/**
	 * Loads a single publication.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a publication or null.
	 */
	Publication loadPublication(Long id);

	/**
	 * Deletes the given publication.
	 * 
	 * @param publication
	 *            The publication.
	 */
	void deletePublication(Publication publication);

	/**
	 * Loads a list of all publications.
	 * 
	 * @return a list which is empty if no publication was found.
	 */
	List<Publication> loadAllPublications();

	/**
	 * Search a list of publications.
	 * 
	 * @param title
	 *            The title you search for.
	 * @param authors
	 *            The authors you search for.
	 * @param yearOfPublication
	 *            The year of publication you search for.
	 * @param publisher
	 *            The publisher you search for.
	 * @param type
	 *            The publication type you search for.
	 * @param keywords
	 *            The keywords you search for.
	 * @return a list which is empty if no publication was found.
	 */
	List<Publication> searchPublications(String title, List<Author> authors,
			Integer yearOfPublication, String publisher, String type,
			List<Keyword> keywords);

	/**
	 * Search a publication.
	 * 
	 * @param isbn
	 *            The isbn you search for.
	 * @return a publication which is null if no publication was found.
	 */
	Publication searchPublicationByIsbn(Integer isbn);

}
