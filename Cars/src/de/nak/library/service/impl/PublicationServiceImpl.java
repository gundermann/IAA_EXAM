package de.nak.library.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.nak.library.dao.PublicationDAO;
import de.nak.library.model.Author;
import de.nak.library.model.Keyword;
import de.nak.library.model.Publication;
import de.nak.library.model.PublicationType;
import de.nak.library.model.Publisher;
import de.nak.library.searchModel.SearchPublication;
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
	public List<Publication> searchPublications(SearchPublication publication) {
		return publicationDAO.load(publication);
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
	public void editPublisher(Publication publication, Long newPublisherId) {
		addPublisherValue(publication, newPublisherId);
	}

	@Override
	public void editPublicationType(Publication publication,
			Long newPublicationTypeId) {
		addPublicaionTypeValue(publication, newPublicationTypeId);
	}

	@Override
	public void addKeywords(Publication publication, Long[] keywordIds) {
		addKeywordValues(publication, keywordIds);
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
		addAuthorValues(publication, authorIds);
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

	@Override
	public List<Author> loadAllAuthorNotInPublication(Long publicationId) {
		Publication publication = loadPublication(publicationId);
		List<Author> authors = authorService.loadAllAuthors();
		for (Author author : publication.getAuthors()) {
			authors.remove(author);
		}
		return authors;
	}

	@Override
	public List<Keyword> loadAllKeywordsNotInPublication(Long publicationId) {
		Publication publication = loadPublication(publicationId);
		List<Keyword> keywords = keywordService.loadAllKeywords();
		for (Keyword keyword : publication.getKeywords()) {
			keywords.remove(keyword);
		}
		return keywords;
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

	private void addAuthorValues(Publication publication, Long[] authorIds) {
		Set<Author> authors = publication.getAuthors();
		if (authors == null)
			authors = new HashSet<Author>();
		for (Long authorId : authorIds) {
			authors.add(authorService.loadAuthor(authorId));
		}
		publication.setAuthors(authors);
	}

	private void addKeywordValues(Publication publication, Long[] keywordIds) {
		Set<Keyword> keywords = publication.getKeywords();
		if (keywords == null)
			keywords = new HashSet<Keyword>();
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
