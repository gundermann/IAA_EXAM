package de.nak.cars.service;

import java.util.List;

import de.nak.cars.model.Publisher;

/**
 * Publisher service interface.
 * 
 * @publisher Christian Leppelt
 */
public interface PublisherService {

	/**
	 * Creates or updates a publisher.
	 * 
	 * @param publisher
	 *            The publisher.
	 */
	void savePublisher(Publisher publisher);

	/**
	 * Loads a single publisher.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a publisher or null.
	 */
	Publisher loadPublisher(Long id);

	/**
	 * Deletes the given publisher.
	 * 
	 * @param publisher
	 *            The publisher.
	 */
	void deletePublisher(Publisher publisher);

	/**
	 * Loads a list of all publishers.
	 * 
	 * @return a list which is empty if no publisher was found.
	 */
	List<Publisher> loadAllPublishers();

}
