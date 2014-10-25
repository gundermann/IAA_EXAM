package de.nak.cars.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.cars.model.AdmonitionProcess;

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
	 * Persists or merges the admonitionprocess into the database.
	 * 
	 * @param admonitionProcess
	 *            The admonitionprocess to persist. The given entity can be
	 *            transient or detached.
	 */
	public void save(AdmonitionProcess admonitionProcess) {
		sessionFactory.getCurrentSession().saveOrUpdate(admonitionProcess);
	}

	/**
	 * Loads a single admonitionprocess entity from the database.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a admonitionprocess or null if no admonitionprocess was found
	 *         with the given identifier.
	 */
	public AdmonitionProcess load(Long id) {
		return (AdmonitionProcess) sessionFactory.getCurrentSession().get(
				AdmonitionProcess.class, id);
	}

	/**
	 * Deletes the admonitionprocess from the database.
	 * 
	 * @param admonitionProcess
	 *            The admonitionprocess to be deleted.
	 */
	public void delete(AdmonitionProcess admonitionProcess) {
		sessionFactory.getCurrentSession().delete(admonitionProcess);
	}

	/**
	 * Loads all admonitionprocesses from the database.
	 * 
	 * @return a list or admonitionprocesses which is empty if no
	 *         admonitionprocess was found.
	 */
	@SuppressWarnings("unchecked")
	public List<AdmonitionProcess> loadAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from AdmonitionProcess").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
