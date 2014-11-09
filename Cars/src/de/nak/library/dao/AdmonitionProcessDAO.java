package de.nak.library.dao;

import org.hibernate.SessionFactory;

import de.nak.library.model.AdmonitionProcess;

/**
 * AdmonitionProcess data access object.
 * 
 * @author Kathrin Kurtz
 * 
 */
public class AdmonitionProcessDAO {

	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the admonition process into the database.
	 * 
	 * @param admonitionProcess
	 *            The admonition process to persist. The given entity can be
	 *            transient or detached.
	 */
	public void save(AdmonitionProcess admonitionProcess) {
		sessionFactory.getCurrentSession().saveOrUpdate(admonitionProcess);
	}

	/**
	 * Deletes the admonition process from the database.
	 * 
	 * @param admonitionProcess
	 *            The admonition process to be deleted.
	 */
	public void delete(AdmonitionProcess admonitionProcess) {
		sessionFactory.getCurrentSession().delete(admonitionProcess);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
