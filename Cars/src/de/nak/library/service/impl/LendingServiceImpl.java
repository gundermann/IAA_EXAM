package de.nak.library.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import de.nak.library.dao.LendingDAO;
import de.nak.library.model.AdmonitionProcess;
import de.nak.library.model.Lending;
import de.nak.library.model.Publication;
import de.nak.library.service.AdmonitionProcessService;
import de.nak.library.service.LenderService;
import de.nak.library.service.LendingService;
import de.nak.library.service.PublicationService;

/**
 * The lending service implementation class.
 * 
 * @author Christian Leppelt
 */
public class LendingServiceImpl implements LendingService {
	/** The lending DAO. */
	private LendingDAO lendingDAO;
	/** The admonition process service. */
	private AdmonitionProcessService admonitionProcessService;
	/** The lender service. */
	private LenderService lenderService;
	/** The publication service. */
	private PublicationService publicationService;

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
		return lendingDAO.load(publication);
	}

	@Override
	public void extend(Lending lending) {
		extendReturnDate(lending);
		Integer lendingExtensionNr = lending.getNumberOfLendingExtensions();
		lending.setNumberOfLendingExtensions(lendingExtensionNr + 1);
	}

	@Override
	public boolean hasAdmonitionProcess(Lending lending) {
		List<AdmonitionProcess> processes = admonitionProcessService
				.searchByLending(lending);
		return !processes.isEmpty();
	}

	@Override
	public List<Publication> loadAllAvailablePublications() {
		List<Publication> allPublications = publicationService
				.loadAllPublications();
		List<Publication> availablePublications = new ArrayList<Publication>();
		for (Publication publication : allPublications) {
			List<Lending> lendingList = searchByPublication(publication);
			if (publication.getQuantity() > lendingList.size())
				availablePublications.add(publication);
		}
		return availablePublications;
	}

	@Override
	public Lending initializeLending(Lending lending, Long lenderId,
			Long publicationId) {
		lending.setLender(lenderService.loadLender(lenderId));
		lending.setPublication(publicationService
				.loadPublication(publicationId));
		lending.setNumberOfLendingExtensions(0);
		initializeDates(lending);
		return lending;
	}

	@Override
	public void finishLendingIfReturned(Lending lending) {
		deleteAdmonitionProcess(lending);
		deleteLending(lending);
	}

	@Override
	public void finishLendingIfLost(Lending lending) {
		Publication publication = lending.getPublication();
		publication.setQuantity(publication.getQuantity() - 1);
		publicationService.savePublication(publication);
		deleteAdmonitionProcess(lending);
		deleteLending(lending);
	}

	public void setLendingDAO(LendingDAO lendingDAO) {
		this.lendingDAO = lendingDAO;
	}

	public void setAdmonitionProcessService(
			AdmonitionProcessService admonitionProcessService) {
		this.admonitionProcessService = admonitionProcessService;
	}

	public void setLenderService(LenderService lenderService) {
		this.lenderService = lenderService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	private void deleteAdmonitionProcess(Lending lending) {
		List<AdmonitionProcess> admonitionProcesses = admonitionProcessService
				.searchByLending(lending);
		if (!admonitionProcesses.isEmpty()) {
			AdmonitionProcess admonitionProcess = admonitionProcesses.get(0);
			admonitionProcessService.deleteAdmonitionProcess(admonitionProcess);
		}
	}

	private void initializeDates(Lending lending) {
		Calendar calendar = Calendar.getInstance();
		lending.setOutgoDate(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, 28);
		lending.setExpectedReturnDate(calendar.getTime());
	}

	private void extendReturnDate(Lending lending) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(lending.getExpectedReturnDate());
		calendar.add(Calendar.DATE, 14);
		lending.setExpectedReturnDate(calendar.getTime());
	}

}
