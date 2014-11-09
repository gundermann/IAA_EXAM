package de.nak.library.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import de.nak.library.model.Publisher;

/**
 * Publisher data access object.
 * 
 * @author Kathrin Kurtz
 */
public class PublisherDAO {

	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the publisher into the database.
	 * 
	 * @param publisher
	 *            The publisher to persist. The given entity can be transient or
	 *            detached.
	 */
	public void save(Publisher publisher) {
		sessionFactory.getCurrentSession().saveOrUpdate(publisher);
	}

	/**
	 * Loads a single publisher entity from the database.
	 * 
	 * @param publisherId
	 *            The identifier.
	 * @return a publisher or null if no publisher was found with the given
	 *         identifier.
	 */
	public Publisher load(Long publisherId) {
		return (Publisher) sessionFactory.getCurrentSession().get(
				Publisher.class, publisherId);
	}

	/**
	 * Deletes the publisher from the database.
	 * 
	 * @param publisher
	 *            The publisher to be deleted.
	 */
	public void delete(Publisher publisher) {
		sessionFactory.getCurrentSession().delete(publisher);
	}

	/**
	 * Loads all publishers from the database.
	 * 
	 * @return a list of publishers which is empty if no publisher was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Publisher> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from Publisher")
				.list();
	}

	/**
	 * Loads a publisher with a given name from the database.
	 * 
	 * @param name
	 * @return a Publisher if a publisher with this name was found or null if no
	 *         publisher was found.
	 */
	public Publisher load(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Publisher.class);
		criteria.add(Restrictions.eq("publisherName", name));
		return (Publisher) criteria.uniqueResult();
	}

	/**
	 * Set the sessionFactory.
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
