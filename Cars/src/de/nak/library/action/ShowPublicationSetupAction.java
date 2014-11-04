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
 *
 * @author Niels Gundermann
 */
public class ShowPublicationSetupAction implements Action {

	private List<PublicationType> publicationTypeList;

	private PublicationTypeService publicationTypeService;

	private List<Author> authorList;

	private AuthorService authorService;

	private List<Keyword> keywordList;

	private KeywordService keywordService;

	private List<Publisher> publisherList;

	private PublisherService publisherService;

	private Publication publication;

	@Override
	public String execute() throws Exception {
		publicationTypeList = publicationTypeService.loadAllPublicationTypes();
		authorList = authorService.loadAllAuthors();
		keywordList = keywordService.loadAllKeywords();
		publisherList = publisherService.loadAllPublishers();
		return SUCCESS;
	}

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

}
