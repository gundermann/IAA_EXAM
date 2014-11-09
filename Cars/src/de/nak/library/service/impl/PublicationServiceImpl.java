package de.nak.library.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.nak.library.dao.PublicationDAO;
import de.nak.library.model.Author;
import de.nak.library.model.Keyword;
import de.nak.library.model.Publication;
import de.nak.library.model.PublicationSearchCriteria;
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
	public List<Publication> searchPublicationByCriteria(
			PublicationSearchCriteria publicationCriteria) {
		return publicationDAO.load(publicationCriteria);
	}

	@Override
	public List<Publication> searchPublicationByIsbn(Long isbn) {
		List<Publication> publicationList = new ArrayList<Publication>();
		Publication publication = publicationDAO.loadByIsbn(isbn);
		if (publication != null)
			publicationList.add(publication);
		return publicationList;
	}

	@Override
	public Publication searchByNakId(Long nakId) {
		return publicationDAO.loadByNakId(nakId);
	}

	@Override
	public List<Publication> searchByKeywordId(Long keywordId) {
		return publicationDAO.loadByKeywordId(keywordId);
	}

	@Override
	public List<Publication> searchByPublicationTypeId(Long publicationTypeId) {
		return publicationDAO.loadByPublicationTypeId(publicationTypeId);
	}

	@Override
	public List<Publication> searchByAuthorId(Long authorId) {
		return publicationDAO.loadByAuthorId(authorId);
	}

	@Override
	public List<Publication> searchByPublisherId(Long publisherId) {
		return publicationDAO.loadByPublisherId(publisherId);
	}

	@Override
	public List<Author> searchAllAuthorNotInPublication(Long publicationId) {
		Publication publication = loadPublication(publicationId);
		List<Author> authors = authorService.loadAllAuthors();
		for (Author author : publication.getAuthors()) {
			authors.remove(author);
		}
		return authors;
	}

	@Override
	public List<Keyword> searchAllKeywordsNotInPublication(Long publicationId) {
		Publication publication = loadPublication(publicationId);
		List<Keyword> keywords = keywordService.loadAllKeywords();
		for (Keyword keyword : publication.getKeywords()) {
			keywords.remove(keyword);
		}
		return keywords;
	}

	@Override
	public Publication setupPublication(Publication publication,
			Long[] authorIds, Long[] keywordIds, Long publicationTypeId,
			Long publisherId) {
		addAuthors(publication, authorIds);
		addKeywords(publication, keywordIds);
		editPublicationType(publication, publicationTypeId);
		editPublisher(publication, publisherId);
		return publication;
	}

	@Override
	public void editPublisher(Publication publication, Long newPublisherId) {
		if (newPublisherId == null) {
			publication.setPublisher(null);
		} else {
			Publisher publisher = publisherService
					.loadPublisher(newPublisherId);
			publication.setPublisher(publisher);
		}
	}

	@Override
	public void editPublicationType(Publication publication,
			Long newPublicationTypeId) {
		PublicationType publicationType = publicationTypeService
				.loadPublicationType(newPublicationTypeId);
		publication.setPublicationType(publicationType);
	}

	@Override
	public void addKeywords(Publication publication, Long[] keywordIds) {
		if (keywordIds != null) {
			Set<Keyword> keywords = publication.getKeywords();
			if (keywords == null)
				keywords = new HashSet<Keyword>();
			for (Long keywordId : keywordIds) {
				keywords.add(keywordService.loadKeyword(keywordId));
			}
			publication.setKeywords(keywords);
		}
	}

	@Override
	public void deleteKeywords(Publication publication, Long[] keywordIds) {
		Set<Keyword> keywords = publication.getKeywords();
		if (keywords == null)
			keywords = new HashSet<Keyword>();
		for (Long keywordId : keywordIds) {
			keywords.remove(keywordService.loadKeyword(keywordId));
		}
		publication.setKeywords(keywords);
	}

	@Override
	public void addAuthors(Publication publication, Long[] authorIds) {
		Set<Author> authors = publication.getAuthors();
		if (authors == null)
			authors = new HashSet<Author>();
		for (Long authorId : authorIds) {
			authors.add(authorService.loadAuthor(authorId));
		}
		publication.setAuthors(authors);
	}

	@Override
	public void deleteAuthors(Publication publication, Long[] authorIds) {
		Set<Author> authors = publication.getAuthors();
		if (authors == null)
			authors = new HashSet<Author>();
		for (Long authorId : authorIds) {
			authors.remove(authorService.loadAuthor(authorId));
		}
		publication.setAuthors(authors);
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

}
