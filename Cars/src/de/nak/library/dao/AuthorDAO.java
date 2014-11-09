package de.nak.library.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import de.nak.library.model.Author;

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
	 *            The author to persist. The given entity can be transient or
	 *            detached.
	 */
	public void save(Author author) {
		sessionFactory.getCurrentSession().saveOrUpdate(author);
	}

	/**
	 * Loads a single author entity from the database.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a author or null if no author was found with the given
	 *         identifier.
	 */
	public Author load(Long id) {
		return (Author) sessionFactory.getCurrentSession()
				.get(Author.class, id);
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
	 * @return a list of authors which is empty if no author was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Author> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from Author")
				.list();
	}

	/**
	 * Loads a author with a given name from the database.
	 * 
	 * @param name
	 * @return a author if a author with this name was found or null if no
	 *         author was found.
	 */
	public Author load(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Author.class);
		criteria.add(Restrictions.eq("name", name));
		return (Author) criteria.uniqueResult();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
