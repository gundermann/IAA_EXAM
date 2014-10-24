package de.nak.cars.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.cars.model.Keyword;
import de.nak.cars.service.KeywordService;

/**
 * Action that shows a list of PublicationTypes.
 *
 * @author Niels Gundermann
 */
public class ShowKeywordListAction implements Action {
	/** The list of PublicationTypes. */
	private List<Keyword> keywordList;

	/** The PublicationType service. */
	private KeywordService keywordService;

	@Override
	public String execute() throws Exception {
//		PublicationTypeList = PublicationTypeService.loadAllPublicationTypes();
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
