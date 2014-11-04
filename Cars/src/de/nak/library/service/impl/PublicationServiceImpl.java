package de.nak.library.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.nak.library.dao.PublicationDAO;
import de.nak.library.model.Author;
import de.nak.library.model.Keyword;
import de.nak.library.model.Publication;
import de.nak.library.model.PublicationType;
import de.nak.library.model.Publisher;
import de.nak.library.service.AuthorService;
import de.nak.library.service.KeywordService;
import de.nak.library.service.PublicationService;
import de.nak.library.service.PublicationTypeService;
import de.nak.library.service.PublisherService;

/**
 * The publication service implementation class.
 * 
 * @author Christian Leppelt
 */
public class PublicationServiceImpl implements PublicationService {
	/** The publication DAO. */
	private PublicationDAO publicationDAO;
	/** The author service. */
	private AuthorService authorService;
	/** The keyword service. */
	private KeywordService keywordService;
	/** The publication type service. */
	private PublicationTypeService publicationTypeService;
	/** The publisher service. */
	private PublisherService publisherService;

	@Override
	public void savePublication(Publication publication) {
		publicationDAO.save(publication);
	}

	@Override
	public Publication loadPublication(Long id) {
		return publicationDAO.loadById(id);
	}

	@Override
	public void deletePublication(Publication publication) {
		publicationDAO.delete(publication);
	}

	@Override
	public List<Publication> loadAllPublications() {
		return publicationDAO.loadAll();
	}

	@Override
	public List<Publication> searchPublications(String title,
			List<Author> authors, Date dateOfPublication, Publisher publisher,
			PublicationType publicationType, List<Keyword> keywords) {
		return publicationDAO.load(title, authors, dateOfPublication,
				publisher, publicationType, keywords);
	}

	@Override
	public List<Publication> searchPublicationByIsbn(Long isbn) {
		List<Publication> publicationList = new ArrayList<Publication>();
		Publication publication = publicationDAO.loadById(isbn);
		if (publication != null)
			publicationList.add(publication);
		return publicationList;
	}

	@Override
	public Publication setupPublication(Publication publication,
			Long[] authorIds, Long[] keywordIds, Long publicationTypeId,
			Long publisherId) {
		addAuthorValues(publication, authorIds);
		addKeywordValues(publication, keywordIds);
		addPublicaionTypeValue(publication, publicationTypeId);
		addPublisherValue(publication, publisherId);
		return publication;
	}

	@Override
	public List<Publication> loadAllAvailablePublications() {
		// TODO: muss in einen eigenen service
		// da dieser service nicht die LendingDAO kennt
		// und der lending service nicht die publicationDAO
		return null;
	}

	public void setPublicationDAO(PublicationDAO publicationDAO) {
		this.publicationDAO = publicationDAO;
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

	public void setPublicationTypeService(
			PublicationTypeService publicationTypeService) {
		this.publicationTypeService = publicationTypeService;
	}

	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	// TODO wird nicht benutzt.
	private String createWhereCondition(ArrayList<String> queryParts) {
		if (queryParts.isEmpty())
			return "";
		String whereCondition = " where ";
		for (int i = 0; i < queryParts.size(); i++) {
			whereCondition = whereCondition + queryParts.get(i);
			if (i < queryParts.size() - 1)
				whereCondition = whereCondition + " and ";
		}
		return whereCondition;
	}

	private void addAuthorValues(Publication publication, Long[] authorIds) {
		Set<Author> authors = new HashSet<Author>();
		for (Long authorId : authorIds) {
			authors.add(authorService.loadAuthor(authorId));
		}
		publication.setAuthors(authors);
	}

	private void addKeywordValues(Publication publication, Long[] keywordIds) {
		Set<Keyword> keywords = new HashSet<Keyword>();
		for (Long keywordId : keywordIds) {
			keywords.add(keywordService.loadKeyword(keywordId));
		}
		publication.setKeywords(keywords);
	}

	private void addPublicaionTypeValue(Publication publication,
			Long publicationTypeId) {
		PublicationType publicationType = publicationTypeService
				.loadPublicationType(publicationTypeId);
		publication.setPublicationType(publicationType);
	}

	private void addPublisherValue(Publication publication, Long publisherId) {
		Publisher publisher = publisherService.loadPublisher(publisherId);
		publication.setPublisher(publisher);
	}
}
