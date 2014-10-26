package de.nak.cars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Publication entity.
 * 
 * @author Christian Leppelt
 */
@Entity
public class Publication {
	/** The identifier. */
	private Long id;
	/** The publications title. */
	private String title;
	// /** The publications authors. */
	// private List<Author> authors;
	/** The year the publication was published. */
	private Integer yearOfPublication;
	/** The publications publisher. */
	// private Publisher publisher;
	// /** The publication type. */
	// private PublicationType type;
	/** The publications isbn. */
	private Integer isbn;
	// /** The buzzwords to find the publication. */
	// private List<Keyword> keywords;
	/** The quantity we own of this publication. */
	private Integer quantity;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// public List<Author> getAuthors() {
	// return authors;
	// }
	//
	// public void setAuthors(List<Author> authors) {
	// this.authors = authors;
	// }

	public Integer getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Integer yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	// public Publisher getPublisher() {
	// return publisher;
	// }
	//
	// public void setPublisher(Publisher publisher) {
	// this.publisher = publisher;
	// }

	// @Column(nullable = false)
	// public PublicationType getType() {
	// return type;
	// }
	//
	// public void setType(PublicationType type) {
	// this.type = type;
	// }
	@Column(length = 13, nullable = false)
	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	// public List<Keyword> getKeywords() {
	// return keywords;
	// }
	//
	// public void setKeywords(List<Keyword> keywords) {
	// this.keywords = keywords;
	// }

	@Column(length = 3, nullable = false)
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
