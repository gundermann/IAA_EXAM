package de.nak.library.test.mock;

import java.util.List;

import de.nak.library.dao.PublicationDAO;
import de.nak.library.model.Publication;

/**
 * The publication dao mock class.
 * 
 * @author Christian Leppelt
 */
public class PublicationDAOMock extends PublicationDAO {

	@Override
	public void save(Publication publication) {

	}

	@Override
	public Publication loadById(Long id) {
		Publication publication = new Publication();
		publication.setPublicationId(id);
		return publication;
	}

	@Override
	public void delete(Publication publication) {

	}

	@Override
	public List<Publication> loadAll() {
		return null;
	}

	@Override
	public List<Publication> load(String whereCondition) {
		return null;
	}

	@Override
	public Publication loadByIsbn(Long isbn) {
		return null;
	}

	@Override
	public List<Publication> load(Publication publication) {
		return null;
	}
}
