package de.nak.library.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.Publication;
import de.nak.library.service.LendingService;
import de.nak.library.service.PublicationService;

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

	/** The IDs of the selected authors to delete or to add */
	private Long[] authorId;

	/** The IDs of the selected keywords to delete or to add */
	private Long[] keywordId;

	/** The ID of a new publication type */
	private Long publicationTypeId;

	/** THe ID of a new publisher */
	private Long publisherId;

	/** The Lending service */
	private LendingService lendingService;

	/**
	 * Adds the selected keywords to the publication keywords
	 * 
	 * @return the result string
	 */
	public String addKeywords() {
		if (keywordId == null) {
			addActionError(getText("msg.selectKeyword"));
			return INPUT;
		}
		publication = publicationService.loadPublication(publicationId);
		publicationService.addKeywords(publication, keywordId);
		publicationService.savePublication(publication);
		return SUCCESS;
	}

	/**
	 * Deletes the selected keywords from the publication keyword
	 * 
	 * @return the result string
	 */
	public String deleteKeywords() {
		if (keywordId == null) {
			addActionError(getText("msg.selectKeyword"));
			return INPUT;
		}
		publication = publicationService.loadPublication(publicationId);
		if(publication.getKeywords().size() == keywordId.length){
			addActionError("msg.oneKeywordHasToBeSet");
			return INPUT;
		}
		publicationService.deleteKeywords(publication, keywordId);
		publicationService.savePublication(publication);
		return SUCCESS;
	}

	/**
	 * Adds the selected authors to the publication keywords
	 * 
	 * @return the result string
	 */
	public String addAuthors() {
		if (authorId == null) {
			addActionError(getText("msg.selectAuthor"));
			return INPUT;
		}
		publication = publicationService.loadPublication(publicationId);
		publicationService.addAuthors(publication, authorId);
		publicationService.savePublication(publication);
		return SUCCESS;
	}

	/**
	 * Deletes the selected authors from the publication keyword
	 * 
	 * @return the result string
	 */
	public String deleteAuthors() {
		if (authorId == null) {
			addActionError(getText("msg.selectAuthor"));
			return INPUT;
		}
		publication = publicationService.loadPublication(publicationId);
		if(publication.getAuthors().size() == authorId.length){
			addActionError("msg.oneAuthorHasToBeSet");
			return INPUT;
		}
		publicationService.deleteAuthors(publication, authorId);
		publicationService.savePublication(publication);
		return SUCCESS;
	}

	/**
	 * Saves the selected publisher as new publisher for the publication
	 * 
	 * @return the result string
	 */
	public String saveEditedPublisher() {
		if (publisherId == null) {
			addActionError(getText("msg.selectPublisher"));
			return INPUT;
		}
		publication = publicationService.loadPublication(publicationId);
		publicationService.editPublisher(publication, publisherId);
		publicationService.savePublication(publication);
		return SUCCESS;
	}

	/**
	 * Saves the selected publication type as new publisher for the publication
	 * 
	 * @return the result string
	 */
	public String saveEditedPublicationType() {
		if (publicationTypeId == null) {
			addActionError(getText("msg.selectPublicationType"));
			return INPUT;
		}
		publication = publicationService.loadPublication(publicationId);
		publicationService.editPublicationType(publication, publicationTypeId);
		publicationService.savePublication(publication);
		return SUCCESS;
	}

	/**
	 * Saves the publication to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		if (inputForNewPublicationValid()) {
			publication = publicationService.setupPublication(publication,
					authorId, keywordId, publicationTypeId, publisherId);
			publicationService.savePublication(publication);
			return SUCCESS;
		} else
			return INPUT;
	}

	/**
	 * Saves the edited values of publication excepted authors, keyword,
	 * publisher and publication type
	 * 
	 * @return the result string.
	 * */
	public String saveEditing() {
		Publication publicationWithSameNakId = publicationService
				.searchByNakId(publication.getNakId());
		if (publicationWithSameNakId != null
				&& publicationWithSameNakId.getPublicationId() != publicationId) {
			addActionError(getText("msg.matriculationNumberNotAvailable"));
			return INPUT;
		}
		Publication publicationFromDB = publicationService
				.loadPublication(publicationId);
		publication.setPublicationId(publicationId);
		publication.setAuthors(publicationFromDB.getAuthors());
		publication.setKeywords(publicationFromDB.getKeywords());
		publication.setPublicationType(publicationFromDB.getPublicationType());
		publication.setPublisher(publicationFromDB.getPublisher());
		publicationService.savePublication(publication);
		return SUCCESS;
	}

	/**
	 * Validates if the input for a new publication is valid
	 * 
	 * @return valid
	 */
	private boolean inputForNewPublicationValid() {
		boolean isValid = true;
		if (authorId == null || authorId.length == 0) {
			addActionError(getText("msg.selectAuthor"));
			isValid = false;
		}
		if (publicationTypeId == null) {
			addActionError(getText("msg.selectPublicationType"));
			isValid = false;
		}
		if (publisherId == null) {
			addActionError(getText("msg.selectPublisher"));
			isValid = false;
		}
		if (keywordId == null) {
			addActionError(getText("msg.selectKeyword"));
			isValid = false;
		}
		Publication publicationWithNakId = publicationService
				.searchByNakId(publication.getNakId());
		if (publicationWithNakId != null) {
			addActionError(getText("msg.msg.matriculationNumberNotAvailable"));
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Deletes the selected publication from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		publication = publicationService.loadPublication(publicationId);
		if (publication != null) {
			if (!lendingService.searchByPublication(publication).isEmpty()) {
				addActionError(getText("msg.publicationUsedInLending"));
				return INPUT;
			}
			publicationService.deletePublication(publication);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected publication in the publication form.
	 *
	 * @return the result string.
	 */
	public String load() {
		publication = publicationService.loadPublication(publicationId);
		return SUCCESS;
	}

	/**
	 * Cancel the setup for publication
	 * 
	 * @return the result string
	 */
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

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	public void setKeywordId(Long[] keywordId) {
		this.keywordId = keywordId;
	}

	public void setPublicationTypeId(Long publicationTypeId) {
		this.publicationTypeId = publicationTypeId;
	}

	public void setAuthorId(Long[] authorId) {
		this.authorId = authorId;
	}

	public void setLendingService(LendingService lendingService) {
		this.lendingService = lendingService;
	}
	
	
}
