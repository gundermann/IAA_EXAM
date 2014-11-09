package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.Publication;
import de.nak.library.model.PublicationType;
import de.nak.library.service.PublicationService;
import de.nak.library.service.PublicationTypeService;

/**
 * Action for a single publication.
 * 
 * @author Niels Gundermann
 */
public class PublicationTypeAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;

	/** The current publication type. */
	private PublicationType publicationType;

	/** The publication type's identifier selected by the user. */
	private Long publicationTypeId;

	/** The publication type service. */
	private PublicationTypeService publicationTypeService;
	
	/** The publication service */
	private PublicationService publicationService;
	
	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}


	/**
	 * Saves the publication type to the database.
	 * 
	 * @return the result string.
	 */
	public String save() {
		PublicationType publicationTypeWithSameName = publicationTypeService.searchByName(publicationType.getName());
		if (publicationTypeWithSameName != null
				&& (publicationTypeId == null || publicationTypeWithSameName.getPublicationTypeId() != publicationTypeId)) {
			addActionError(getText("msg.publicationTypeNameAlreadyExists"));
			return INPUT;
		}
		publicationTypeService.savePublicationType(publicationType);
		return SUCCESS;
	}

	/**
	 * Deletes the selected publicationtype from the database.
	 * 
	 * @return the result string.
	 */
	public String delete() {
		publicationType = publicationTypeService.loadPublicationType(publicationTypeId);
		if (publicationType != null) {
			List<Publication> publicationResults = publicationService.searchByPublicationTypeId(publicationTypeId);
			if (!publicationResults.isEmpty()) {
				addActionError(getText("msg.publicationTypeInUse"));
				return INPUT;
			}
			publicationTypeService.deletePublicationType(publicationType);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected publication type in the publication type form.
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
		// If the publication type is not set, the publication type ID has to be set.
		if (publicationType == null && publicationTypeId == null) {
			addActionError(getText("msg.selectPublicationType"));
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
