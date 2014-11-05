package de.nak.library.test.mock;

import java.util.List;

import de.nak.library.dao.PublisherDAO;
import de.nak.library.model.Publisher;

/**
 * The keyword dao mock class.
 * 
 * @author Christian Leppelt
 */
public class PublisherDAOMock extends PublisherDAO {

	@Override
	public void save(Publisher publisher) {

	}

	@Override
	public Publisher load(Long publisherId) {
		return new Publisher();
	}

	@Override
	public void delete(Publisher publisher) {

	}

	@Override
	public List<Publisher> loadAll() {
		return null;
	}

}
