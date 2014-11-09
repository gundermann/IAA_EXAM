package de.nak.library.test.mock;

import java.util.List;

import de.nak.library.dao.PublisherDAO;
import de.nak.library.model.Publisher;

/**
 * The publisher dao mock class.
 * 
 * @author Christian Leppelt
 */
public class PublisherDAOMock extends PublisherDAO {

	@Override
	public void save(Publisher publisher) {

	}

	@Override
	public Publisher load(Long publisherId) {
		Publisher publisher = new Publisher();
		publisher.setPublisherId(publisherId);
		return publisher;
	}

	@Override
	public void delete(Publisher publisher) {

	}

	@Override
	public List<Publisher> loadAll() {
		return null;
	}

	@Override
	public Publisher load(String name) {
		return null;
	}

}
