package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.AdmonitionProcess;
import de.nak.library.service.AdmonitionProcessService;

/**
 * Action that shows a list of admontion processes.
 *
 * @author Niels Gundermann
 */
public class ShowAdmonitionProcessListAction implements Action {

	/** The list of AdmonitionProcesss. */
	private List<AdmonitionProcess> admonitionProcessList;

	/** The AdmonitionProcess service. */
	private AdmonitionProcessService admonitionProcessService;

	
	@Override
	public String execute() throws Exception {
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

}
