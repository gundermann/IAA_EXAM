package de.nak.library.model;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result
				+ ((keywordId == null) ? 0 : keywordId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Keyword other = (Keyword) obj;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (keywordId == null) {
			if (other.keywordId != null)
				return false;
		} else if (!keywordId.equals(other.keywordId))
			return false;
		return true;
	}

}
