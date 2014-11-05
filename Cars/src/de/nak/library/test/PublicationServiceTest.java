package de.nak.library.test;

import junit.framework.TestCase;
import de.nak.library.model.Author;
import de.nak.library.model.Keyword;
import de.nak.library.model.Publication;
import de.nak.library.model.PublicationType;
import de.nak.library.model.Publisher;
import de.nak.library.service.impl.AuthorServiceImpl;
import de.nak.library.service.impl.KeywordServiceImpl;
import de.nak.library.service.impl.PublicationServiceImpl;
import de.nak.library.service.impl.PublicationTypeServiceImpl;
import de.nak.library.service.impl.PublisherServiceImpl;
import de.nak.library.test.mock.AuthorDAOMock;
import de.nak.library.test.mock.KeywordDAOMock;
import de.nak.library.test.mock.PublicationDAOMock;
import de.nak.library.test.mock.PublicationTypeDAOMock;
import de.nak.library.test.mock.PublisherDAOMock;

/**
 * The publication service test class.
 * 
 * @author Christian Leppelt
 */
public class PublicationServiceTest extends TestCase {
	/** The publication service. */
	PublicationServiceImpl publicationService;

	protected void setUp() {
		publicationService = new PublicationServiceImpl();
		publicationService.setPublicationDAO(new PublicationDAOMock());

		AuthorServiceImpl authorService = new AuthorServiceImpl();
		authorService.setAuthorDAO(new AuthorDAOMock());
		publicationService.setAuthorService(authorService);

		KeywordServiceImpl keywordService = new KeywordServiceImpl();
		keywordService.setKeywordDAO(new KeywordDAOMock());
		publicationService.setKeywordService(keywordService);

		PublicationTypeServiceImpl publicationTypeService = new PublicationTypeServiceImpl();
		publicationTypeService
				.setPublicationTypeDAO(new PublicationTypeDAOMock());
		publicationService.setPublicationTypeService(publicationTypeService);

		PublisherServiceImpl publisherService = new PublisherServiceImpl();
		publisherService.setPublisherDAO(new PublisherDAOMock());
		publicationService.setPublisherService(publisherService);
	}

	public void testSetupPublication() {
		Publication publication = new Publication();

		Long[] idArray = { 12l };
		publicationService.setupPublication(publication, idArray, idArray, 12l,
				12l);

		assertNotNull(publication.getAuthors());
		assertFalse(publication.getAuthors().isEmpty());
		assertNotNull(publication.getKeywords());
		assertFalse(publication.getKeywords().isEmpty());
		assertNotNull(publication.getPublicationType());
		assertNotNull(publication.getPublisher());
	}

	public void testEditPublisher() {
		Publication publication = new Publication();
		Publisher publisher = new Publisher();
		publisher.setPublisherId(12l);
		publication.setPublisher(publisher);

		publicationService.editPublisher(publication, 13l);

		assertEquals(new Long(13), publication.getPublisher().getPublisherId());
	}

	public void testEditPublicationType() {
		Publication publication = new Publication();
		PublicationType publicationType = new PublicationType();
		publicationType.setPublicationTypeId(12l);
		publication.setPublicationType(publicationType);

		publicationService.editPublicationType(publication, 13l);

		assertEquals(new Long(13), publication.getPublicationType()
				.getPublicationTypeId());
	}

	public void testAddKeywords() {
		Publication publication = new Publication();
		Long[] keywordIds = { 12l, 13l };
		boolean keywordOneExists = false;
		boolean keywordTwoExists = false;

		publicationService.addKeywords(publication, keywordIds);

		for (Keyword keyword : publication.getKeywords()) {
			if (keyword.getKeywordId() == 12l)
				keywordOneExists = true;
			else if (keyword.getKeywordId() == 13l)
				keywordTwoExists = true;
		}

		assertTrue(keywordOneExists);
		assertTrue(keywordTwoExists);
	}

	public void testDeleteKeywords() {
		Publication publication = new Publication();
		Long[] keywordIds = { 12l, 13l };
		boolean keywordOneExists = false;
		boolean keywordTwoExists = false;

		publicationService.addKeywords(publication, keywordIds);
		publicationService.deleteKeywords(publication, keywordIds);

		for (Keyword keyword : publication.getKeywords()) {
			if (keyword.getKeywordId() == 12l)
				keywordOneExists = true;
			else if (keyword.getKeywordId() == 13l)
				keywordTwoExists = true;
		}

		assertFalse(keywordOneExists);
		assertFalse(keywordTwoExists);
	}

	public void testAddAuthors() {
		Publication publication = new Publication();
		Long[] authorIds = { 12l, 13l };
		boolean authorOneExists = false;
		boolean authorTwoExists = false;

		publicationService.addAuthors(publication, authorIds);

		for (Author author : publication.getAuthors()) {
			if (author.getAuthorId() == 12l)
				authorOneExists = true;
			else if (author.getAuthorId() == 13l)
				authorTwoExists = true;
		}

		assertTrue(authorOneExists);
		assertTrue(authorTwoExists);
	}

	public void testDeleteAuthors() {
		Publication publication = new Publication();
		Long[] authorIds = { 12l, 13l };
		boolean authorOneExists = false;
		boolean authorTwoExists = false;

		publicationService.addAuthors(publication, authorIds);
		publicationService.deleteAuthors(publication, authorIds);

		for (Author author : publication.getAuthors()) {
			if (author.getAuthorId() == 12l)
				authorOneExists = true;
			else if (author.getAuthorId() == 13l)
				authorTwoExists = true;
		}

		assertFalse(authorOneExists);
		assertFalse(authorTwoExists);
	}
}
