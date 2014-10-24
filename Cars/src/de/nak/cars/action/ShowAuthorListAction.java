package de.nak.cars.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.cars.model.Author;
import de.nak.cars.service.AuthorService;

/**
 * Action that shows a list of PublicationTypes.
 *
 * @author Niels Gundermann
 */
public class ShowAuthorListAction implements Action {
	/** The list of PublicationTypes. */
	private List<Author> authorList;

	/** The PublicationType service. */
	private AuthorService authorService;

	@Override
	public String execute() throws Exception {
		authorList = authorService.loadAllAuthors();
		return SUCCESS;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	

	
	
}
