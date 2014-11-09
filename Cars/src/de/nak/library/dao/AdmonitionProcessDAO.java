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
	 * Loads a single admonition process entity from the database.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a admonition process or null if no admonition process was found
	 *         with the given identifier.
	 */
//	public AdmonitionProcess load(Long id) {
//		return (AdmonitionProcess) sessionFactory.getCurrentSession().get(
//				AdmonitionProcess.class, id);
//	}

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
	 * @return a list of admonition processes which is empty if no admonition
	 *         process was found.
	 */
//	@SuppressWarnings("unchecked")
//	public List<AdmonitionProcess> loadAll() {
//		return sessionFactory.getCurrentSession()
//				.createQuery("from AdmonitionProcess").list();
//	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Loads a admonition processes from the database that belongs to the given
	 * lending.
	 * 
	 * @return a list of one admonition process which is empty if no admonition
	 *         process was found.
	 */
//	public AdmonitionProcess loadByLending(Lending lending) {
//		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
//				AdmonitionProcess.class);
//		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//		criteria.add(Restrictions.eq("lending", lending));
//		return (AdmonitionProcess) criteria.uniqueResult();
//	}

	/**
	 * Loads a admonition processes from the database that belongs to the given
	 * lendingId.
	 * 
	 * @return a list of one admonition process which is empty if no admonition
	 *         process was found.
	 */
//	public AdmonitionProcess loadByLendingID(Long lendingId) {
//		Criteria lendingCriteria = sessionFactory.getCurrentSession()
//				.createCriteria(Lending.class);
//		lendingCriteria.add(Restrictions.eq("lendingId", lendingId));
//		Lending lending = (Lending) lendingCriteria.uniqueResult();
//
//		return loadByLending(lending);
//	}
}
