package de.nak.cars.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.cars.model.Author;

/**
 * Author data access object.
 * 
 * @author Kathrin Kurtz
 */
public class AuthorDAO {

	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the author into the database.
	 * 
	 * @param author
	 *            The author to persist. The given entity can be
	 *            transient or detached.
	 */
	public void save(Author author) {
		sessionFactory.getCurrentSession().saveOrUpdate(author);
	}

	/**
	 * Loads a single author entity from the database.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a author or null if no author was found with
	 *         the given identifier.
	 */
	public Author load(Long id) {
		return (Author) sessionFactory.getCurrentSession().get(
				Author.class, id);
	}

	/**
	 * Deletes the author type from the database.
	 * 
	 * @param author
	 *            The author to be deleted.
	 */
	public void delete(Author author) {
		sessionFactory.getCurrentSession().delete(author);
	}

	/**
	 * Loads all author from the database.
	 * 
	 * @return a list of authors which is empty if no author
	 *         was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Author> loadAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from author").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
