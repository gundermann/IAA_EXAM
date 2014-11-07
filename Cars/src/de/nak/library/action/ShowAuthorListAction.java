package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.library.model.Author;
import de.nak.library.service.AuthorService;

/**
 * Action that shows a list of authors.
 *
 * @author Niels Gundermann
 */
public class ShowAuthorListAction implements Action {
	/** The list of authors. */
	private List<Author> authorList;

	/** The Author service. */
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
