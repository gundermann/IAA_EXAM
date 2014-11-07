package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Lending;
import de.nak.library.service.LendingService;

/**
 * Action that shows a list of delayed lendings.
 * 
 * @author Niels Gundermann
 */
public class ShowDelayedLendingListAction implements Action {

	/** The list of delayed lendings. */
	private List<Lending> delayedLendingList;

	/** The Lending service. */
	private LendingService lendingService;

	@Override
	public String execute() throws Exception {
		delayedLendingList = lendingService.searchDelayedLendings();
		return SUCCESS;
	}

	public List<Lending> getDelayedLendingList() {
		return delayedLendingList;
	}

	public void setLendingService(LendingService lendingService) {
		this.lendingService = lendingService;
	}

}
