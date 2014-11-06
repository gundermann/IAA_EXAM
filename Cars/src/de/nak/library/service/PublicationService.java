package de.nak.library.service;

import java.util.List;

import de.nak.library.model.Author;
import de.nak.library.model.Keyword;
import de.nak.library.model.Publication;
import de.nak.library.searchModel.SearchPublication;

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
	 * @param publication
	 * @return a list which is empty if no publication was found.
	 */
	List<Publication> searchPublications(SearchPublication publication);

	/**
	 * Search a publication.
	 * 
	 * @param isbn
	 *            The isbn you search for.
	 * @return a List containing one publication. The List is empty if no
	 *         publication was found.
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

	/**
	 * Changes the publisher of a given publication.
	 * 
	 * @param publication
	 *            The publication to change.
	 * @param publisherId
	 *            The data base id of the new publisher.
	 */
	void editPublisher(Publication publication, Long publisherId);

	/**
	 * Changes the publication type of a given publication.
	 * 
	 * @param publication
	 *            The publication to change.
	 * @param publisherId
	 *            The data base id of the new publication type.
	 */
	void editPublicationType(Publication publication, Long publicationTypeId);

	/**
	 * Adds the keywords behind the IDs in a given list to a given publication.
	 * 
	 * @param publication
	 *            The publication to change.
	 * @param keywordIds
	 *            The data base id of the new keywords.
	 */
	void addKeywords(Publication publication, Long[] keywordIds);

	/**
	 * Removes the keywords behind the IDs in a given list from a given
	 * publication.
	 * 
	 * @param publication
	 *            The publication to change.
	 * @param keywordIds
	 *            The data base id of the new keywords.
	 */
	void deleteKeywords(Publication publication, Long[] keywordIds);

	/**
	 * Adds the authors behind the IDs in a given list to a given publication.
	 * 
	 * @param publication
	 *            The publication to change.
	 * @param keywordId
	 *            The data base id of the new authors.
	 */
	void addAuthors(Publication publication, Long[] authorIds);

	/**
	 * Removes the authors behind the IDs in a given list from a given
	 * publication.
	 * 
	 * @param publication
	 *            The publication to change.
	 * @param keywordId
	 *            The data base id of the new authors.
	 */
	void deleteAuthors(Publication publication, Long[] authorIds);

	/**
	 * Loads all the authors not attached to the given publication.
	 * 
	 * @param publicationId
	 *            The data base id of the publication.
	 * @return list which is empty if no author was found.
	 */
	List<Author> loadAllAuthorNotInPublication(Long publicationId);

	/**
	 * Loads all the keywords not attached to the given publication.
	 * 
	 * @param publicationId
	 *            The data base id of the publication.
	 * @return list which is empty if no keyword was found.
	 */
	List<Keyword> loadAllKeywordsNotInPublication(Long publicationId);

}
