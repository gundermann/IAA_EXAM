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

	private AuthorDAO authorDAO = new AuthorDAO();
	
	@Override
	public void saveAuthor(Author author) {
		authorDAO.save(author);
	}

	@Override
	public Author loadAuthor(Long id) {
		return authorDAO.load(id);
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
