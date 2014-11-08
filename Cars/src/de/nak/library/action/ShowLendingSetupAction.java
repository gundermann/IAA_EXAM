package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Lender;
import de.nak.library.model.Publication;
import de.nak.library.service.LenderService;
import de.nak.library.service.LendingService;

/**
 * The Action that shows the setup for a lending.
 * 
 * @author Niels Gundermann
 */
public class ShowLendingSetupAction implements Action {

	/** The lending service */
	private LendingService lendingService;
	/** The list of publications */
	private List<Publication> publicationList;
	/** The lender service */
	private LenderService lenderService;
	/** The list of publications */
	private List<Lender> lenderList;

	@Override
	public String execute() throws Exception {
		lenderList = lenderService.loadAllLenders();
		publicationList = lendingService.searchAllAvailablePublications();
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

	public void setLenderService(LenderService lenderService) {
		this.lenderService = lenderService;
	}

	public void setLendingService(LendingService lendingService) {
		this.lendingService = lendingService;
	}

}
