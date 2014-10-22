package de.nak.cars.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Keyword entity.
 * @author Kathrin Kurtz
 *
 */
@Entity
public class Keyword {
	/** The identifier. */
	private long keywordId;
	/** The keyword String. */
	private String keyword;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(long keywordId) {
		this.keywordId = keywordId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
