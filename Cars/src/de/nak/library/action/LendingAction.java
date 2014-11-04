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

	/** The lender's identifier selected by the user. */
	private Long lenderId;

	private Long lendingId;

	private Lending lending;

	private LendingService lendingService;

	private Long publicationId;

	/**
	 * Saves the Lending to the database if possible.
	 * 
	 * @return the result string.
	 */
	public String save() {
		lending = new Lending();
		lending = lendingService.initializeLending(lending, lenderId, publicationId);
		lendingService.saveLending(lending);
		return SUCCESS;
	}
	
	/**
	 * Recalculates the returning date of the lending.
	 * 
	 * @return the result string.
	 */
	public String extend(){
		load();
		lendingService.extend(lending);
		lendingService.saveLending(lending);
		return SUCCESS;
	}

	/**
	 * Finishes the selected lending from the database.
	 * 
	 * @return the result string.
	 */
	public String finishLendingByReturn() {
		lending = lendingService.loadLending(lendingId);
		if (lending != null) {
			lendingService.finishLendingIfReturned(lending);
		}
		return SUCCESS;
	}
	
	/**
	 * Finishes the selected lending from the database.
	 * 
	 * @return the result string.
	 */
	public String finishLendingByLoss() {
		lending = lendingService.loadLending(lendingId);
		if (lending != null) {
			lendingService.finishLendingIfLost(lending);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected publication in the lending form.
	 * 
	 * @return the result string.
	 */
	public String load() {
		lending = lendingService.loadLending(lendingId);
		return SUCCESS;
	}

	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		if(lendingId != null){
			return;
		}
		else if(lendingId == null){
			addActionError("msg.selectLending");
		}else if(lenderId == null){
			addActionError("msg.selectLender");
		}else if(publicationId == null){
			addActionError("msg.selectPublication");
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
