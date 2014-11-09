package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.Publication;
import de.nak.library.model.Publisher;
import de.nak.library.service.PublicationService;
import de.nak.library.service.PublisherService;

/**
 * Action for a single publication.
 * 
 * @author Niels Gundermann
 */
public class PublisherAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;

	/** The current publisher. */
	private Publisher publisher;

	/** The publisher's identifier selected by the user. */
	private Long publisherId;

	/** The publisher service. */
	private PublisherService publisherService;

	/** The publication service */
	private PublicationService publicationService;

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	/**
	 * Saves the publisher to the database.
	 * 
	 * @return the result string.
	 */
	public String save() {
		Publisher publisherWithSameName = publisherService
				.searchByName(publisher.getPublisherName());
		if (publisherWithSameName != null
				&& publisherWithSameName.getPublisherId() != publisher
						.getPublisherId()) {
			addActionError(getText("msg.publisherNameAlreadyExists"));
			return INPUT;
		}
		publisherService.savePublisher(publisher);
		return SUCCESS;
	}

	/**
	 * Deletes the selected Publisher from the database.
	 * 
	 * @return the result string.
	 */
	public String delete() {
		publisher = publisherService.loadPublisher(publisherId);
		if (publisher != null) {
			List<Publication> publicationResults = publicationService
					.searchByPublisherId(publisherId);
			if (!publicationResults.isEmpty()) {
				addActionError(getText("msg.publisherInUse"));
				return INPUT;
			}
			publisherService.deletePublisher(publisher);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected publisher in the publisher form.
	 * 
	 * @return the result string.
	 */
	public String load() {
		publisher = publisherService.loadPublisher(publisherId);
		return SUCCESS;
	}

	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		// If the Publisher is not set, the publisher ID has to be set.
		if (publisher == null && publisherId == null) {
			addActionError(getText("msg.selectPublisher"));
		}
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher Publisher) {
		this.publisher = Publisher;
	}

	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

}
