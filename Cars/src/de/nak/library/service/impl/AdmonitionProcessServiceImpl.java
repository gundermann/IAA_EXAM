package de.nak.library.service.impl;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import de.nak.library.dao.AdmonitionProcessDAO;
import de.nak.library.model.Admonition;
import de.nak.library.model.AdmonitionProcess;
import de.nak.library.service.AdmonitionProcessService;
import de.nak.library.service.AdmonitionService;

/**
 * The admonition process service implementation class.
 * 
 * @author Christian Leppelt
 */
public class AdmonitionProcessServiceImpl implements AdmonitionProcessService {
	/** The admonition process DAO. */
	private AdmonitionProcessDAO admonitionProcessDAO;
	/** The admonition service. */
	private AdmonitionService admonitionService;

	@Override
	public void saveAdmonitionProcess(AdmonitionProcess admonitionProcess) {
		admonitionProcessDAO.save(admonitionProcess);
	}

//	@Override
//	public AdmonitionProcess loadAdmonitionProcess(Long admonitionProcessId) {
//		return admonitionProcessDAO.load(admonitionProcessId);
//	}

	@Override
	public void deleteAdmonitionProcess(AdmonitionProcess admonitionProcess) {
		Set<Admonition> admonitions = admonitionProcess.getAdmonitions();
		for (Admonition admonition : admonitions)
			admonitionService.deleteAdmonition(admonition);
		admonitionProcessDAO.delete(admonitionProcess);
	}

//	@Override
//	public List<AdmonitionProcess> loadAllAdmonitionProcesss() {
//		return admonitionProcessDAO.loadAll();
//	}

//	@Override
//	public AdmonitionProcess searchByLending(Lending lending) {
//		return admonitionProcessDAO.loadByLending(lending);
//	}

//	@Override
//	public AdmonitionProcess searchByLendingID(Long lendingId) {
//		return admonitionProcessDAO.loadByLendingID(lendingId);
//	}

	@Override
	public AdmonitionProcess addAdmonition(AdmonitionProcess admonitionProcess) {
		Admonition admonition = createAdmonition(admonitionProcess);
		Set<Admonition> admonitions = admonitionProcess.getAdmonitions();
		if (admonitions == null)
			admonitions = new HashSet<Admonition>();
		admonitions.add(admonition);
		admonitionProcess.setAdmonitions(admonitions);
		return admonitionProcess;
	}

//	@Override
//	public Integer countAdmonitions(Long admonitionProcessId) {
//		AdmonitionProcess admonitionProcess = admonitionProcessDAO
//				.load(admonitionProcessId);
//		if (admonitionProcess == null)
//			return null;
//		return admonitionProcess.getAdmonitions().size();
//	}

	public void setAdmonitionProcessDAO(
			AdmonitionProcessDAO admonitionProcessDAO) {
		this.admonitionProcessDAO = admonitionProcessDAO;
	}

	public void setAdmonitionService(AdmonitionService admonitionService) {
		this.admonitionService = admonitionService;
	}

	private Admonition createAdmonition(AdmonitionProcess admonitionProcess) {
		Admonition admonition = new Admonition();
		admonition.setAdmonitionProcess(admonitionProcess);
		admonition.setCreationDay(new GregorianCalendar().getTime());
		admonitionService.saveAdmonition(admonition);
		return admonition;
	}

}
