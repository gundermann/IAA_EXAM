package de.nak.library.service.impl;

import java.util.List;

import de.nak.library.dao.LenderDAO;
import de.nak.library.model.Lender;
import de.nak.library.service.LenderService;

/**
 * The lender service implementation class.
 * 
 * @author Christian Leppelt
 */
public class LenderServiceImpl implements LenderService {
	/** The lender DAO. */
	private LenderDAO lenderDAO;

	@Override
	public void saveLender(Lender lender) {
		lenderDAO.save(lender);
	}

	@Override
	public Lender loadLender(Long lenderId) {
		return lenderDAO.load(lenderId);
	}

	@Override
	public void deleteLender(Lender lender) {
		lenderDAO.delete(lender);
	}

	@Override
	public List<Lender> loadAllLenders() {
		return lenderDAO.loadAll();
	}

	@Override
	public Lender searchLenderByMatriculationNumber(Integer matriculationNumber) {
		return lenderDAO.load(matriculationNumber);
	}

	public void setLenderDAO(LenderDAO lenderDAO) {
		this.lenderDAO = lenderDAO;
	}

}
