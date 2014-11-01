package de.nak.cars.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.cars.model.Publication;
import de.nak.cars.service.PublicationService;

/**
 * Action that shows a list of PublicationTypes.
 *
 * @author Niels Gundermann
 */
public class ShowPublicationListAction implements Action {
	/** The list of PublicationTypes. */
	private List<Publication> publicationList;

	/** The PublicationType service. */
	private PublicationService publicationService;

	@Override
	public String execute() throws Exception {
		publicationList = publicationService.loadAllPublications();
		return SUCCESS;
	}

	public List<Publication> getPublicationList() {
		return publicationList;
	}

	public void setPublicationService(PublicationService PublicationService) {
		this.publicationService = PublicationService;
	}
}
