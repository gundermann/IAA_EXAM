package de.nak.library.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.AdmonitionProcess;
import de.nak.library.service.AdmonitionProcessService;

/**
 * Action for a single AdmonitionProcess.
 *
 * @author Niels Gundermann
 */
public class AdmonitionProcessAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;

	/** The current AdmonitionProcess. */
	private AdmonitionProcess admonitionProcess;

	/** The lending's identifier selected by the user. */
	private Long lendingId;

	/** The AdmonitionProcess service. */
	private AdmonitionProcessService admonitionProcessService;

	/**
	 * Adds an Admonition to an AdmonitionProcess
	 * 
	 * @return the return string
	 */
	public String addAdmonition() {
		AdmonitionProcess admonitionProcess = admonitionProcessService
				.searchByLending(lendingId);
		if (admonitionProcess == null) {
			addActionError(getText("msg.noAdmonitionProcessFound"));
			return INPUT;
		}
		if (admonitionProcess.getAdmonitions() != null
				&& admonitionProcess.getAdmonitions().size() == 3) {
			addActionError(getText("msg.maximumOfAdmonitionReached"));
			return INPUT;
		}
		admonitionProcess = admonitionProcessService
				.addAdmonition(admonitionProcess);
		admonitionProcessService.saveAdmonitionProcess(admonitionProcess);
		return SUCCESS;
	}

	/**
	 * Creates an admonition process for the selected lending.
	 * 
	 * @return the result string
	 */
	public String createAdmonitionProcess() {
		if(admonitionProcessService.searchByLending(lendingId) != null){
			addActionError(getText("msg.admonitionProcessAlreadyExists"));
			return INPUT;
		}
		AdmonitionProcess admonitionProcess = admonitionProcessService.createAdmonitionProcess(lendingId);
		admonitionProcessService.saveAdmonitionProcess(admonitionProcess);
		return SUCCESS;
	}

	@Override
	public void validate() {
		// the lending ID has to be set.
		if (lendingId == null) {
			addActionError(getText("msg.selectPublication"));
		}
	}

	public AdmonitionProcess getAdmonitionProcess() {
		return admonitionProcess;
	}

	public void setAdmonitionProcess(AdmonitionProcess admonitionProcess) {
		this.admonitionProcess = admonitionProcess;
	}

	public void setAdmonitionProcessService(
			AdmonitionProcessService admonitionProcessService) {
		this.admonitionProcessService = admonitionProcessService;
	}

	public Long getLendingId() {
		return lendingId;
	}

	public void setLendingId(Long lendingId) {
		this.lendingId = lendingId;
	}

}
