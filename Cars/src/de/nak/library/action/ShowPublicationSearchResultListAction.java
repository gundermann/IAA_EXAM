package de.nak.library.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Publication;
import de.nak.library.searchModel.SearchPublication;
import de.nak.library.service.PublicationService;

/**
 * Action that shows a search result list of Publication.
 * 
 * @author Niels Gundermann
 */
public class ShowPublicationSearchResultListAction implements Action {

	/** The criteria for publication search */
	private SearchPublication publication;

	/** The list of Publication. */
	private List<Publication> publicationList;

	/** The Publication service. */
	private PublicationService publicationService;

	@Override
	public String execute() throws Exception {
		//If no criteria show all
		if (publication == null) {
			publicationList = publicationService.loadAllPublications();
		}
		//If isbn is set, search by isbn
		else if (publication.getIsbn() != null
				&& !publication.getIsbn().equals("")) {
			publicationList = new ArrayList<Publication>();
			publicationList = publicationService.searchPublicationByIsbn(Long
					.valueOf(publication.getIsbn()));
		} 
		//search usual
		else {
			publicationList = publicationService
					.searchPublications(publication);
		}
		return SUCCESS;
	}

	public List<Publication> getPublicationList() {
		return publicationList;
	}

	public SearchPublication getPublication() {
		return publication;
	}

	public void setPublication(SearchPublication publication) {
		this.publication = publication;
	}

	public void setPublicationService(PublicationService PublicationService) {
		this.publicationService = PublicationService;
	}
}
