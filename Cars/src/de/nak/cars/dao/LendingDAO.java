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
	 * Searches lendings y a specific outgo date.
	 * 
	 * @param outgoDate
	 *            The date the publication was lent.
	 * @return a list of lendings which is empty if no lending was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Lending> searchByOutgoDate(Integer outgoDate) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Lending where outgo_date > " + outgoDate)
				.list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
