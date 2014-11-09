package de.nak.library.service.impl;

import java.util.List;

import de.nak.library.dao.PublicationTypeDAO;
import de.nak.library.model.PublicationType;
import de.nak.library.service.PublicationTypeService;

/**
 * The publication type service implementation class.
 * 
 * @author Christian Leppelt
 */
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

	@Override
	public PublicationType searchByName(String typeName) {
		return publicationTypeDAO.load(typeName);
	}

}
