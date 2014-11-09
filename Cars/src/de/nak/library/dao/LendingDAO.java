package de.nak.library.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import de.nak.library.model.Lender;
import de.nak.library.model.Lending;
import de.nak.library.model.Publication;

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
	public List<Lending> findDelayed(Date currentDate) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Lending.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date();
		try {
			date = formatter.parse("01.01.1000");
		} catch (ParseException e) {
		}
		criteria.add(Restrictions.between("expectedReturnDate", date,
				currentDate));

		List<Lending> lendings = criteria.list();
		return lendings;
	}

	/**
	 * Set the sessionFactory.
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Searches lendings that belong to a given publication.
	 * 
	 * @param publication
	 *            Publication that was lend.
	 * @return a list of lendings which is empty if no lending was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Lending> load(Publication publication) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Lending.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("publication", publication));
		return criteria.list();
	}

	/**
	 * Searches lendings that belong to a given lender.
	 * 
	 * @param lender
	 *            Lender who lend the publication.
	 * @return a list of lendings which is empty if no lending was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Lending> load(Lender lender) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Lending.class);
		criteria.add(Restrictions.eq("lender", lender));
		return criteria.list();
	}

}
