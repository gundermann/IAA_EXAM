package de.nak.cars.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import de.nak.cars.model.Author;
import de.nak.cars.model.Keyword;
import de.nak.cars.model.Publication;
import de.nak.cars.model.PublicationType;
import de.nak.cars.model.Publisher;

/**
 * Publication data access object.
 * 
 * @author Kathrin Kurtz
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
	public List<Publication> load(String whereCondition) {
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
	public Publication load(Integer isbn) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Publication.class);
		criteria.add(Restrictions.eq("isbn", isbn));
		return (Publication) criteria.uniqueResult();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Search publication by multiple value from the database.
	 * 
	 * @param title
	 * @param authors
	 * @param dateOfPublication
	 * @param publisher
	 * @param type
	 * @param keywords
	 * @return List of all publications that correspond to the given values.
	 */
	@SuppressWarnings("unchecked")
	public List<Publication> load(String title, List<Author> authors,
			Date dateOfPublication, Publisher publisher,
			PublicationType publicationType, List<Keyword> keywords) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Publication.class);

		if (title != null && !title.equals(""))
			criteria.add(Restrictions.like("title", "%" + title + "%"));
		if (authors != null && !authors.isEmpty())
			// TODO: geht das mit den Autoren so?
			criteria.add(Restrictions.like("authors", "%" + authors + "%"));
		if (dateOfPublication != null)
			criteria.add(Restrictions
					.eq("dateOfPublication", dateOfPublication));
		if (publisher != null)
			criteria.add(Restrictions.eq("publisher", publisher));
		if (publicationType != null)
			criteria.add(Restrictions.eq("publicationType", publicationType));
		if (keywords != null && !keywords.isEmpty())
			criteria.add(Restrictions.eq("keywords", keywords));

		return criteria.list();
	}

}
