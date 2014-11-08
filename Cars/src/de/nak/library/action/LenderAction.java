package de.nak.library.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.Lender;
import de.nak.library.service.LenderService;
import de.nak.library.service.LendingService;

/**
 * Action for a single lender.
 * 
 * @author Niels Gundermann
 */
public class LenderAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;

	/** The current lender. */
	private Lender lender;

	/** The lender's identifier selected by the user. */
	private Long lenderId;

	/** The lender service. */
	private LenderService lenderService;

	/** The lending service */
	private LendingService lendingService;

	/**
	 * Saves the Lender to the database if possible.
	 * 
	 * @return the result string.
	 */
	public String save() {
		Lender lenderWithNewMatriculationNumber = lenderService
				.searchLenderByMatriculationNumber(lender.getMatriculationNumber());
		if (lenderWithNewMatriculationNumber == null || lenderWithNewMatriculationNumber.getLenderId() == lender.getLenderId()) {
			lenderService.saveLender(lender);
			return SUCCESS;
		} else {
			addActionError(getText("msg.matriculationNumberNotAvailable"));
			return INPUT;
		}
	}

	/**
	 * Deletes the selected lender from the database.
	 * 
	 * @return the result string.
	 */
	public String delete() {
		lender = lenderService.loadLender(lenderId);
		if (lender != null) {
			if (!lendingService.searchByLender(lender).isEmpty()) {
				addActionError(getText("msg.lenderInUse"));
				return INPUT;
			}
			lenderService.deleteLender(lender);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected lender in the lender form.
	 * 
	 * @return the result string.
	 */
	public String load() {
		lender = lenderService.loadLender(lenderId);
		return SUCCESS;
	}

	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		// If the Lender is not set, the lender ID has to be set.
		if (lender == null && lenderId == null) {
			addActionError(getText("msg.selectLender"));
		}
	}

	public Lender getLender() {
		return lender;
	}

	public void setLender(Lender lender) {
		this.lender = lender;
	}

	public void setLenderService(LenderService lenderService) {
		this.lenderService = lenderService;
	}

	public void setLendingService(LendingService lendingService) {
		this.lendingService = lendingService;
	}

	public Long getLenderId() {
		return lenderId;
	}

	public void setLenderId(Long lenderId) {
		this.lenderId = lenderId;
	}

}
