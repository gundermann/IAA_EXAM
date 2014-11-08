package de.nak.library.test.mock;

import java.util.List;

import de.nak.library.dao.AdmonitionDAO;
import de.nak.library.model.Admonition;

/**
 * The admonition dao mock class.
 * 
 * @author Christian Leppelt
 */
public class AdmonitionDAOMock extends AdmonitionDAO {

	@Override
	public void save(Admonition admonition) {

	}

	@Override
	public Admonition load(Long id) {
		return null;
	}

	@Override
	public void delete(Admonition admonition) {

	}

	@Override
	public List<Admonition> loadAll() {
		return null;
	}
}
