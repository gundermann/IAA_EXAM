package de.nak.library.test.mock;

import java.util.Date;
import java.util.List;

import de.nak.library.dao.PublicationDAO;
import de.nak.library.model.Author;
import de.nak.library.model.Keyword;
import de.nak.library.model.Publication;
import de.nak.library.model.PublicationType;
import de.nak.library.model.Publisher;

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
		return new Publication();
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
	public List<Publication> load(String title, List<Author> authors,
			Date dateOfPublication, Publisher publisher,
			PublicationType publicationType, List<Keyword> keywords) {
		return null;
	}
}
