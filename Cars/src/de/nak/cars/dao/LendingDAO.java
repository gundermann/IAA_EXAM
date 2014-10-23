package de.nak.cars.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.cars.model.Lending;

/**
 * Lending data access object.
 * 
 * @author Christian Leppelt
 */
public class LendingDAO {
	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the lending into the database.
	 * 
	 * @param lending
	 *            The lending to persist. The given entity can be transient or
	 *            detached.
	 */
	public void save(Lending lending) {
		sessionFactory.getCurrentSession().saveOrUpdate(lending);
	}

	/**
	 * Loads a single lending entity from the database.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a lending or null if no lending was found with the given
	 *         identifier.
	 */
	public Lending load(Long id) {
		return (Lending) sessionFactory.getCurrentSession().get(Lending.class,
				id);
	}

	/**
	 * Deletes the lending from the database.
	 * 
	 * @param lending
	 *            The lending to be deleted.
	 */
	public void delete(Lending lending) {
		sessionFactory.getCurrentSession().delete(lending);
	}

	/**
	 * Loads all lendings from the database.
	 * 
	 * @return a list of lendings which is empty if no lending was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Lending> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from Lending")
				.list();
	}

	/**
	 * Searches lendings with a return date smaller then the delivered date.
	 * 
	 * @param currentDate
	 *            Todays date.
	 * @return a list of lendings which is empty if no lending was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Lending> findDelayed(Integer currentDate) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Lending where return_date < " + currentDate)
				.list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
