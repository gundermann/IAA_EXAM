package de.nak.cars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Publisher of publication.
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

	@Column
	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

}