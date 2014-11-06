package de.nak.library.test.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.nak.library.dao.AdmonitionProcessDAO;
import de.nak.library.model.Admonition;
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
		if (id == null)
			return null;
		AdmonitionProcess admonitionProcess = new AdmonitionProcess();
		Set<Admonition> admonitions = new HashSet<Admonition>();
		for (int i = 0; i < id; i++) {
			Admonition admonition = new Admonition();
			admonition.setAdmonitionId(id);
			admonitions.add(admonition);
		}
		admonitionProcess.setAdmonitions(admonitions);
		return admonitionProcess;
	}

	@Override
	public void delete(AdmonitionProcess admonitionProcess) {

	}

	@Override
	public List<AdmonitionProcess> loadAll() {
		return null;
	}

	@Override
	public List<AdmonitionProcess> load(Lending lending) {
		return new ArrayList<AdmonitionProcess>();
	}

}
