package de.nak.cars.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import de.nak.cars.dao.LendingDAO;
import de.nak.cars.model.Lending;
import de.nak.cars.service.LendingService;

/**
 * The lending service implementation class.
 * 
 * @author Christian Leppelt
 */
public class LendingServiceImpl implements LendingService {
	/** The lending DAO. */
	private LendingDAO lendingDAO;

	@Override
	public void saveLending(Lending lending) {
		lendingDAO.save(lending);
	}

	@Override
	public Lending loadLending(Long id) {
		return lendingDAO.load(id);
	}

	@Override
	public void deleteLending(Lending lending) {
		lendingDAO.delete(lending);
	}

	@Override
	public List<Lending> loadAllLendings() {
		return lendingDAO.loadAll();
	}

	public void setLendingDAO(LendingDAO lendingDAO) {
		this.lendingDAO = lendingDAO;
	}

	@Override
	public List<Lending> loadOpenLendings() {
		return lendingDAO.searchByOutgoDate(calculateDate2WeeksAgo());
	}

	private Integer calculateDate2WeeksAgo() {
		Date now = new GregorianCalendar().getTime();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, -14);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String datumString = dateFormat.format(calendar.getTime());
		return Integer.valueOf(datumString);
	}
}
