package de.nak.cars.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import de.nak.cars.dao.LendingDAO;
import de.nak.cars.model.AdmonitionProcess;
import de.nak.cars.model.Lending;
import de.nak.cars.model.Publication;
import de.nak.cars.service.LendingService;

/**
 * The lending service implementation class.
 * 
 * @author Christian Leppelt
 */
public class LendingServiceImpl implements LendingService {
	/** The lending DAO. */
	private LendingDAO lendingDAO;
	/** The admonition process service. */
	private AdmonitionProcessServiceImpl admonitionProcessService;

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
	public List<Lending> searchDelayedLendings() {
		Date now = new GregorianCalendar().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String todayString = dateFormat.format(now);
		return lendingDAO.findDelayed(Integer.valueOf(todayString));
	}

	@Override
	public List<Lending> searchByPublication(Publication publication) {
		return lendingDAO.loadByPublication(publication);
	}

	@Override
	public void adjustReturnDate(Lending lending) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(lending.getOutgoDate());
		calendar.add(Calendar.DATE, 28);
		for (int i = 0; i < lending.getNumberOfLendingExtensions(); i++) {
			calendar.add(Calendar.DATE, 14);
		}
		lending.setExpectedReturnDate(calendar.getTime());
	}

	@Override
	public boolean hasAdmonitionProcess(Lending lending) {
		List<AdmonitionProcess> processes = admonitionProcessService
				.searchByLending(lending);
		return !processes.isEmpty();
	}

	public void setLendingDAO(LendingDAO lendingDAO) {
		this.lendingDAO = lendingDAO;
	}

}
