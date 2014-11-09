package de.nak.library.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import de.nak.library.model.Author;
import de.nak.library.model.Keyword;
import de.nak.library.model.Publication;
import de.nak.library.model.PublicationSearchCriteria;
import de.nak.library.model.PublicationType;
import de.nak.library.model.Publisher;

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

	/**
	 * Search publication by multiple value from the database.
	 * 
	 * @param publication
	 * @return List of all publications that correspond to the given values.
	 */
	@SuppressWarnings("unchecked")
	public List<Publication> load(PublicationSearchCriteria publication) {

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
			criteria.add(Restrictions.ilike("title",
					"%" + publication.getTitle() + "%"));
		}
		if (publication.getAuthors() != null
				&& !publication.getAuthors().equals("")) {

			Criteria authorCriteria = sessionFactory.getCurrentSession()
					.createCriteria(Author.class);
			authorCriteria.add(Restrictions.ilike("name",
					"%" + publication.getAuthors() + "%"));
			List<Author> authors = authorCriteria.list();
			if (!authors.isEmpty()) {
				criteria.createAlias("authors", "authors");

				Disjunction res = Restrictions.disjunction();
				for (Author author : authors) {
					res.add(Restrictions.eq("authors.id", author.getAuthorId()));

				}
				criteria.add(res);
			} else {
				criteria.add(Restrictions.eq("nakId", 0L));
			}

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

			if (!publishers.isEmpty()) {
				Disjunction res = Restrictions.disjunction();

				for (Publisher publisher : publishers) {
					res.add(Restrictions.eq("publisher", publisher));
				}

				criteria.add(res);
			} else {
				criteria.add(Restrictions.eq("nakId", 0L));
			}
		}

		if (publication.getPublicationType() != null
				&& !publication.getPublicationType().equals("")) {

			Criteria publicationTypeCriteria = sessionFactory
					.getCurrentSession().createCriteria(PublicationType.class);
			publicationTypeCriteria.add(Restrictions.ilike("name",
					publication.getPublicationType()));
			List<PublicationType> publicationTypes = publicationTypeCriteria
					.list();
			if (!publicationTypes.isEmpty()) {

				Disjunction res = Restrictions.disjunction();
				for (PublicationType pubType : publicationTypes) {
					res.add(Restrictions.eq("publicationType", pubType));
				}
				criteria.add(res);
			} else {
				criteria.add(Restrictions.eq("nakId", 0L));
			}
		}

		if (publication.getKeywords() != null
				&& !publication.getKeywords().equals("")) {
			Criteria keywordCriteria = sessionFactory.getCurrentSession()
					.createCriteria(Keyword.class);
			keywordCriteria.add(Restrictions.ilike("keyword",
					"%" + publication.getKeywords() + "%"));
			List<Keyword> keywords = keywordCriteria.list();

			if (!keywords.isEmpty()) {
				criteria.createAlias("keywords", "keywords");

				Disjunction res = Restrictions.disjunction();
				for (Keyword keyword : keywords) {
					res.add(Restrictions.eq("keywords.id",
							keyword.getKeywordId()));

				}
				criteria.add(res);
			} else {
				criteria.add(Restrictions.eq("nakId", 0L));
			}
		}

		return criteria.list();
	}

	/**
	 * Search publications by nakId in the database
	 * 
	 * @param nakId
	 * @return Publications that has the nak id, or null if no such nakid was
	 *         found.
	 */
	public Publication loadByNakId(Long nakId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Publication.class);
		criteria.add(Restrictions.eq("nakId", nakId));
		return (Publication) criteria.uniqueResult();
	}

	/**
	 * Search publications by KeywordID in the database
	 * 
	 * @param keywordId
	 * @return List of Publications that have the keyword, or empty list if no
	 *         such keyword was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Publication> loadByKeywordId(Long keywordId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Publication.class);
		criteria.createAlias("keywords", "keywords");
		Disjunction res = Restrictions.disjunction();
		res.add(Restrictions.eq("keywords.id", keywordId));
		criteria.add(res);
		return criteria.list();
	}

	/**
	 * Search publications by publicationTypeId in the database
	 * 
	 * @param publicationTypeId
	 * @return List of Publications that have the publicationTypeId, or empty
	 *         list if no such publicationTypeId was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Publication> loadByPublicationTypeId(Long publicationTypeId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Publication.class);
		Disjunction res = Restrictions.disjunction();
		res.add(Restrictions.eq("publicationType.id", publicationTypeId));
		criteria.add(res);
		return criteria.list();
	}

	/**
	 * Search publications by authorId in the database
	 * 
	 * @param authorId
	 * @return List of Publications that have the authorId, or empty list if no
	 *         such authorId was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Publication> loadByAuthorId(Long authorId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Publication.class);
		Disjunction res = Restrictions.disjunction();
		res.add(Restrictions.eq("authors.id", authorId));
		criteria.add(res);
		return criteria.list();
	}

	/**
	 * Search publications by publisherId in the database
	 * 
	 * @param publisherId
	 * @return List of Publications that have the publisherId, or empty list if
	 *         no such publisherId was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Publication> loadByPublisherId(Long publisherId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Publication.class);
		Disjunction res = Restrictions.disjunction();
		res.add(Restrictions.eq("publisher.id", publisherId));
		criteria.add(res);
		return criteria.list();
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
