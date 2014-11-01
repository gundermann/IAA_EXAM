package de.nak.cars.service.impl;

import java.util.ArrayList;
import java.util.List;

import de.nak.cars.dao.PublicationDAO;
import de.nak.cars.model.Author;
import de.nak.cars.model.Keyword;
import de.nak.cars.model.Publication;
import de.nak.cars.model.PublicationType;
import de.nak.cars.service.PublicationService;

/**
 * The publication service implementation class.
 * 
 * @author Christian Leppelt
 */
public class PublicationServiceImpl implements PublicationService {
	/** The publication DAO. */
	private PublicationDAO publicationDAO;
	
	@Override
	public void savePublication(Publication publication) {
		publicationDAO.save(publication);
	}

	@Override
	public Publication loadPublication(Long id) {
		return publicationDAO.load(id);
	}

	@Override
	public void deletePublication(Publication publication) {
		publicationDAO.delete(publication);
	}

	@Override
	public List<Publication> loadAllPublications() {
		return publicationDAO.loadAll();
	}

	//TODO Bei Publisher darf kein String übergeben werden, sondern der Publisher
	@Override
	public List<Publication> searchPublications(String title,
			List<Author> authors, Integer yearOfPublication, String publisher,
			PublicationType type, List<Keyword> keywords) {
		ArrayList<String> queryParts = new ArrayList<String>();
		if (title != null && !title.equals(""))
			queryParts.add("title like '%" + title + "%'");
		if (authors != null && !authors.isEmpty())
			;// TODO
		if (yearOfPublication != null)
			queryParts.add("year_of_publication = " + yearOfPublication);
		if (publisher != null && !publisher.equals(""))
			queryParts.add("publisher like '%" + publisher + "%'");
		if (type != null && !type.equals(""))
			queryParts.add("type = " + type);
		if (keywords != null && !keywords.isEmpty())
			;// TODO
		String whereCondition = createWhereCondition(queryParts);
		return publicationDAO.findPublications(whereCondition);
	}

	@Override
	public Publication searchPublicationByIsbn(Integer isbn) {
		//TODO lieber eine Liste mit der entsprechenden Publikation zurückgeben
		return publicationDAO.findPublicationByIsbn(isbn);
	}

	public void setPublicationDAO(PublicationDAO publicationDAO) {
		this.publicationDAO = publicationDAO;
	}

	private String createWhereCondition(ArrayList<String> queryParts) {
		if (queryParts.isEmpty())
			return "";
		String whereCondition = " where ";
		for (int i = 0; i < queryParts.size(); i++) {
			whereCondition = whereCondition + queryParts.get(i);
			if (i < queryParts.size() - 1)
				whereCondition = whereCondition + " and ";
		}
		return whereCondition;
	}

	@Override
	public Publication setupPublication(Publication publication,
			String[] authorId, String[] keywordId, Long publicationTypeId,
			Long publisherId) {
		return null;
	}

}
