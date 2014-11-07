package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Publication;
import de.nak.library.service.PublicationService;

/**
 * Action that shows a list of Publications.
 *
 * @author Niels Gundermann
 */
public class ShowPublicationListAction implements Action {
	/** The list of Publications. */
	private List<Publication> publicationList;

	/** The Publication service. */
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
