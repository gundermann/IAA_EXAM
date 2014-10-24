package de.nak.cars.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Typ for publications.
 * 
 * @author Kathrin Kurtz
 * 
 */
public class PublicationType {
	/** The identifier. */
	private Long publicationTypeId;
	/** The name of the publication type. */
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPublicationTypeId() {
		return publicationTypeId;
	}

	public void setPublicationTypeId(Long publicationTypeId) {
		this.publicationTypeId = publicationTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
