package de.nak.cars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Lender of Publications.
 * 
 * @author Kathrin Kurtz
 */
@Entity
public class Lender {

	/** The matriculation number of the lender. */
	private Integer matriculationNumber;
	/** First Name of the lender. */
	private String firstName;
	/** Last Name of the lender. */
	private String lastName;

	@Id
	public int getMatriculationNumber() {
		return matriculationNumber;
	}

	public void setMatriculationNumber(int matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}

	@Column
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
