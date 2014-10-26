package de.nak.cars.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.cars.model.Author;
import de.nak.cars.service.AuthorService;

/**
 * Action for a single author.
 *
 * @author Niels Gundermann
 */
public class AuthorAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;

	/** The current author. */
	private Author author;

	/** The author's identifier selected by the user. */
	private Long authorId;

	/** The author service. */
	private AuthorService authorService;

	/**
	 * Saves the author to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		authorService.saveAuthor(author);
		return SUCCESS;
	}

	/**
	 * Deletes the selected author from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		author = authorService.loadAuthor(authorId);
		if (author != null) {
			authorService.deleteAuthor(author);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected author in the author form.
	 *
	 * @return the result string.
	 */
	public String load() {
		author = authorService.loadAuthor(authorId);
		return SUCCESS;
	}

	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		// If the author is not set, the author ID has to be set.
		if (author == null && authorId == null) {
			addActionError(getText("msg.selectauthor"));
		}
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	



	
}
