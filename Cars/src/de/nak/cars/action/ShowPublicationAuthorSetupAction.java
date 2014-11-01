package de.nak.cars.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.cars.model.Author;
import de.nak.cars.model.Publication;
import de.nak.cars.service.AuthorService;
import de.nak.cars.service.PublicationService;

/**
 * Action that shows a list of failures.
 *
 * @author Niels Gundermann
 */
public class ShowPublicationAuthorSetupAction implements Action {
	
	private Publication publication;
	
	private Long id;
	
	private PublicationService publicationService;
	
	private List<Author> authorList;
	
	private AuthorService authorService;

	@Override
	public String execute() throws Exception {
		authorList = authorService.loadAllAuthors();
		publication = publicationService.loadPublication(id);
		return SUCCESS;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	
	
}
