package de.nak.cars.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.cars.model.Keyword;
import de.nak.cars.service.KeywordService;

/**
 * Action for a single publication.
 *
 * @author Niels Gundermann
 */
public class KeywordAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;

	/** The current publication. */
	private Keyword keyword;

	/** The publication's identifier selected by the user. */
	private Long keywordId;

	/** The publication service. */
	private KeywordService keywordService;

	/**
	 * Saves the publication to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		keywordService.saveKeyword(keyword);
		return SUCCESS;
	}

	/**
	 * Deletes the selected publication from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		keyword = keywordService.loadKeyword(keywordId);
		if (keyword != null) {
			keywordService.deleteKeyword(keyword);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected publication in the publicaiton form.
	 *
	 * @return the result string.
	 */
	public String load() {
		keyword = keywordService.loadKeyword(keywordId);
		return SUCCESS;
	}

	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (keyword == null && keywordId == null) {
			addActionError(getText("msg.selectPublication"));
		}
	}

	public Keyword getKeyword() {
		return keyword;
	}

	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}

	public Long getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(Long keywordId) {
		this.keywordId = keywordId;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

	



	
}
