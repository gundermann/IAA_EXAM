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

	/** The publication service. */
	private PublicationTypeService publicationTypeService;

	/**
	 * Saves the publication to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
//		publicationTypeService.savePublication(publicationType);
		return SUCCESS;
	}

	/**
	 * Deletes the selected publication from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
//		publicationType = publicationTypeService.loadPublication(publicatioTypenId);
//		if (publicationType != null) {
//			publicationTypeService.deletePublication(publicationType);
//		}
		return SUCCESS;
	}

	/**
	 * Displays the selected publication in the publicaiton form.
	 *
	 * @return the result string.
	 */
	public String load() {
//		publicationType = publicationTypeService.loadPublication(publicatioTypenId);
		return SUCCESS;
	}

	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		// If the publication is not set, the publication ID has to be set.
//		if (publicationType == null && publicatioTypenId == null) {
//			addActionError(getText("msg.selectPublication"));
//		}
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
