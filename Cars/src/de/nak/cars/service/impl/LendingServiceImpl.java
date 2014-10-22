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

	@Override
	public List<Lending> loadOpenLendings() {
		return lendingDAO.searchByOutgoDate(calculateDate4WeeksAgo());
	}

	@Override
	public void adjustReturnDate(Lending lending) {
		Calendar calendar = getCalendar(lending.getOutgoDate());
		calendar.add(Calendar.DATE, 28);
		for (int i = 0; i < lending.getNumberOfLendingExtensions(); i++) {
			calendar.add(Calendar.DATE, 14);
		}
		lending.setExpectedReturnDate(calendar.getTime());
	}

	public void setLendingDAO(LendingDAO lendingDAO) {
		this.lendingDAO = lendingDAO;
	}

	private Integer calculateDate4WeeksAgo() {
		Calendar calendar = getCalendar(null);
		calendar.add(Calendar.DATE, -28);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String datumString = dateFormat.format(calendar.getTime());
		return Integer.valueOf(datumString);
	}

	/**
	 * Returns an instance of Calendar.class with the delivered date as date. If
	 * the date parameter is null the current system date will be used.
	 * 
	 * @param initialDate
	 *            The initial date of the created calendar.
	 * @return an instance of Calendar.class with the delivered date as date
	 */
	private Calendar getCalendar(Date initialDate) {
		Calendar calendar = Calendar.getInstance();
		if (initialDate == null) {
			Date now = new GregorianCalendar().getTime();
			calendar.setTime(now);
		} else {
			calendar.setTime(initialDate);
		}
		return calendar;
	}

}
