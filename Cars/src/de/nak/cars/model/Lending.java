package de.nak.cars.model;

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
	private Long lendingId;
	/** The lended publication. */
	private Publication publication;
	/** The date the publication was lent */
	private Date outgoDate;
	/** The ID of the person who lent the publication */
	private Long lenderID;
	/** Day when the publication should be returned. */
	private Date expectedReturnDate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return lendingId;
	}

	public void setId(Long id) {
		this.lendingId = id;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublicationID(Publication publication) {
		this.publication = publication;
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


	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	// TODO: return date anpassen
//	
//	public Date getReturnDate() {
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(outgoDate);
//		cal.add(Calendar.DATE, 14);
//		return cal.getTime();
//	}
//
//	/**
//	 * Returns the output date as java.util.date.
//	 * 
//	 * @return the date the publication was lent.
//	 * 
//	 */
//	public Date getOutgoDateAsDate() {
//		try {
//			String dateString = String.valueOf(getOutgoDate());
//			return getDateFormatter().parse(dateString);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * Returns the return date as java.util.date.
//	 * 
//	 * @return the date the publication has to be brought back.
//	 */
//	public Date getReturnDateAsDate() {
//		try {
//			String dateString = String.valueOf(getOutgoDate());
//			Date outgoDate = getDateFormatter().parse(dateString);
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(outgoDate);
//			calendar.add(Calendar.DATE, 14);
//			return calendar.getTime();
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	private DateFormat getDateFormatter() {
//		if (dateFormat == null)
//			dateFormat = new SimpleDateFormat("yyyyMMdd");
//		return dateFormat;
//	}
//	
}
