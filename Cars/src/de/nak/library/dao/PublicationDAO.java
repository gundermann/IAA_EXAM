package de.nak.library.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import de.nak.library.model.Author;
import de.nak.library.model.Publication;
import de.nak.library.model.PublicationType;
import de.nak.library.model.Publisher;
import de.nak.library.searchModel.SearchPublication;

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
	public Publication loadById(Long id) {
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
	public Publication loadByIsbn(Long isbn) {
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
	 * @param publication
	 * @return List of all publications that correspond to the given values.
	 */
	@SuppressWarnings("unchecked")
	public List<Publication> load(SearchPublication publication) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Publication.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		if (publication.getNakId() != null
				&& !publication.getNakId().equals("")) {
			criteria.add(Restrictions.eq("nakId",
					Long.valueOf(publication.getNakId())));
		}

		if (publication.getTitle() != null
				&& !publication.getTitle().equals("")) {
			criteria.add(Restrictions.like("title",
					"%" + publication.getTitle() + "%"));
		}
		// TODO: suche nach Autoren implementieren
		if (publication.getAuthors() != null
				&& !publication.getAuthors().equals("")) {
			Set<Author> authors = new HashSet<Author>();
			Author author = new Author();
			author.setName(publication.getAuthors());
			authors.add(author);

			criteria.add(Restrictions.like("authors", author));
		}

		if (publication.getDateOfPublication() != null
				&& !publication.getDateOfPublication().equals("")) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
			Date beginnPublicationDate = null;
			Date endPublicationDate = null;
			try {
				beginnPublicationDate = formatter.parse("01.01."
						+ publication.getDateOfPublication());
				endPublicationDate = formatter.parse("31.12."
						+ publication.getDateOfPublication());
			} catch (ParseException e) {
				beginnPublicationDate = new Date();
			}
			criteria.add(Restrictions.between("dateOfPublication",
					beginnPublicationDate, endPublicationDate));
		}
		if (publication.getPublisher() != null
				&& !publication.getPublisher().equals("")) {

			Criteria publisherCriteria = sessionFactory.getCurrentSession()
					.createCriteria(Publisher.class);
			publisherCriteria.add(Restrictions.ilike("publisherName", "%"
					+ publication.getPublisher() + "%"));
			List<Publisher> publishers = publisherCriteria.list();

			Disjunction res = Restrictions.disjunction();
			for (Publisher publisher : publishers) {
				res.add(Restrictions.eq("publisher", publisher));
			}
			criteria.add(res);
		}

		if (publication.getPublicationType() != null
				&& !publication.getPublicationType().equals("")) {

			Criteria publicationTypeCriteria = sessionFactory
					.getCurrentSession().createCriteria(PublicationType.class);
			publicationTypeCriteria.add(Restrictions.ilike("name",
					publication.getPublicationType()));
			List<PublicationType> publicationTypes = publicationTypeCriteria
					.list();

			Disjunction res = Restrictions.disjunction();
			for (PublicationType pubType : publicationTypes) {
				res.add(Restrictions.eq("publicationType", pubType));
			}
			criteria.add(res);
		}
		// TODO: Keywordsuche implementieren
		if (publication.getKeywords() != null
				&& !publication.getKeywords().equals("")) {
			criteria.add(Restrictions.eq("keywords", publication.getKeywords()));
		}

		return criteria.list();
	}
}
