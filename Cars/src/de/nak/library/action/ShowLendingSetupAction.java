package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Lender;
import de.nak.library.model.Publication;
import de.nak.library.service.LenderService;
import de.nak.library.service.PublicationService;

/**
 * The Action that shows the setup for a lending.
 *
 * @author Niels Gundermann
 */
public class ShowLendingSetupAction implements Action {

	/** The publication service */
	private PublicationService publicationService;
	/** The list of publications */
	private List<Publication> publicationList;
	/** The lender service */
	private LenderService lenderService;
	/** The list of publications */
	private List<Lender> lenderList;

	@Override
	public String execute() throws Exception {
		lenderList = lenderService.loadAllLenders();
		// TODO hier bietet sich eine Methode an, die nur die Publikationen
		// zur�ck gibt, die auch ausgeliehen werden k�nnen
		 publicationList = publicationService.loadAllAvailablePublications();
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
