package de.nak.library.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Publication;
import de.nak.library.searchModel.PublicationSearchCriteria;
import de.nak.library.service.PublicationService;

/**
 * Action that shows a search result list of Publication.
 * 
 * @author Niels Gundermann
 */
public class ShowPublicationSearchResultListAction implements Action {

	/** The criteria for publication search */
	private PublicationSearchCriteria criteria;

	/** The list of Publication. */
	private List<Publication> publicationList;

	/** The Publication service. */
	private PublicationService publicationService;

	@Override
	public String execute() throws Exception {
		//If no criteria show all
		if (criteria == null) {
			publicationList = publicationService.loadAllPublications();
		}
		//If isbn is set, search by isbn
		else if (criteria.getIsbn() != null
				&& !criteria.getIsbn().equals("")) {
			publicationList = new ArrayList<Publication>();
			publicationList = publicationService.searchPublicationByIsbn(Long
					.valueOf(criteria.getIsbn()));
		} 
		//search usual
		else {
			publicationList = publicationService
					.searchPublications(criteria);
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
}
