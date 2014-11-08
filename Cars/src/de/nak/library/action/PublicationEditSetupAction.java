package de.nak.library.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.Author;
import de.nak.library.model.Keyword;
import de.nak.library.service.PublicationService;

public class PublicationEditSetupAction extends ActionSupport {

	/** Serial version UID. */
	private static final long serialVersionUID = 2610560721911144525L;

	/** The keyword list */
	private List<Keyword> keywordList;

	/** The author list */
	private List<Author> authorList;

	/** The publication service */
	private PublicationService publicationService;

	/** The publication's identifier */
	private Long publicationId;

	/**
	 * Loads the keywords which are no keywords of the publication
	 * 
	 * @return the result string
	 */
	public String loadKeywordsNotInPublication() {
		keywordList = publicationService
				.searchAllKeywordsNotInPublication(publicationId);
		return SUCCESS;
	}

	/**
	 * Loads the authors which are no authors of the publication
	 * 
	 * @return the result string
	 */
	public String loadAuthorsNotInPublication() {
		authorList = publicationService
				.searchAllAuthorNotInPublication(publicationId);
		return SUCCESS;
	}

	/**
	 * Loads the keywords which are keywords of the publication
	 * 
	 * @return the result string
	 */
	public String loadKeywordsInPublication() {
		keywordList = new ArrayList<Keyword>();
		keywordList.addAll(publicationService.loadPublication(publicationId)
				.getKeywords());
		return SUCCESS;
	}

	/**
	 * Loads the authors which are authors of the publication
	 * 
	 * @return the result string
	 */
	public String loadAuthorsInPublication() {
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
