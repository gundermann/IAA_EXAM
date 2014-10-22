package de.nak.cars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Keyword entity.
 * 
 * @author Kathrin Kurtz
 * 
 */
@Entity
public class Keyword {
	/** The identifier. */
	private Long keywordId;
	/** The keyword String. */
	private String keyword;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(Long keywordId) {
		this.keywordId = keywordId;
	}

	@Column(length = 50, nullable = false)
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
