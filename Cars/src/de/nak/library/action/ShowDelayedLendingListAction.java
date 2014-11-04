package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Lending;
import de.nak.library.service.LendingService;

/**
 * Action that shows a list of failures.
 *
 * @author Niels Gundermann
 */
public class ShowDelayedLendingListAction implements Action {

	/** The list of late lendings. */
	private List<Lending> lendingList;

	/** The lending service. */
	private LendingService lendingService;

	@Override
	public String execute() throws Exception {
//		lendingList = lendingService.loadAllLendings();
		return SUCCESS;
	}

	public List<Lending> getFailureList() {
		return lendingList;
	}

	public void setFailureService(LendingService failureService) {
		this.lendingService = failureService;
	}
}
