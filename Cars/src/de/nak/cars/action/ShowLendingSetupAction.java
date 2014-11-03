package de.nak.cars.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.cars.model.Lender;
import de.nak.cars.model.Publication;
import de.nak.cars.service.LenderService;
import de.nak.cars.service.PublicationService;

/**
 *
 * @author Niels Gundermann
 */
public class ShowLendingSetupAction implements Action {

	private PublicationService publicationService;

	private List<Publication> publicationList;

	private LenderService lenderService;

	private List<Lender> lenderList;

	@Override
	public String execute() throws Exception {
		lenderList = lenderService.loadAllLenders();
		// TODO hier bietet sich eine Methode an, die nur die Publikationen
		// zurück gibt, die auch ausgeliehen werden können
		// publicationList = publicationService.loadAllAvailablePublications();
		publicationList = publicationService.loadAllPublications();
		return SUCCESS;
	}

	public List<Publication> getPublicationList() {
		return publicationList;
	}

	public void setPublicationList(List<Publication> publicationList) {
		this.publicationList = publicationList;
	}

	public List<Lender> getLenderList() {
		return lenderList;
	}

	public void setLenderList(List<Lender> lenderList) {
		this.lenderList = lenderList;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public void setLenderService(LenderService lenderService) {
		this.lenderService = lenderService;
	}

}
