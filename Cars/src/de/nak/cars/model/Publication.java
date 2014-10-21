package de.nak.cars.model;

import java.util.List;

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
	/** The publications authors. */
	private List<String> authors;
	/** The year the publication was published. */
	private Integer yearOfPublication;
	/** The publications publisher. */
	private String publisher;
	/** The publication type. */
	private String type;
	/** The publications isbn. */
	private Integer isbn;
	/** The buzzwords to find the publication. */
	private List<String> buzzwords;
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

	@Column(length = 100, nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	@Column(name = "year_of_publication", scale = 4)
	public Integer getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Integer yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	@Column(length = 100, nullable = false)
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column(length = 50, nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(length = 13, nullable = false)
	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public List<String> getBuzzwords() {
		return buzzwords;
	}

	public void setBuzzwords(List<String> buzzwords) {
		this.buzzwords = buzzwords;
	}

	@Column(length = 3, nullable = false)
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
