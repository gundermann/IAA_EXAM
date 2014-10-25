package de.nak.cars.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Lending entity.
 * 
 * @author Christian Leppelt
 */
@Entity
public class Lending {
	/** The identifier. */
	private Long lendingId;
	// /** The lended publication. */
	// private Publication publication;
	/** The date the publication was lent */
	private Date outgoDate;
	// /** The person who lent the publication */
	// private Lender lender;
	/** Day when the publication should be returned. */
	private Date expectedReturnDate;
	/** Indicates how often the lending has been extended. */
	private Integer numberOfLendingExtensions;

	public Long getId() {
		return lendingId;
	}

	public void setId(Long id) {
		this.lendingId = id;
	}

	// public Publication getPublication() {
	// return publication;
	// }
	//
	// public void setPublication(Publication publication) {
	// this.publication = publication;
	// }

	public Date getOutgoDate() {
		return outgoDate;
	}

	public void setOutgoDate(Date outgoDate) {
		this.outgoDate = outgoDate;
	}

	// public Lender getLender() {
	// return lender;
	// }
	//
	// public void setLender(Lender lender) {
	// this.lender = lender;
	// }

	@Column(name = "return_date")
	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public Integer getNumberOfLendingExtensions() {
		return numberOfLendingExtensions;
	}

	public void setNumberOfLendingExtensions(Integer numberOfLendingExtensions) {
		this.numberOfLendingExtensions = numberOfLendingExtensions;
	}

}
