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

	/** The AdmonitionProcess's identifier selected by the user. */
	private Long admonitionProcessId;

	/** The AdmonitionProcess service. */
	private AdmonitionProcessService admonitionProcessService;

	/**
	 * Saves the AdmonitionProcess to the database if possible.
	 * 
	 * @return the result string.
	 */
	public String save() {
		admonitionProcessService.saveAdmonitionProcess(admonitionProcess);
		return SUCCESS;
	}
	
	public String deleteLastAdmonitionProcess(){
		if(admonitionProcessService.countAdmonitions(admonitionProcessId) == 0 ){
			addActionError("msg.hasNoAdmonition");
			return INPUT;
		}
		return SUCCESS;
	}

	public String addAdmonitionProcess(){
		if(admonitionProcessService.countAdmonitions(admonitionProcessId) == 3){
			addActionError("msg.maximumOfAdmonitionReached");
			return INPUT;
		}
		admonitionProcess = admonitionProcessService.addAdmonition(admonitionProcess);
		admonitionProcessService.saveAdmonitionProcess(admonitionProcess);
		return SUCCESS;
	}
	
	/**
	 * Deletes the selected AdmonitionProcess from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		admonitionProcess = admonitionProcessService.loadAdmonitionProcess(admonitionProcessId);
		if (admonitionProcess != null) {
			admonitionProcessService.deleteAdmonitionProcess(admonitionProcess);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected publication in the AdmonitionProcess form.
	 *
	 * @return the result string.
	 */
	public String load() {
		admonitionProcess = admonitionProcessService.loadAdmonitionProcess(admonitionProcessId);
		return SUCCESS;
	}

	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		// If the AdmonitionProcess is not set, the publication ID has to be set.
		if (admonitionProcess == null && admonitionProcessId == null) {
			addActionError(getText("msg.selectPublication"));
		}
	}

	public AdmonitionProcess getAdmonitionProcess() {
		return admonitionProcess;
	}

	public void setAdmonitionProcess(AdmonitionProcess admonitionProcess) {
		this.admonitionProcess = admonitionProcess;
	}

	public void setAdmonitionProcessService(AdmonitionProcessService admonitionProcessService) {
		this.admonitionProcessService = admonitionProcessService;
	}

	public Long getAdmonitionProcessId() {
		return admonitionProcessId;
	}

	public void setAdmonitionProcessId(Long admonitionProcessId) {
		this.admonitionProcessId = admonitionProcessId;
	}

}
