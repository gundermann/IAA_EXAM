package de.nak.library.test.mock;

import java.util.List;

import de.nak.library.dao.LenderDAO;
import de.nak.library.model.Lender;

/**
 * The lender dao mock class.
 * 
 * @author Christian Leppelt
 */
public class LenderDAOMock extends LenderDAO {

	@Override
	public void save(Lender lender) {

	}

	@Override
	public Lender load(Long lenderId) {
		return new Lender();
	}

	@Override
	public void delete(Lender lender) {

	}

	@Override
	public List<Lender> loadAll() {
		return null;
	}

	@Override
	public Lender load(Integer matriculationNumber) {
		return null;
	}

}
