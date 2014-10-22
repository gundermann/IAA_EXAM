package de.nak.cars.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Typ for publications.
 * @author Kathrin Kurtz
 *
 */
@Entity
public class PublicationType {
	/** The identifier. */
	private long publicationTypeId;
	/** The name of the publication type. */
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getPublicationTypeId() {
		return publicationTypeId;
	}
	public void setPublicationTypeId(long publicationTypeId) {
		this.publicationTypeId = publicationTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
