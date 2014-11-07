package de.nak.library.action;

import de.nak.library.model.Publication;

/**
 * Action that shows a list of PublicationTypes to set it on publication.
 *
 * @author Niels Gundermann
 */
public class ShowPublicationTypeSetupForPublicationAction extends
		ShowPublicationTypeListAction {

	/** The publication's identifier selected by the user */
	private Long publicationId;
	/** The publication */
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
