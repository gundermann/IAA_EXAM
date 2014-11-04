package de.nak.library.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.PublicationType;
import de.nak.library.service.PublicationTypeService;

/**
 * Action for a single publication.
 * 
 * @author Niels Gundermann
 */
public class PublicationTypeAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;

	/** The current publication. */
	private PublicationType publicationType;

	/** The publication's identifier selected by the user. */
	private Long publicationTypeId;

	/** The publication type service. */
	private PublicationTypeService publicationTypeService;

	/**
	 * Saves the publication type to the database.
	 * 
	 * @return the result string.
	 */
	public String save() {
		publicationTypeService.savePublicationType(publicationType);
		return SUCCESS;
	}

	/**
	 * Deletes the selected publicationtype from the database.
	 * 
	 * @return the result string.
	 */
	public String delete() {
		publicationType = publicationTypeService
				.loadPublicationType(publicationTypeId);
		if (publicationType != null) {
			publicationTypeService.deletePublicationType(publicationType);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected publication in the publicaitontype form.
	 * 
	 * @return the result string.
	 */
	public String load() {
		publicationType = publicationTypeService
				.loadPublicationType(publicationTypeId);
		return SUCCESS;
	}

	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		// If the publicationtype is not set, the publication ID has to be set.
		if (publicationType == null && publicationTypeId == null) {
			addActionError(getText("msg.selectPublication"));
		}
	}

	public PublicationType getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(PublicationType publicationType) {
		this.publicationType = publicationType;
	}

	public Long getPublicationTypeId() {
		return publicationTypeId;
	}

	public void setPublicationTypeId(Long publicationTypeId) {
		this.publicationTypeId = publicationTypeId;
	}

	public void setPublicationTypeService(
			PublicationTypeService publicationTypeService) {
		this.publicationTypeService = publicationTypeService;
	}

}
