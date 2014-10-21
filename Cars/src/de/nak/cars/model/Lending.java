package de.nak.cars.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Lending entity.
 * 
 * @author Christian Leppelt
 */
@Entity
public class Lending {
	/** The identifier. */
	private Long id;
	/** The ID of the lended publication. */
	private Long publicationID;
	/** The date the publication was lent */
	private Date outgoDate;
	/** The ID of the person who lent the publication */
	private Long lenderID;
	/** Day when the publication should be returned. */
	private Date expectedReturnDate;
	/** The dateFormat to convert from java.util.date to String. */
	private DateFormat dateFormat;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	// TODO: return date anpassen
	public Date getReturnDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(outgoDate);
		cal.add(Calendar.DATE, 14);
		return cal.getTime();
	}

	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	/**
	 * Returns the output date as java.util.date.
	 * 
	 * @return the date the publication was lent.
	 * 
	 */
	public Date getOutgoDateAsDate() {
		try {
			String dateString = String.valueOf(getOutgoDate());
			return getDateFormatter().parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns the return date as java.util.date.
	 * 
	 * @return the date the publication has to be brought back.
	 */
	public Date getReturnDateAsDate() {
		try {
			String dateString = String.valueOf(getOutgoDate());
			Date outgoDate = getDateFormatter().parse(dateString);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(outgoDate);
			calendar.add(Calendar.DATE, 14);
			return calendar.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private DateFormat getDateFormatter() {
		if (dateFormat == null)
			dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat;
	}

}
