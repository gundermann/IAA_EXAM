package de.nak.library.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.Lending;
import de.nak.library.service.LendingService;

/**
 * Action for a single lending.
 * 
 * @author Niels Gundermann
 */
public class LendingAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;

	/** The lender's identifier selected by the user for new lending. */
	private Long lenderId;

	/** The lending's identifier selected by the user. */
	private Long lendingId;

	/** The lending */
	private Lending lending;

	/** The lending service */
	private LendingService lendingService;

	/** The publication's identifier selected by the user for new lending. */
	private Long publicationId;

	/**
	 * Saves the Lending to the database if possible.
	 * 
	 * @return the result string.
	 */
	public String save() {
		if (isSetupValid()) {
			lending = lendingService.initializeLending(lending, lenderId,
					publicationId);
			lendingService.saveLending(lending);
			return SUCCESS;
		} else
			return INPUT;
	}

	/**
	 * Checks if the lender ID and publication ID is set.
	 * 
	 * @return valid
	 */
	private boolean isSetupValid() {
		boolean isValid = true;
		if (lenderId == null) {
			addActionError(getText("msg.selectLender"));
			isValid = false;
		}
		if (publicationId == null) {
			addActionError(getText("msg.selectPublication"));
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Recalculates the returning date of the lending.
	 * 
	 * @return the result string.
	 */
	public String extend() {
		lending = lendingService.loadLending(lendingId);
		if (lending.getNumberOfLendingExtensions() >= 2) {
			addActionError(getText("msg.noMoreExtension"));
			return INPUT;
		}
		lendingService.extend(lending);
		lendingService.saveLending(lending);
		return SUCCESS;
	}

	/**
	 * Finishes the selected lending from the database.
	 * 
	 * @return the result string.
	 */
	public String finishLendingIfReturned() {
		lending = lendingService.loadLending(lendingId);
		if (lending != null) {
			lendingService.deleteLending(lending);
		}
		return SUCCESS;
	}

	/**
	 * Finishes the selected lending from the database.
	 * 
	 * @return the result string.
	 */
	public String finishLendingIfLost() {
		lending = lendingService.loadLending(lendingId);
		if (lending.getAdmonitionProcess() == null
				|| (lending.getAdmonitionProcess() != null && lending
						.getAdmonitionProcess().getAdmonitions().size() < 3)) {
			addActionError(getText("msg.sendThreeAdmonitions"));
			return INPUT;
		}
		if (lending != null) {
			lendingService.finishLendingIfLost(lending);
		}
		return SUCCESS;
	}

	/** Cancels the setup form for lending. */
	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (lendingId == null) {
			addActionError(getText("msg.selectLending"));
		}
	}

	public Long getLenderId() {
		return lenderId;
	}

	public void setLenderId(Long lenderId) {
		this.lenderId = lenderId;
	}

	public Long getLendingId() {
		return lendingId;
	}

	public void setLendingId(Long lendingId) {
		this.lendingId = lendingId;
	}

	public Lending getLending() {
		return lending;
	}

	public void setLending(Lending lending) {
		this.lending = lending;
	}

	public Long getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(Long publicationId) {
		this.publicationId = publicationId;
	}

	public void setLendingService(LendingService lendingService) {
		this.lendingService = lendingService;
	}
}
