package de.nak.cars.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import de.nak.cars.dao.AdmonitionProcessDAO;
import de.nak.cars.model.Admonition;
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
	public AdmonitionProcess addAdmonition(AdmonitionProcess admonitionProcess) {
		Admonition admonition = new Admonition();
		admonition.setAdmonitionprocess(admonitionProcess);
		admonition.setCreationDay(Calendar.getInstance().getTime());
		Set<Admonition> admonitions = admonitionProcess.getAdmonitions();
		admonitions.add(admonition);
		admonitionProcess.setAdmonitions(admonitions);
		return admonitionProcess;
	}

	@Override
	public Integer getAdmonitionCount(Long admonitionProcessId) {
		AdmonitionProcess admonitionProcess = admonitionProcessDAO
				.load(admonitionProcessId);
		return admonitionProcess.getAdmonitions().size();
	}

	public void setAdmonitionProcessDAO(
			AdmonitionProcessDAO admonitionProcessDAO) {
		this.admonitionProcessDAO = admonitionProcessDAO;
	}

}
