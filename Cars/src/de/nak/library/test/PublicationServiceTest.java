package de.nak.library.test;

import junit.framework.TestCase;
import de.nak.library.model.Publication;
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
}
