package de.nak.cars.service;

import java.util.List;

import de.nak.cars.model.Author;

/**
 * Author service interface.
 * 
 * @author Christian Leppelt
 */
public interface AuthorService {

	/**
	 * Creates or updates a author.
	 * 
	 * @param author
	 *            The author.
	 */
	void saveAuthor(Author author);

	/**
	 * Loads a single author.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a author or null.
	 */
	Author loadAuthor(Long id);

	/**
	 * Deletes the given author.
	 * 
	 * @param author
	 *            The author.
	 */
	void deleteAuthor(Author author);

	/**
	 * Loads a list of all authors.
	 * 
	 * @return a list which is empty if no author was found.
	 */
	List<Author> loadAllAuthors();

}
