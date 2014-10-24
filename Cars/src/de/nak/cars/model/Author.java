package de.nak.cars.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Author entity.
 * 
 * @author Christian Leppelt
 */
public class Author {
	/** The identifier. */
	private Long authorId;
	/** The authors name. */
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long keywordId) {
		this.authorId = keywordId;
	}

	@Column(length = 50, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
