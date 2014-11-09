package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Author;
import de.nak.library.model.Keyword;
import de.nak.library.model.Publication;
import de.nak.library.model.PublicationType;
import de.nak.library.model.Publisher;
import de.nak.library.service.AuthorService;
import de.nak.library.service.KeywordService;
import de.nak.library.service.PublicationTypeService;
import de.nak.library.service.PublisherService;

/**
 * Action that shows the setup for a new publication.
 *
 * @author Niels Gundermann
 */
public class ShowPublicationSetupAction implements Action {

	/** The list of publication types */
	private List<PublicationType> publicationTypeList;
	/** The publication type service */
	private PublicationTypeService publicationTypeService;
	/** The list of authors */
	private List<Author> authorList;
	/** The author service */
	private AuthorService authorService;
	/** The list of keywords */
	private List<Keyword> keywordList;
	/** The keyword service */
	private KeywordService keywordService;
	/** The list of publishers */
	private List<Publisher> publisherList;
	/** The publisher service */
	private PublisherService publisherService;
	/** The new publication */
	private Publication publication;

	public List<Publisher> getPublisherList() {
		return publisherList;
	}

	public void setPublisherList(List<Publisher> publisherList) {
		this.publisherList = publisherList;
	}

	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	public List<PublicationType> getPublicationTypeList() {
		return publicationTypeList;
	}

	public void setPublicationTypeList(List<PublicationType> publicationTypeList) {
		this.publicationTypeList = publicationTypeList;
	}

	public void setPublicationTypeService(
			PublicationTypeService publicationTypeService) {
		this.publicationTypeService = publicationTypeService;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public List<Keyword> getKeywordList() {
		return keywordList;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public void setKeywordList(List<Keyword> keywordList) {
		this.keywordList = keywordList;
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

	@Override
	public String execute() throws Exception {
		publicationTypeList = publicationTypeService.loadAllPublicationTypes();
		authorList = authorService.loadAllAuthors();
		keywordList = keywordService.loadAllKeywords();
		publisherList = publisherService.loadAllPublishers();
		return SUCCESS;
	}

}
