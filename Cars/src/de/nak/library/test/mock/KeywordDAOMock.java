package de.nak.library.test.mock;

import java.util.List;

import de.nak.library.dao.KeywordDAO;
import de.nak.library.model.Keyword;

/**
 * The keyword dao mock class.
 * 
 * @author Christian Leppelt
 */
public class KeywordDAOMock extends KeywordDAO {

	@Override
	public void save(Keyword keyword) {

	}

	@Override
	public Keyword load(Long id) {
		Keyword keyword = new Keyword();
		keyword.setKeywordId(id);
		return keyword;
	}

	@Override
	public void delete(Keyword keyword) {

	}

	@Override
	public List<Keyword> loadAll() {
		return null;
	}

	@Override
	public Keyword load(String name) {
		return null;
	}
}
