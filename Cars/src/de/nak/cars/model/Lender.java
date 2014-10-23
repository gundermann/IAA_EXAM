package de.nak.cars.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Lender of Publications.
 * 
 * @author Kathrin Kurtz
 */
@Entity
public class Lender {

	/** The Matrikelnumber of the lender. */
	private Integer matrikelnumber;
	/** First Name of the lender. */
	private String firstName;
	/** Last Name of the lender. */
	private String lastName;

	@Id
	public int getMatrikelnumber() {
		return matrikelnumber;
	}

	public void setMatrikelnumber(int matrikelnumber) {
		this.matrikelnumber = matrikelnumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
