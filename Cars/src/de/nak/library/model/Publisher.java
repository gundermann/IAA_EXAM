package de.nak.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity for publisher of publication.
 * 
 * @author Kathrin Kurtz
 * 
 */
@Entity
public class Publisher {

	/** The id of the publisher. */
	private Long publisherId;
	/** Name of the publisher. */
	private String publisherName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	@Column(nullable = false)
	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

}
