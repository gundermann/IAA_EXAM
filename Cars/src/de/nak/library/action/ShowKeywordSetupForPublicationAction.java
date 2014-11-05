package de.nak.library.action;

import de.nak.library.model.Publication;
import de.nak.library.service.PublicationService;



/**
 * Action that shows a list of PublicationTypes.
 *
 * @author Niels Gundermann
 */
public class ShowKeywordSetupForPublicationAction extends ShowKeywordListAction {

	private Long publicationId;
	
	private Publication publication;
	
	private PublicationService publicationService;
	

	@Override
	public String execute() throws Exception {
		super.execute();
		publication = publicationService.loadPublication(publicationId);
		return SUCCESS;
	}
	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public Long getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(Long publicationId) {
		this.publicationId = publicationId;
	}
	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}
	
	
	

	
	
}
