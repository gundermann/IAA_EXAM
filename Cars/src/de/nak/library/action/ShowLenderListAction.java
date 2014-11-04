package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Lender;
import de.nak.library.service.LenderService;

/**
 * Action that shows a list of Lenders.
 *
 * @author Niels Gundermann
 */
public class ShowLenderListAction implements Action {
	/** The list of Lenders. */
	private List<Lender> lenderList;

	/** The Lender service. */
	private LenderService lenderService;

	@Override
	public String execute() throws Exception {
		lenderList = lenderService.loadAllLenders();
		return SUCCESS;
	}

	public List<Lender> getLenderList() {
		return lenderList;
	}

	public void setLenderService(LenderService lenderService) {
		this.lenderService = lenderService;
	}
}