package de.nak.library.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Publication entity.
 * 
 * @author Christian Leppelt, Kathrin Kurtz
 */
@Entity
public class Publication {
	/** The identifier. */
	private Long publicationId;
	/** The NAK-intern identifier. */
	private Long nakId;
	/** The publications title. */
	private String title;
	/** The publications authors. */
	private Set<Author> authors;
	/** The date when the publication was published. */
	private Date dateOfPublication;
	/** The publications publisher. */
	private Publisher publisher;
	/** The publication type. */
	private PublicationType publicationType;
	/** The publications isbn. */
	private Long isbn;
	/** The buzzwords to find the publication. */
	private Set<Keyword> keywords;
	/** The quantity we own of this publication. */
	private Integer quantity;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(Long publicationId) {
		this.publicationId = publicationId;
	}

	@Column
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(length = 13, nullable = true)
	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
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

	@ManyToMany(fetch = FetchType.EAGER)
	public Set<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}

	@ManyToMany(fetch = FetchType.EAGER)
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

	@Column
	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

}
