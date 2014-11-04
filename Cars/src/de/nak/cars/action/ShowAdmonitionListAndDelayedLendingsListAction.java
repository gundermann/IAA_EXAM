package de.nak.cars.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.cars.model.AdmonitionProcess;
import de.nak.cars.model.Lending;
import de.nak.cars.service.AdmonitionProcessService;
import de.nak.cars.service.LendingService;

/**
 * Action that shows a list of failures.
 *
 * @author Niels Gundermann
 */
public class ShowAdmonitionListAndDelayedLendingsListAction implements Action {

	/** The list of late lendings. */
	private List<Lending> lendingList;

	/** The lending service. */
	private LendingService lendingService;

	/** The list of AdmonitionProcesss. */
	private List<AdmonitionProcess> admonitionProcessList;

	/** The AdmonitionProcess service. */
	private AdmonitionProcessService admonitionProcessService;

	
	@Override
	public String execute() throws Exception {
		lendingList = lendingService.searchDelayedLendings();
		admonitionProcessList = admonitionProcessService.loadAllAdmonitionProcesss();
		return SUCCESS;
	}

	
	
	public List<AdmonitionProcess> getAdmonitionProcessList() {
		return admonitionProcessList;
	}



	public void setAdmonitionProcessService(
			AdmonitionProcessService admonitionProcessService) {
		this.admonitionProcessService = admonitionProcessService;
	}



	public List<Lending> getFailureList() {
		return lendingList;
	}

	public void setLendingService(LendingService lendingService) {
		this.lendingService = lendingService;
	}
}
