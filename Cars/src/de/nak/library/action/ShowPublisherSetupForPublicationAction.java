package de.nak.library.action;

import de.nak.library.model.Publication;

/**
 * Action that shows a list of publishers to set on publication.
 *
 * @author Niels Gundermann
 */
public class ShowPublisherSetupForPublicationAction extends
		ShowPublisherListAction {

	/** The publication's identifier */
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
