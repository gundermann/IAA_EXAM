package de.nak.cars.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.cars.model.Author;
import de.nak.cars.model.Keyword;
import de.nak.cars.model.PublicationType;
import de.nak.cars.service.AuthorService;
import de.nak.cars.service.KeywordService;
import de.nak.cars.service.PublicationTypeService;

/**
 * Action that shows a list of failures.
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

	@Override
	public String execute() throws Exception {
		publicationTypeList = publicationTypeService.loadAllPublicationTypes();
//		authorList = authorService.loadAllAuthors();
//		keywordList = keywordService.loadAllKeywords();
		return SUCCESS;
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

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public List<Keyword> getKeywordList() {
		return keywordList;
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
