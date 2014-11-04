package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Lending;
import de.nak.library.service.LendingService;

/**
 * Action that shows a list of Lending.
 *
 * @author Niels Gundermann
 */
public class ShowLendingListAction implements Action {
	
	/** The list of Lending. */
	private List<Lending> lendingList;

	/** The Lending service. */
	private LendingService lendingService;

	@Override
	public String execute() throws Exception {
		lendingList = lendingService.loadAllLendings();
		return SUCCESS;
	}

	public List<Lending> getLendingList() {
		return lendingList;
	}

	public void setLendingService(LendingService LendingService) {
		this.lendingService = LendingService;
	}
	
	
}