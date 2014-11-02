package de.nak.cars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Lender of Publications.
 * 
 * @author Kathrin Kurtz
 */
@Entity
public class Lender {

	/** The id of the lender. */
	private Long lenderId;
	/** The matriculation number of the lender. */
	private Integer matriculationNumber;
	/** First Name of the lender. */
	private String firstName;
	/** Last Name of the lender. */
	private String lastName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getLenderId() {
		return lenderId;
	}

	public void setLenderId(Long lenderId) {
		this.lenderId = lenderId;
	}

	@Column(unique = true, nullable = false, length = 4)
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
