package de.nak.library.dao;

import java.util.List;

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
	 * Loads a single admonition entity from the database.
	 * 
	 * @param id
	 *            The identifier.
	 * @return A admonition or null if no admonition was found with the given
	 *         identifier.
	 */
	public Admonition load(Long id) {
		return (Admonition) sessionFactory.getCurrentSession().get(
				Admonition.class, id);
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
	 * Loads all admonitions from the database.
	 * 
	 * @return a list of admonitions which is empty if no admonition was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Admonition> loadAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Admonition").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
