package de.nak.library.service;

import java.util.Date;
import java.util.List;

import de.nak.library.model.Author;
import de.nak.library.model.Keyword;
import de.nak.library.model.Publication;
import de.nak.library.model.PublicationType;
import de.nak.library.model.Publisher;

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
			Date dateOfPublication, Publisher publisher, PublicationType type,
			List<Keyword> keywords);

	/**
	 * Search a publication.
	 * 
	 * @param isbn
	 *            The isbn you search for.
	 * @return a List containing one publication which is null if no publication
	 *         was found.
	 */
	List<Publication> searchPublicationByIsbn(Long isbn);

	/**
	 * Completes a given publication by adding the attributes which are
	 * connected to other data base objects.
	 * 
	 * @param publication
	 *            The publication to complete.
	 * @param authorIds
	 *            Array containing all the data base ids of the authors.
	 * @param keywordIds
	 *            Array containing all the data base ids of the buzzwords.
	 * @param publicationTypeId
	 *            The data base id of the publication type.
	 * @param publisherId
	 *            The data base id of the publisher.
	 * @return the completed publication.
	 */
	Publication setupPublication(Publication publication, Long[] authorIds,
			Long[] keywordIds, Long publicationTypeId, Long publisherId);

}
