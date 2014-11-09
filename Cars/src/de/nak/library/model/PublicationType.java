package de.nak.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Enityt for types of publications.
 * 
 * @author Kathrin Kurtz
 * 
 */
@Entity
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

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
