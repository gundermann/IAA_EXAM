package de.nak.library.service.impl;

import java.util.List;

import de.nak.library.dao.AuthorDAO;
import de.nak.library.model.Author;
import de.nak.library.service.AuthorService;

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

	@Override
	public List<Author> loadAllAuthorNotInPublication(Long publicationId) {
		// TODO Eine Liste aller Autoren, die nicht zu den Autoren der Publikation gehören
		return null;
	}
	
}
