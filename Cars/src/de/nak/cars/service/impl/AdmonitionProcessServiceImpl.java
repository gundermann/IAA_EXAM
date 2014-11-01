package de.nak.cars.service.impl;

import java.util.List;

import de.nak.cars.dao.AdmonitionProcessDAO;
import de.nak.cars.model.AdmonitionProcess;
import de.nak.cars.model.Lending;
import de.nak.cars.service.AdmonitionProcessService;

/**
 * The admonition process service implementation class.
 * 
 * @admonitionProcess Christian Leppelt
 */
public class AdmonitionProcessServiceImpl implements AdmonitionProcessService {
	/** The admonitionProcess DAO. */
	private AdmonitionProcessDAO admonitionProcessDAO;

	@Override
	public void saveAdmonitionProcess(AdmonitionProcess admonitionProcess) {
		admonitionProcessDAO.save(admonitionProcess);
	}

	@Override
	public AdmonitionProcess loadAdmonitionProcess(Long admonitionProcessId) {
		return admonitionProcessDAO.load(admonitionProcessId);
	}

	@Override
	public void deleteAdmonitionProcess(AdmonitionProcess admonitionProcess) {
		admonitionProcessDAO.delete(admonitionProcess);
	}

	@Override
	public List<AdmonitionProcess> loadAllAdmonitionProcesss() {
		return admonitionProcessDAO.loadAll();
	}

	@Override
	public List<AdmonitionProcess> searchByLending(Lending lending) {
		return admonitionProcessDAO.load(lending);
	}

	@Override
	public void addAdmonition(AdmonitionProcess admonitionProcess) {
		admonitionProcessDAO.createAdmonition();
	}

	@Override
	public int getAdmonitionCount(Long admonitionProcessId) {
		return admonitionProcessDAO.loadAdmonitionCount(admonitionProcessId);
	}

	public void setAdmonitionProcessDAO(
			AdmonitionProcessDAO admonitionProcessDAO) {
		this.admonitionProcessDAO = admonitionProcessDAO;
	}

}
