package de.nak.library.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.Publication;
import de.nak.library.model.PublicationSearchCriteria;
import de.nak.library.service.PublicationService;

/**
 * Action that shows a search result list of Publication.
 * 
 * @author Niels Gundermann
 */
public class PublicationSearchResultAction extends ActionSupport {

	/** The Version UID */
	private static final long serialVersionUID = 4039539746540010170L;

	/** The criteria for publication search */
	private PublicationSearchCriteria criteria;

	/** The list of Publication. */
	private List<Publication> publicationList;

	/** The Publication service. */
	private PublicationService publicationService;

	/**
	 * Search for publication
	 * 
	 * @return the result string.
	 * */
	public String find() {
		publicationList = publicationService.searchPublications(criteria);
		return SUCCESS;
	}

	/**
	 * Search for publication by isbn.
	 * 
	 * @return the result string
	 */
	public String findByIsbn() {
		if (criteria.getIsbn().equals("")) {
			publicationList = publicationService.loadAllPublications();
			return SUCCESS;
		} else {
			try {
				Long.valueOf(criteria.getIsbn());
			} catch (NumberFormatException nfe) {
				addActionError(getText("msg.noValidISBN"));
				return INPUT;
			}
			publicationList = new ArrayList<Publication>();
			publicationList = publicationService.searchPublicationByIsbn(Long
					.valueOf(criteria.getIsbn()));
		}
		return SUCCESS;
	}

	public List<Publication> getPublicationList() {
		return publicationList;
	}

	public PublicationSearchCriteria getPublication() {
		return criteria;
	}

	public void setPublication(PublicationSearchCriteria publication) {
		this.criteria = publication;
	}

	public void setPublicationService(PublicationService PublicationService) {
		this.publicationService = PublicationService;
	}

	public PublicationSearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(PublicationSearchCriteria criteria) {
		this.criteria = criteria;
	}

}
