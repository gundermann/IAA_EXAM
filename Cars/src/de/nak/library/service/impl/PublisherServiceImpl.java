package de.nak.library.service.impl;

import java.util.List;

import de.nak.library.dao.PublisherDAO;
import de.nak.library.model.Publisher;
import de.nak.library.service.PublisherService;

/**
 * The publisher service implementation class.
 * 
 * @publisher Christian Leppelt
 */
public class PublisherServiceImpl implements PublisherService {
	/** The publisher DAO. */
	private PublisherDAO publisherDAO;

	@Override
	public void savePublisher(Publisher publisher) {
		publisherDAO.save(publisher);
	}

	@Override
	public Publisher loadPublisher(Long publisherId) {
		return publisherDAO.load(publisherId);
	}

	@Override
	public void deletePublisher(Publisher publisher) {
		publisherDAO.delete(publisher);
	}

	@Override
	public List<Publisher> loadAllPublishers() {
		return publisherDAO.loadAll();
	}

	public void setPublisherDAO(PublisherDAO publisherDAO) {
		this.publisherDAO = publisherDAO;
	}

}
