package de.nak.cars.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Id;

/**
 * Lending entity.
 * 
 * @author Christian Leppelt
 */
public class Lending {
	/** The identifier. */
	private Long id;
	/** The ID of the lended publication. */
	private Long publicationID;
	/** The date the publication was lent */
	private Date outgoDate;
	/** The ID of the person who lent the publication */
	private Long lenderID;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPublicationID() {
		return publicationID;
	}

	public void setPublicationID(Long publicationID) {
		this.publicationID = publicationID;
	}

	public Date getOutgoDate() {
		return outgoDate;
	}

	public void setOutgoDate(Date outgoDate) {
		this.outgoDate = outgoDate;
	}

	public Long getLenderID() {
		return lenderID;
	}

	public void setLender(Long lenderID) {
		this.lenderID = lenderID;
	}

	public Date getReturnDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(outgoDate);
		cal.add(Calendar.DATE, 14);
		return cal.getTime();
	}

}
