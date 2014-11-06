package de.nak.library.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.Author;
import de.nak.library.model.Keyword;
import de.nak.library.service.PublicationService;

public class PublicationEditSetupAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2610560721911144525L;

	private List<Keyword> keywordList;

	private List<Author> authorList;

	private PublicationService publicationService;

	private Long publicationId;
	
	public String loadKeywordsNotInLending() {
		keywordList = publicationService
				.loadAllKeywordsNotInPublication(publicationId);
		return SUCCESS;
	}

	public String loadAuthorsNotInLending() {
		authorList = publicationService
				.loadAllAuthorNotInPublication(publicationId);
		return SUCCESS;
	}

	public String loadKeywordsInLending() {
		keywordList = new ArrayList<Keyword>();
		keywordList.addAll(publicationService.loadPublication(publicationId)
				.getKeywords());
		return SUCCESS;
	}

	public String loadAuthorsInLending() {
		authorList = new ArrayList<Author>();
		authorList.addAll(publicationService.loadPublication(publicationId)
				.getAuthors());
		return SUCCESS;
	}

	public Long getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(Long publicationId) {
		this.publicationId = publicationId;
	}

	public List<Keyword> getKeywordList() {
		return keywordList;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}
	
	
	

}
