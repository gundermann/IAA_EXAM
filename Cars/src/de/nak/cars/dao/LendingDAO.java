package de.nak.cars.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import de.nak.cars.model.Lending;
import de.nak.cars.model.Publication;

/**
 * Lending data access object.
 * 
 * @author Kathrin Kurtz
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

	/**
	 * Searches lendings that belong to a given publication.
	 * 
	 * @param publication
	 *            Publication that was lended.
	 * @return a list of lendings which is empty if no lending was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Lending> load(Publication publication) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Lending.class);
		criteria.add(Restrictions.eq("publication", publication));
		return criteria.list();
	}

}
