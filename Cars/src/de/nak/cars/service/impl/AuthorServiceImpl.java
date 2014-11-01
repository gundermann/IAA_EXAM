package de.nak.cars.service.impl;

import java.util.List;

import de.nak.cars.dao.AuthorDAO;
import de.nak.cars.model.Author;
import de.nak.cars.service.AuthorService;

/**
 * The author service implementation class.
 * 
 * @author Christian Leppelt
 */
public class AuthorServiceImpl implements AuthorService {
	/** The author DAO. */
	private AuthorDAO authorDAO;

	@Override
	public void saveAuthor(Author author) {
		authorDAO.save(author);
	}

	@Override
	public Author loadAuthor(Long authorId) {
		return authorDAO.load(authorId);
	}

	@Override
	public void deleteAuthor(Author author) {
		authorDAO.delete(author);
	}

	@Override
	public List<Author> loadAllAuthors() {
		return authorDAO.loadAll();
	}

	public void setAuthorDAO(AuthorDAO authorDao) {
		this.authorDAO = authorDao;
	}
	
}
