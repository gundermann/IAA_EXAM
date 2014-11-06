package de.nak.library.test.mock;

import java.util.List;

import de.nak.library.dao.LendingDAO;
import de.nak.library.model.Lending;
import de.nak.library.model.Publication;

/**
 * The lending dao mock class.
 * 
 * @author Christian Leppelt
 */
public class LendingDAOMock extends LendingDAO {

	@Override
	public void save(Lending lending) {

	}

	@Override
	public Lending load(Long id) {
		Lending lending = new Lending();
		lending.setLendingId(id);
		return lending;
	}

	@Override
	public void delete(Lending lending) {

	}

	@Override
	public List<Lending> loadAll() {
		return null;
	}

	@Override
	public List<Lending> findDelayed(Integer currentDate) {
		return null;
	}

	@Override
	public List<Lending> load(Publication publication) {
		return null;
	}
}
