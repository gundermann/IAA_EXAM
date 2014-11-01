package de.nak.cars.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.cars.model.Publication;
import de.nak.cars.service.PublicationService;

/**
 * Action that shows a list of PublicationTypes.
 *
 * @author Niels Gundermann
 */
public class ShowPublicationSearchResultListAction implements Action {

	private Publication publication;

	/** The list of PublicationTypes. */
	private List<Publication> publicationList;

	/** The PublicationType service. */
	private PublicationService publicationService;

	@Override
	public String execute() throws Exception {
		if (publication == null) {
			publicationList = publicationService.loadAllPublications();
		} else if (publication.getIsbn() != null) {
			publicationList = new ArrayList<Publication>();
			publicationList.add(publicationService
					.searchPublicationByIsbn(publication.getIsbn()));
		} else {
//			 publicationList =
//			 publicationService.searchPublications(publication.getTitle(),
//			 null, publication.getYearOfPublication(), publication.getPublisher(), publication.getPublicationType(), null);
		}
		return SUCCESS;
	}

	public List<Publication> getPublicationList() {
		return publicationList;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public void setPublicationService(PublicationService PublicationService) {
		this.publicationService = PublicationService;
	}
}
