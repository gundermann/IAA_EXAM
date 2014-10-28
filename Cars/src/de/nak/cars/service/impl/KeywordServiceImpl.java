package de.nak.cars.service.impl;

import java.util.List;

import de.nak.cars.dao.KeywordDAO;
import de.nak.cars.model.Keyword;
import de.nak.cars.service.KeywordService;

/**
 * The keyword process service implementation class.
 * 
 * @author Christian Leppelt
 */
public class KeywordServiceImpl implements KeywordService {
	
	private KeywordDAO keywordDAO = new KeywordDAO();
	
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

	public void setKeywordDAO(KeywordDAO keywordDao) {
		this.keywordDAO = keywordDao;
	}
	
	

}
