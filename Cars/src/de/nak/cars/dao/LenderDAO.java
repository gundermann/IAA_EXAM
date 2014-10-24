package de.nak.cars.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.cars.model.Lender;

/**
 * Lender data access object.
 * 
 * @author Kathrin Kurtz
 */
public class LenderDAO {
	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the car into the database.
	 * 
	 * @param lender
	 *            The car to persist. The given entity can be transient or
	 *            detached.
	 */
	public void save(Lender lender) {
		sessionFactory.getCurrentSession().saveOrUpdate(lender);
	}

	/**
	 * Loads a single Lender entity from the database.
	 * 
	 * @param lenderId
	 *            The identifier.
	 * @return a Lender or null if no car was found with the given identifier.
	 */
	public Lender load(Long lenderId) {
		return (Lender) sessionFactory.getCurrentSession().get(Lender.class,
				lenderId);
	}

	/**
	 * Deletes the Lender from the database.
	 * 
	 * @param lender
	 *            The Lender to be deleted.
	 */
	public void delete(Lender lender) {
		sessionFactory.getCurrentSession().delete(lender);
	}

	/**
	 * Loads all Lenders from the database.
	 * 
	 * @return a list of lenders which is empty if no lender was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Lender> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from Lender")
				.list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
