package de.nak.library.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.library.model.Author;
import de.nak.library.model.Publication;
import de.nak.library.service.AuthorService;
import de.nak.library.service.PublicationService;

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

	/** The publication service */
	private PublicationService publicationService;

	/**
	 * Saves the author to the database.
	 * 
	 * @return the result string.
	 */
	public String save() {
		Author authorWithSameName = authorService.searchByName(author.getName());
		if (authorWithSameName != null
				&& (authorId == null || authorWithSameName.getAuthorId() != authorId)) {
			addActionError(getText("msg.authorNameAlreadyExists"));
			return INPUT;
		}
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
			List<Publication> publicationResults = publicationService.searchByAuthorId(authorId);
			if (!publicationResults.isEmpty()) {
				addActionError(getText("msg.authorInUse"));
				return INPUT;
			}
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
			addActionError(getText("msg.selectAuthor"));
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

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

}
