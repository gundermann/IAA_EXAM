package de.nak.library.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.Publication;
import de.nak.library.service.PublicationService;

/**
 * Action for a single publication.
 *
 * @author Niels Gundermann
 */


//TODO separieren
public class PublicationAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;

	/** The current publication. */
	private Publication publication;

	/** The publication's identifier selected by the user. */
	private Long publicationId;

	/** The publication service. */
	private PublicationService publicationService;

	private Long[] authorId;

	private Long[] keywordId;
	
	private Long[] authorToDeleteId;

	private Long[] keywordToDeleteId;

	private Long publicationTypeId;

	private Long publisherId;

	public Long[] getAuthorToDeleteId() {
		return authorToDeleteId;
	}

	public void setAuthorToDeleteId(Long[] authorToDeleteId) {
		this.authorToDeleteId = authorToDeleteId;
	}

	public Long[] getKeywordToDeleteId() {
		return keywordToDeleteId;
	}

	public void setKeywordToDeleteId(Long[] keywordToDeleteId) {
		this.keywordToDeleteId = keywordToDeleteId;
	}

	public String addKeywords(){
		if(keywordId == null){
			addActionError("msg.selectKeyword");
			return INPUT;
		}
		publication = publicationService.loadPublication(publicationId);
		publicationService.addKeywords(publication, keywordId);
		publicationService.savePublication(publication);
		return SUCCESS;
	}
	
	public String deleteKeywords(){
		if(keywordToDeleteId == null){
			addActionError("msg.selectKeyword");
			return INPUT;
		}
		publication = publicationService.loadPublication(publicationId);
		publicationService.deleteKeywords(publication, keywordToDeleteId);
		publicationService.savePublication(publication);
		return SUCCESS;
	}
	
	public String addAuthors(){
		if(authorId == null){
			addActionError("msg.selectAuthor");
			return INPUT;
		}
		publication = publicationService.loadPublication(publicationId);
		publicationService.addAuthors(publication, authorId);
		publicationService.savePublication(publication);
		return SUCCESS;
	}
	
	public String deleteAuthors(){
		if(authorToDeleteId == null){
			addActionError("msg.selectAuthor");
			return INPUT;
		}
		publication = publicationService.loadPublication(publicationId);
		publicationService.deleteAuthors(publication, authorToDeleteId);
		publicationService.savePublication(publication);
		return SUCCESS;
	}
	
	public String saveEditedPublisher(){
		if(publisherId == null){
			addActionError("msg.selectPublisher");
			return INPUT;
		}
		publication = publicationService.loadPublication(publicationId);
		publicationService.setPublisherForPublication(publication, publisherId);
		publicationService.savePublication(publication);
		return SUCCESS;
	}
	
	public String saveEditedPublicationType(){
		if(publicationTypeId == null){
			addActionError("msg.selectPublicationType");
			return INPUT;
		}
		publication = publicationService.loadPublication(publicationId);
		publicationService.setPublicationTypeForPublication(publication, publicationTypeId);
		publicationService.savePublication(publication);
		return SUCCESS;
	}
	
	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	public Long[] getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(Long[] keywordId) {
		this.keywordId = keywordId;
	}

	public Long getPublicationTypeId() {
		return publicationTypeId;
	}

	public void setPublicationTypeId(Long publicationTypeId) {
		this.publicationTypeId = publicationTypeId;
	}

	public Long[] getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long[] authorId) {
		this.authorId = authorId;
	}

	/**
	 * Saves the publication to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		if (inputValid()) {
			publication = publicationService.setupPublication(publication,
					authorId, keywordId, publicationTypeId, publisherId);
			publicationService.savePublication(publication);
			return SUCCESS;
		} else
			return INPUT;
	}
	
	public String saveEditing(){
		Publication publicationFromDB = publicationService.loadPublication(publicationId);
		publication.setPublicationId(publicationId);
		publication.setAuthors(publicationFromDB.getAuthors());
		publication.setKeywords(publicationFromDB.getKeywords());
		publication.setPublicationType(publicationFromDB.getPublicationType());
		publication.setPublisher(publicationFromDB.getPublisher());
		publicationService.savePublication(publication);
		return SUCCESS;
	}
	
	public String deleteKeyword(){
		if(keywordId.length == 0){
			addActionError("msg.selectKeyword");
			return INPUT;
		}
		publication.getKeywords().remove(keywordId[0]);
		publicationService.savePublication(publication);
		publication = publicationService.loadPublication(publicationId);
		return SUCCESS;
	}

	/**
	 * Validates if the input for a new publication is valid
	 * 
	 * @return
	 */
	private boolean inputValid() {
		boolean isValid = true;
		if (authorId == null || authorId.length == 0) {
			addActionError("msg.selectAuthor");
			isValid = false;
		}
		if (publicationTypeId == null) {
			addActionError("msg.selectPublicationType");
			isValid = false;
		}
		if (publisherId == null) {
			addActionError("msg.selectPublisher");
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
//		if (publication == null && publicationId == null) {
//			addActionError(getText("msg.selectPublication"));
//		}
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
