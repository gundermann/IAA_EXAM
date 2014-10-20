package de.nak.cars.action;

import com.opensymphony.xwork2.Action;

/**
 * Action welche die Liste der Säumnisse anzeigt.
 *
 * @author Niels Gundermann
 */
public class ShowMainMenuAction implements Action {
//	private List<Borrow> borrowList;
//
//	private LateService lateService;

	@Override
	public String execute() throws Exception {
//		borrowList = lateService.loadAllLates();
		return SUCCESS;
	}

//	public List<Borrow> getCarList() {
//		return borrowList;
//	}
//
//	public void setCarService(LateService lateService) {
//		this.lateService = lateService;
//	}
}
