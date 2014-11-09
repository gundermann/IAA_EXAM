package de.nak.library.dao;

import org.hibernate.SessionFactory;

import de.nak.library.model.Admonition;

/**
 * Admonition data access object.
 * 
 * @author Kathrin Kurtz
 * 
 */
public class AdmonitionDAO {

	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the admonition into the database.
	 * 
	 * @param admonition
	 *            The admonition to persist. The given entity can be transient
	 *            or detached.
	 */
	public void save(Admonition admonition) {
		sessionFactory.getCurrentSession().saveOrUpdate(admonition);
	}

	/**
	 * Deletes the admonition from the database.
	 * 
	 * @param admonition
	 *            The admonition to be deleted.
	 */
	public void delete(Admonition admonition) {
		sessionFactory.getCurrentSession().delete(admonition);
	}

	/**
	 * Set the sessionFactory.
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
