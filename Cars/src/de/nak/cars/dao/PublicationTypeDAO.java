package de.nak.cars.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.cars.model.PublicationType;

/**
 * PublicationType data access object.
 * 
 * @author Christian Leppelt
 */
public class PublicationTypeDAO {

	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the publication type into the database.
	 * 
	 * @param publicationType
	 *            The publication type to persist. The given entity can be
	 *            transient or detached.
	 */
	public void save(PublicationType publicationType) {
		sessionFactory.getCurrentSession().saveOrUpdate(publicationType);
	}

	/**
	 * Loads a single publication type entity from the database.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a publication type or null if no publication type was found with
	 *         the given identifier.
	 */
	public PublicationType load(Long id) {
		return (PublicationType) sessionFactory.getCurrentSession().get(
				PublicationType.class, id);
	}

	/**
	 * Deletes the publication type from the database.
	 * 
	 * @param publication
	 *            type The publication type to be deleted.
	 */
	public void delete(PublicationType publicationType) {
		sessionFactory.getCurrentSession().delete(publicationType);
	}

	/**
	 * Loads all publication types from the database.
	 * 
	 * @return a list of publication types which is empty if no publication type
	 *         was found.
	 */
	@SuppressWarnings("unchecked")
	public List<PublicationType> loadAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from PublicationType").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
