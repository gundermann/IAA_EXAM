package de.nak.library.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.TestCase;
import de.nak.library.model.Admonition;
import de.nak.library.model.AdmonitionProcess;
import de.nak.library.service.impl.AdmonitionProcessServiceImpl;
import de.nak.library.service.impl.AdmonitionServiceImpl;
import de.nak.library.test.mock.AdmonitionDAOMock;
import de.nak.library.test.mock.AdmonitionProcessDAOMock;

/**
 * The admonition process service test class.
 * 
 * @author Christian Leppelt
 */
public class AdmonitionProcessServiceTest extends TestCase {
	/** The admonition process service. */
	AdmonitionProcessServiceImpl admonitionProcessService;

	protected void setUp() {
		admonitionProcessService = new AdmonitionProcessServiceImpl();
		admonitionProcessService
				.setAdmonitionProcessDAO(new AdmonitionProcessDAOMock());

		AdmonitionServiceImpl admonitionService = new AdmonitionServiceImpl();
		admonitionService.setAdmonitionDAO(new AdmonitionDAOMock());
		admonitionProcessService.setAdmonitionService(admonitionService);
	}

	public void testAddAdmonition() {
		AdmonitionProcess admonitionProcess = new AdmonitionProcess();
		admonitionProcessService.addAdmonition(admonitionProcess);

		assertNotNull(admonitionProcess.getAdmonitions());
		assertFalse(admonitionProcess.getAdmonitions().isEmpty());

		for (Admonition admonition : admonitionProcess.getAdmonitions()) {
			assertCorrectCreationDay(admonition);
			assertEquals(admonitionProcess, admonition.getAdmonitionProcess());
		}
	}

	public void testCountAdmonitions() {
		assertEquals(null, admonitionProcessService.countAdmonitions(null));
	}

	private void assertCorrectCreationDay(Admonition admonition) {
		Calendar calendar = new GregorianCalendar();
		String today = "" + calendar.get(Calendar.DAY_OF_MONTH)
				+ calendar.get(Calendar.MONTH) + calendar.get(Calendar.YEAR);

		calendar.setTime(admonition.getCreationDay());
		String creationDay = "" + calendar.get(Calendar.DAY_OF_MONTH)
				+ calendar.get(Calendar.MONTH) + calendar.get(Calendar.YEAR);

		assertEquals(creationDay, today);
	}
}
