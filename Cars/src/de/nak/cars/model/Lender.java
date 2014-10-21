package de.nak.cars.model;

/**
 * Lender of Publications.
 * 
 * @author Kathrin Kurtz
 */
public class Lender {
	
	/** First Name of the lender. */
	private String firstName;
	/** Last Name of the lender. */
	private String lastName;
	/** The Matrikelnumber of the lender. */
	private int matrikelnumber;
	
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
	public int getMatrikelnumber() {
		return matrikelnumber;
	}
	
	public void setMatrikelnumber(int matrikelnumber) {
		this.matrikelnumber = matrikelnumber;
	}

}
