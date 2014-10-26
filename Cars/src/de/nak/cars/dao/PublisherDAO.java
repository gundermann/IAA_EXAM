package de.nak.cars.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.cars.model.Publisher;

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

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
