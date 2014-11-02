package de.nak.cars.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Publication entity.
 * 
 * @author Christian Leppelt
 */
@Entity
public class Publication {
	/** The identifier. */
	private Long id;
	/** The NAK-intern identifier. */
	private Long nakId;
	/** The publications title. */
	private String title;
	/** The publications authors. */
	private Set<Author> authors;
	/** The year the publication was published. */
	private Integer yearOfPublication;
	/** The publications publisher. */
	private Publisher publisher;
	/** The publication type. */
	private PublicationType publicationType;
	/** The publications isbn. */
	private Integer isbn;
	/** The buzzwords to find the publication. */
	private Set<Keyword> keywords;
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

	@Column(length = 4, nullable = true)
	public Integer getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Integer yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	@Column(length = 13, nullable = true)
	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	@Column(length = 3, nullable = false)
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@ManyToOne
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@ManyToOne
	public PublicationType getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(PublicationType publicationType) {
		this.publicationType = publicationType;
	}

	@ManyToMany
	public Set<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}

	@ManyToMany
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Column(nullable = false)
	public Long getNakId() {
		return nakId;
	}

	public void setNakId(Long nakId) {
		this.nakId = nakId;
	}

}
