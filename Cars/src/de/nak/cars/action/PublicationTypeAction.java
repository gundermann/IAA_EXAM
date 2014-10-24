package de.nak.cars.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.cars.model.PublicationType;
import de.nak.cars.service.PublicationTypeService;

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
	private Long publicatioTypenId;

	/** The publicationtype service. */
	private PublicationTypeService publicationTypeService;

	/**
	 * Saves the publicationtype to the database.
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
		publicationType = publicationTypeService.loadPublicationType(publicatioTypenId);
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
		publicationType = publicationTypeService.loadPublicationType(publicatioTypenId);
		return SUCCESS;
	}

	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
//		 If the publicationtype is not set, the publication ID has to be set.
		if (publicationType == null && publicatioTypenId == null) {
			addActionError(getText("msg.selectPublication"));
		}
	}

	public PublicationType getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(PublicationType publicationType) {
		this.publicationType = publicationType;
	}

	public Long getPublicatioTypenId() {
		return publicatioTypenId;
	}

	public void setPublicatioTypenId(Long publicatioTypenId) {
		this.publicatioTypenId = publicatioTypenId;
	}

	public void setPublicationTypeService(
			PublicationTypeService publicationTypeService) {
		this.publicationTypeService = publicationTypeService;
	}



	
}
