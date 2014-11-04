package de.nak.cars.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.cars.model.Lending;
import de.nak.cars.service.LendingService;

/**
 * Action that shows a list of failures.
 *
 * @author Niels Gundermann
 */
public class ShowDelayedLendingListAction implements Action {

	/** The list of AdmonitionProcesss. */
	private List<Lending> delayedLendingList;

	/** The AdmonitionProcess service. */
	private LendingService lendingService;

	
	@Override
	public String execute() throws Exception {
//		delayedLendingList = lendingService.searchDelayedLendings();
		return SUCCESS;
	}


	public List<Lending> getDelayedLendingList() {
		return delayedLendingList;
	}


	public void setLendingService(LendingService lendingService) {
		this.lendingService = lendingService;
	}

	
	

}
