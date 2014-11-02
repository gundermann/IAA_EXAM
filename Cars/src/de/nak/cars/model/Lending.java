package de.nak.cars.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Lending entity.
 * 
 * @author Christian Leppelt
 */
@Entity
public class Lending {
	/** The identifier. */
	private Long lendingId;
	/** The lended publication. */
	private Publication publication;
	/** The date the publication was lent */
	private Date outgoDate;
	/** The person who lent the publication */
	private Lender lender;
	/** Day when the publication should be returned. */
	private Date expectedReturnDate;
	/** Indicates how often the lending has been extended. */
	private Integer numberOfLendingExtensions;

	@Id
	@Column(name = "LENDING_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getLendingId() {
		return lendingId;
	}

	public void setLendingId(Long lendingId) {
		this.lendingId = lendingId;
	}

	public Date getOutgoDate() {
		return outgoDate;
	}

	public void setOutgoDate(Date outgoDate) {
		this.outgoDate = outgoDate;
	}

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

	@OneToOne
	@PrimaryKeyJoinColumn
	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public Lender getLender() {
		return lender;
	}

	public void setLender(Lender lender) {
		this.lender = lender;
	}

}
