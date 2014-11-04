package de.nak.library.service.impl;

import java.util.List;

import de.nak.library.dao.AdmonitionDAO;
import de.nak.library.model.Admonition;
import de.nak.library.service.AdmonitionService;

/**
 * The admonition service implementation class.
 * 
 * @admonition Christian Leppelt
 */
public class AdmonitionServiceImpl implements AdmonitionService {
	/** The admonition DAO. */
	private AdmonitionDAO admonitionDAO;

	@Override
	public void saveAdmonition(Admonition admonition) {
		admonitionDAO.save(admonition);
	}

	@Override
	public Admonition loadAdmonition(Long admonitionId) {
		return admonitionDAO.load(admonitionId);
	}

	@Override
	public void deleteAdmonition(Admonition admonition) {
		admonitionDAO.delete(admonition);
	}

	@Override
	public List<Admonition> loadAllAdmonitions() {
		return admonitionDAO.loadAll();
	}

	public void setAdmonitionDAO(AdmonitionDAO admonitionDAO) {
		this.admonitionDAO = admonitionDAO;
	}

}