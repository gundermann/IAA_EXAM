package de.nak.cars.service;

import java.util.List;

import de.nak.cars.model.Failure;

public interface FailureService {

	/**
	 * Load all failures from DB.
	 * @return List<Failure>
	 */
	List<Failure> loadAllFailures();

}
