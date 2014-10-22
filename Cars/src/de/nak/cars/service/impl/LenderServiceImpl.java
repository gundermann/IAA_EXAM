package de.nak.cars.service.impl;

import java.util.List;

import de.nak.cars.dao.LenderDAO;
import de.nak.cars.model.Lender;
import de.nak.cars.service.LenderService;

public class LenderServiceImpl implements LenderService {
	/** The lender DAO. */
	private LenderDAO lenderDAO;

	@Override
	public void saveLender(Lender lender) {
		lenderDAO.save(lender);
	}

	@Override
	public Lender loadLender(Integer matrikelnumber) {
		return lenderDAO.load(matrikelnumber);
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
