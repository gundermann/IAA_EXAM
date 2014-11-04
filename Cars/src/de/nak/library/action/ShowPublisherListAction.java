package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Publisher;
import de.nak.library.service.PublisherService;

/**
 * Action that shows a list of PublicationTypes.
 *
 * @author Niels Gundermann
 */
public class ShowPublisherListAction implements Action {
	/** The list of publisher. */
	private List<Publisher> publisherList;

	/** The publisher service. */
	private PublisherService publisherService;

	@Override
	public String execute() throws Exception {
		publisherList = publisherService.loadAllPublishers();
		return SUCCESS;
	}

	public List<Publisher> getPublisherList() {
		return publisherList;
	}

	public void setPublisherList(List<Publisher> publisherList) {
		this.publisherList = publisherList;
	}

	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	
	
}
