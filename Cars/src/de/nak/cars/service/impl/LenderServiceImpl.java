package de.nak.cars.service.impl;

import java.util.List;

import de.nak.cars.dao.LenderDAO;
import de.nak.cars.model.Lender;
import de.nak.cars.service.LenderService;

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
	public Lender loadLender(Integer matriculationNumber) {
		return lenderDAO.load(matriculationNumber);
	}

	@Override
	public void deleteLender(Lender lender) {
		lenderDAO.delete(lender);
	}

	@Override
	public List<Lender> loadAllLenders() {
		return lenderDAO.loadAll();
	}

	public void setLenderDAO(LenderDAO lenderDAO) {
		this.lenderDAO = lenderDAO;
	}

}
