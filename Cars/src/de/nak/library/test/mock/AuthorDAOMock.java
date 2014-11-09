package de.nak.library.test.mock;

import java.util.List;

import de.nak.library.dao.AuthorDAO;
import de.nak.library.model.Author;

/**
 * The author dao mock class.
 * 
 * @author Christian Leppelt
 */
public class AuthorDAOMock extends AuthorDAO {

	@Override
	public void save(Author author) {

	}

	@Override
	public Author load(Long id) {
		Author author = new Author();
		author.setAuthorId(id);
		return author;
	}

	@Override
	public void delete(Author author) {

	}

	@Override
	public List<Author> loadAll() {
		return null;
	}

	@Override
	public Author load(String name) {
		return null;
	}
}
