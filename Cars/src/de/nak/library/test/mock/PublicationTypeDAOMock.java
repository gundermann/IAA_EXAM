package de.nak.library.test.mock;

import java.util.List;

import de.nak.library.dao.PublicationTypeDAO;
import de.nak.library.model.PublicationType;

/**
 * The publication type dao mock class.
 * 
 * @author Christian Leppelt
 */
public class PublicationTypeDAOMock extends PublicationTypeDAO {

	@Override
	public void save(PublicationType publicationType) {

	}

	@Override
	public PublicationType load(Long id) {
		return new PublicationType();
	}

	@Override
	public void delete(PublicationType publicationType) {

	}

	@Override
	public List<PublicationType> loadAll() {
		return null;
	}
}
