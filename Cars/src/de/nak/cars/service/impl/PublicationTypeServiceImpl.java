package de.nak.cars.service.impl;

import java.util.List;

import de.nak.cars.dao.PublicationTypeDAO;
import de.nak.cars.model.PublicationType;
import de.nak.cars.service.PublicationTypeService;

public class PublicationTypeServiceImpl implements PublicationTypeService {
	/** The publication type DAO. */
	private PublicationTypeDAO publicationTypeDAO;

	@Override
	public void savePublicationType(PublicationType publicationType) {
		publicationTypeDAO.save(publicationType);
	}

	@Override
	public PublicationType loadPublicationType(Long id) {
		return publicationTypeDAO.load(id);
	}

	@Override
	public void deletePublicationType(PublicationType publicationType) {
		publicationTypeDAO.delete(publicationType);
	}

	@Override
	public List<PublicationType> loadAllPublicationTypes() {
		return publicationTypeDAO.loadAll();
	}

	public void setPublicationTypeDAO(PublicationTypeDAO publicationTypeDAO) {
		this.publicationTypeDAO = publicationTypeDAO;
	}

}
