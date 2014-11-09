package de.nak.library.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import de.nak.library.model.PublicationType;

/**
 * PublicationType data access object.
 * 
 * @author Kathrin Kurtz
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

	/**
	 * Loads a publicationtype with a given name from the database.
	 * 
	 * @param name
	 * @return a publicationtype if a publicationtype with this name was found
	 *         or null if no publicationtype was found.
	 */
	public PublicationType load(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				PublicationType.class);
		criteria.add(Restrictions.eq("name", name));
		return (PublicationType) criteria.uniqueResult();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
