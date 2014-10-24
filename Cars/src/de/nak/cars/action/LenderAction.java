package de.nak.cars.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.cars.model.Lender;
import de.nak.cars.service.LenderService;

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

	/**
	 * Saves the Lender to the database if possible.
	 * 
	 * @return the result string.
	 */
	public String save() {
		// TODO Matnr abfragen
		lenderService.saveLender(lender);
		return SUCCESS;
	}

	/**
	 * Deletes the selected lender from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		lender = lenderService.loadLender(lenderId);
		if (lender != null) {
			lenderService.deleteLender(lender);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected publication in the lender form.
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
		// If the Lender is not set, the publication ID has to be set.
		if (lender == null && lenderId == null) {
			addActionError(getText("msg.selectPublication"));
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

	public Long getLenderId() {
		return lenderId;
	}

	public void setLenderId(Long lenderId) {
		this.lenderId = lenderId;
	}

}
