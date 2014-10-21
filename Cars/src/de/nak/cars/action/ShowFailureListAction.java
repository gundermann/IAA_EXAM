package de.nak.cars.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.cars.model.Failure;
import de.nak.cars.service.FailureService;

/**
 * Action that shows a list of failures.
 *
 * @author Niels Gundermann
 */
public class ShowFailureListAction implements Action {
	/** The list of failures. */
	private List<Failure> failureList;

	/** The failure service. */
	private FailureService failureService;

	@Override
	public String execute() throws Exception {
//		failureList = failureService.loadAllFailures();
		return SUCCESS;
	}

	public List<Failure> getFailureList() {
		return failureList;
	}

	public void setFailureService(FailureService failureService) {
		this.failureService = failureService;
	}
}
