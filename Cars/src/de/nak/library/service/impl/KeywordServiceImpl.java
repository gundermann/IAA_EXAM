package de.nak.library.service.impl;

import java.util.List;

import de.nak.library.dao.KeywordDAO;
import de.nak.library.model.Keyword;
import de.nak.library.service.KeywordService;

/**
 * The keyword process service implementation class.
 * 
 * @author Christian Leppelt
 */
public class KeywordServiceImpl implements KeywordService {
	/** The keyword DAO. */
	private KeywordDAO keywordDAO;

	@Override
	public void saveKeyword(Keyword keyword) {
		keywordDAO.save(keyword);
	}

	@Override
	public Keyword loadKeyword(Long id) {
		return keywordDAO.load(id);
	}

	@Override
	public void deleteKeyword(Keyword keyword) {
		keywordDAO.delete(keyword);
	}

	@Override
	public List<Keyword> loadAllKeywords() {
		return keywordDAO.loadAll();
	}

	public void setKeywordDAO(KeywordDAO keywordDAO) {
		this.keywordDAO = keywordDAO;
	}


}
