package de.nak.library.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import de.nak.library.model.Lender;

/**
 * Lender data access object.
 * 
 * @author Kathrin Kurtz
 */
public class LenderDAO {
	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the lender into the database.
	 * 
	 * @param lender
	 *            The lender to persist. The given entity can be transient or
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
	 * @return a Lender or null if no lender was found with the given
	 *         identifier.
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

	/**
	 * Loads a single Lender entity from the database.
	 * 
	 * @param matriculationNumber
	 *            The matriculation number.
	 * @return a Lender or null if no lender was found with the given
	 *         matriculationNumber.
	 */
	@SuppressWarnings("unchecked")
	public Lender load(Integer matriculationNumber) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Lender.class);
		criteria.add(Restrictions
				.eq("matriculationNumber", matriculationNumber));
		List<Object> lenders = criteria.list();
		return lenders.isEmpty() ? null : (Lender) lenders.get(0);
	}

}
