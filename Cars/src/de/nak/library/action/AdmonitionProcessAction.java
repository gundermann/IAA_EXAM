package de.nak.library.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.AdmonitionProcess;
import de.nak.library.model.Lending;
import de.nak.library.service.AdmonitionProcessService;
import de.nak.library.service.LendingService;

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

	/** The lending service. */
	private LendingService lendingService;

	/**
	 * Adds an Admonition to an AdmonitionProcess
	 * 
	 * @return the return string
	 */
	public String addAdmonition() {
		AdmonitionProcess admonitionProcess = lendingService.loadLending(
				lendingId).getAdmonitionProcess();
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
		if (lendingService.loadLending(lendingId).getAdmonitionProcess() != null) {
			addActionError(getText("msg.admonitionProcessAlreadyExists"));
			return INPUT;
		}
		AdmonitionProcess admonitionProcess = lendingService
				.createAdmonitionProcess(lendingId);
		admonitionProcessService.saveAdmonitionProcess(admonitionProcess);
		Lending lending = lendingService.loadLending(lendingId);
		lending.setAdmonitionProcess(admonitionProcess);
		lendingService.saveLending(lending);
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

	public void setLendingService(LendingService lendingService) {
		this.lendingService = lendingService;
	}

	public Long getLendingId() {
		return lendingId;
	}

	public void setLendingId(Long lendingId) {
		this.lendingId = lendingId;
	}

}
