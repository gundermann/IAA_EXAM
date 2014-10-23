package de.nak.cars.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.cars.model.Publication;

/**
 * Publication data access object.
 * 
 * @author Christian Leppelt
 */
public class PublicationDAO {
	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the publication into the database.
	 * 
	 * @param publication
	 *            The publication to persist. The given entity can be transient
	 *            or detached.
	 */
	public void save(Publication publication) {
		sessionFactory.getCurrentSession().saveOrUpdate(publication);
	}

	/**
	 * Loads a single publication entity from the database.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a publication or null if no publication was found with the given
	 *         identifier.
	 */
	public Publication load(Long id) {
		return (Publication) sessionFactory.getCurrentSession().get(
				Publication.class, id);
	}

	/**
	 * Deletes the publication from the database.
	 * 
	 * @param publication
	 *            The publication to be deleted.
	 */
	public void delete(Publication publication) {
		sessionFactory.getCurrentSession().delete(publication);
	}

	/**
	 * Loads all publications from the database.
	 * 
	 * @return a list of publications which is empty if no publication was
	 *         found.
	 */
	@SuppressWarnings("unchecked")
	public List<Publication> loadAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Publication").list();
	}

	/**
	 * Search publications from the database.
	 * 
	 * @param whereCondition
	 *            A String that contains the 'where'-condition of your sql
	 *            statement.
	 * @return a list of publications which is empty if no publication was
	 *         found.
	 */
	@SuppressWarnings("unchecked")
	public List<Publication> findPublications(String whereCondition) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Publication" + whereCondition).list();
	}

	/**
	 * Search publication by ISBN from the database.
	 * 
	 * @param isbn
	 *            The isbn you search for.
	 * @return a publication which is null if no publication was found.
	 */
	public Publication findPublicationByIsbn(Integer isbn) {
		return (Publication) sessionFactory.getCurrentSession()
				.createQuery("from Publication where isbn = " + isbn)
				.uniqueResult();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
