package de.nak.cars.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.cars.model.AdmonitionProcess;
import de.nak.cars.model.Lending;

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
	 * Loads a single admonition process entity from the database.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a admonition process or null if no admonition process was found
	 *         with the given identifier.
	 */
	public AdmonitionProcess load(Long id) {
		return (AdmonitionProcess) sessionFactory.getCurrentSession().get(
				AdmonitionProcess.class, id);
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

	/**
	 * Loads all admonition processes from the database.
	 * 
	 * @return a list or admonition processes which is empty if no admonition
	 *         process was found.
	 */
	@SuppressWarnings("unchecked")
	public List<AdmonitionProcess> loadAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from AdmonitionProcess").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<AdmonitionProcess> load(Lending lending) {
		// TODO Auto-generated method stub
		return null;
	}

}
