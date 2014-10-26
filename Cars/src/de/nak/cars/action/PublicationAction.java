package de.nak.cars.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.cars.model.Publication;
import de.nak.cars.service.PublicationService;

/**
 * Action for a single publication.
 *
 * @author Niels Gundermann
 */
public class PublicationAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;

	/** The current publication. */
	private Publication publication;

	/** The publication's identifier selected by the user. */
	private Long publicationId;

	/** The publication service. */
	private PublicationService publicationService;

	/**
	 * Saves the publication to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		publicationService.savePublication(publication);
		return SUCCESS;
	}

	/**
	 * Deletes the selected publication from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		publication = publicationService.loadPublication(publicationId);
		if (publication != null) {
			publicationService.deletePublication(publication);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected publication in the publicaiton form.
	 *
	 * @return the result string.
	 */
	public String load() {
		publication = publicationService.loadPublication(publicationId);
		return SUCCESS;
	}

	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		// If the publication is not set, the publication ID has to be set.
		if (publication == null && publicationId == null) {
			addActionError(getText("msg.selectPublication"));
		}
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
