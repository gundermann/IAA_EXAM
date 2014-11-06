package de.nak.library.action;

import de.nak.library.model.Publication;



/**
 * Action that shows a list of PublicationTypes.
 *
 * @author Niels Gundermann
 */
public class ShowPublicationTypeSetupForPublicationAction extends ShowPublicationTypeListAction {

	private Long publicationId;
	
	private Publication publication;
	
	

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
	
	
	

	
	
}
