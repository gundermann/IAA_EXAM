package de.nak.library.service;

import java.util.List;

import de.nak.library.model.Keyword;

/**
 * Keyword service interface.
 * 
 * @author Christian Leppelt
 */
public interface KeywordService {

	/**
	 * Creates or updates a keyword.
	 * 
	 * @param keyword
	 *            The keyword.
	 */
	void saveKeyword(Keyword keyword);

	/**
	 * Loads a single keyword.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a keyword or null.
	 */
	Keyword loadKeyword(Long id);

	/**
	 * Deletes the given keyword.
	 * 
	 * @param keyword
	 *            The keyword.
	 */
	void deleteKeyword(Keyword keyword);

	/**
	 * Loads a list of all keywords.
	 * 
	 * @return a list which is empty if no keyword was found.
	 */
	List<Keyword> loadAllKeywords();

	/**
	 * Searches for a keyword by a given name.
	 * 
	 * @param keywordName
	 *            The keyword name.
	 * @return a keyword. Returns null if no keyword was found.
	 */
	Keyword searchByName(String keywordName);

}
