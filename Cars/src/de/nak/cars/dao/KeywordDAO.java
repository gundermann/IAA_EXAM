package de.nak.cars.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.cars.model.Keyword;

/**
 * Keyword data access object.
 * 
 * @author Kathrin Kurtz
 * 
 */
public class KeywordDAO {

	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the keyword into the database.
	 * 
	 * @param keyword
	 *            The keyword to persist. The given entity can be transient or
	 *            detached.
	 */
	public void save(Keyword keyword) {
		sessionFactory.getCurrentSession().saveOrUpdate(keyword);
	}

	/**
	 * Loads a single keyword entity from the database.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a keyword or null if no keyword was found with the given
	 *         identifier.
	 */
	public Keyword load(Long id) {
		return (Keyword) sessionFactory.getCurrentSession().get(Keyword.class,
				id);
	}

	/**
	 * Deletes the keyword from the database.
	 * 
	 * @param keyword
	 *            The keyword to be deleted.
	 */
	public void delete(Keyword keyword) {
		sessionFactory.getCurrentSession().delete(keyword);
	}

	/**
	 * Loads all keywords from the database.
	 * 
	 * @return a list of keywords which is empty if no keyword was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Keyword> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from Keyword")
				.list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
