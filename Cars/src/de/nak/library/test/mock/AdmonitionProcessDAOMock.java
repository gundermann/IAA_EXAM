package de.nak.library.test.mock;

import java.util.List;

import de.nak.library.dao.AdmonitionProcessDAO;
import de.nak.library.model.AdmonitionProcess;
import de.nak.library.model.Lending;

/**
 * The admonition process dao mock class.
 * 
 * @author Christian Leppelt
 */
public class AdmonitionProcessDAOMock extends AdmonitionProcessDAO {

	@Override
	public void save(AdmonitionProcess admonitionProcess) {

	}

	@Override
	public AdmonitionProcess load(Long id) {
		return null;
	}

	@Override
	public void delete(AdmonitionProcess admonitionProcess) {

	}

	@Override
	public List<AdmonitionProcess> loadAll() {
		return null;
	}

	@Override
	public AdmonitionProcess loadByLending(Lending lending) {
		return null;
	}

}
