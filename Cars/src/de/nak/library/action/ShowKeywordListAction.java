package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Keyword;
import de.nak.library.service.KeywordService;

/**
 * Action that shows a list of PublicationTypes.
 *
 * @author Niels Gundermann
 */
public class ShowKeywordListAction implements Action {
	/** The list of keywords. */
	private List<Keyword> keywordList;

	/** The keyword service. */
	private KeywordService keywordService;

	@Override
	public String execute() throws Exception {
		keywordList = keywordService.loadAllKeywords();
		return SUCCESS;
	}

	public List<Keyword> getKeywordList() {
		return keywordList;
	}

	public void setKeywordList(List<Keyword> keywordList) {
		this.keywordList = keywordList;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

	
	
}
