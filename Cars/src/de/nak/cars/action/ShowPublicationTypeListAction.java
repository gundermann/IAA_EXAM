package de.nak.cars.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.cars.model.PublicationType;
import de.nak.cars.service.PublicationTypeService;

/**
 * Action that shows a list of PublicationTypes.
 *
 * @author Niels Gundermann
 */
public class ShowPublicationTypeListAction implements Action {
	/** The list of PublicationTypes. */
	private List<PublicationType> publicationTypeList;

	/** The PublicationType service. */
	private PublicationTypeService publicationTypeService;

	@Override
	public String execute() throws Exception {
//		PublicationTypeList = PublicationTypeService.loadAllPublicationTypes();
		return SUCCESS;
	}

	public List<PublicationType> getPublicationTypeList() {
		return publicationTypeList;
	}

	public void setPublicationTypeService(PublicationTypeService PublicationTypeService) {
		this.publicationTypeService = PublicationTypeService;
	}
}
