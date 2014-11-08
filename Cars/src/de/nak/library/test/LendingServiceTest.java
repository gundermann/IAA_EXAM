package de.nak.library.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;
import de.nak.library.model.AdmonitionProcess;
import de.nak.library.model.Lending;
import de.nak.library.model.Publication;
import de.nak.library.service.impl.AdmonitionProcessServiceImpl;
import de.nak.library.service.impl.LenderServiceImpl;
import de.nak.library.service.impl.LendingServiceImpl;
import de.nak.library.service.impl.PublicationServiceImpl;
import de.nak.library.test.mock.AdmonitionProcessDAOMock;
import de.nak.library.test.mock.LenderDAOMock;
import de.nak.library.test.mock.LendingDAOMock;
import de.nak.library.test.mock.PublicationDAOMock;

/**
 * The lending service test class.
 * 
 * @author Christian Leppelt
 */
public class LendingServiceTest extends TestCase {
	/** The lending service. */
	LendingServiceImpl lendingService;

	protected void setUp() {
		lendingService = new LendingServiceImpl();
		lendingService.setLendingDAO(new LendingDAOMock());

		AdmonitionProcessServiceImpl admonitionProcessService = new AdmonitionProcessServiceImpl();
		admonitionProcessService
				.setAdmonitionProcessDAO(new AdmonitionProcessDAOMock());
		lendingService.setAdmonitionProcessService(admonitionProcessService);

		LenderServiceImpl lenderService = new LenderServiceImpl();
		lenderService.setLenderDAO(new LenderDAOMock());
		lendingService.setLenderService(lenderService);

		PublicationServiceImpl publicationService = new PublicationServiceImpl();
		publicationService.setPublicationDAO(new PublicationDAOMock());
		lendingService.setPublicationService(publicationService);
	}

	public void testExtend() {
		Date orignalDate = new GregorianCalendar(2012 + 1900, 11, 11).getTime(); // December/11/2012
		Date newDate;

		Lending lending = new Lending();
		lending.setNumberOfLendingExtensions(0);
		lending.setExpectedReturnDate(orignalDate);

		lendingService.extend(lending);

		newDate = new GregorianCalendar(2012 + 1900, 11, 25).getTime(); // December/25/2012
		assertEquals(new Integer(1), lending.getNumberOfLendingExtensions());
		assertEquals(newDate, lending.getExpectedReturnDate());

		lendingService.extend(lending);

		newDate = new GregorianCalendar(2013 + 1900, 0, 8).getTime(); // January/08/2013
		assertEquals(new Integer(2), lending.getNumberOfLendingExtensions());
		assertEquals(newDate, lending.getExpectedReturnDate());

	}

	public void testInitializeLending() {
		Lending lending = new Lending();

		lendingService.initializeLending(lending, 12l, 12l);

		assertNotNull(lending.getLender());
		assertNotNull(lending.getPublication());
		assertEquals(new Integer(0), lending.getNumberOfLendingExtensions());
		assertNotNull(lending.getOutgoDate());
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(lending.getOutgoDate());
		calendar.add(Calendar.DATE, 28);
		assertEquals(calendar.getTime(), lending.getExpectedReturnDate());
	}

	public void testFinishLendingIfLost() {
		Lending lending = new Lending();
		Publication publication = new Publication();
		publication.setQuantity(5);
		lending.setPublication(publication);

		lendingService.finishLendingIfLost(lending);

		assertEquals(new Integer(4), lending.getPublication().getQuantity());
	}

	public void testCreateAdmonitionProcess() {
		Long lendingId = new Long(12);

		AdmonitionProcess admonitionProcess = lendingService
				.createAdmonitionProcess(lendingId);

		assertEquals(lendingId, admonitionProcess.getLending().getLendingId());
		assertNotNull(admonitionProcess.getAdmonitions());
	}

}
