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
	private Integer matrikelnumber;

	/** The lender service. */
	private LenderService lenderService;

	/**
	 * Saves the Lender to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		lenderService.saveLender(lender);
		return SUCCESS;
	}

	/**
	 * Deletes the selected lender from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		lender = lenderService.loadLender(matrikelnumber);
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
		lender = lenderService.loadLender(matrikelnumber);
		return SUCCESS;
	}

	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
//		 If the Lender is not set, the publication ID has to be set.
		if (lender == null && matrikelnumber == null) {
			addActionError(getText("msg.selectPublication"));
		}
	}

	public Lender getLender() {
		return lender;
	}

	public void setLender(Lender lender) {
		this.lender = lender;
	}
	

	public Integer getMatrikelnumber() {
		return matrikelnumber;
	}

	public void setMatrikelnumber(Integer matrikelnumber) {
		this.matrikelnumber = matrikelnumber;
	}

	public void setLenderService(
			LenderService lenderService) {
		this.lenderService = lenderService;
	}



	
}
