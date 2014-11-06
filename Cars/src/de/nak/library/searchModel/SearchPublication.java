package de.nak.library.searchModel;

public class SearchPublication {

	/** The NAK-intern identifier. */
	private String nakId;
	/** The publications title. */
	private String title;
	/** The publications authors. */
	private String authors;
	/** The date when the publication was published. */
	private String dateOfPublication;
	/** The publications publisher. */
	private String publisher;
	/** The publication type. */
	private String publicationType;
	/** The publications isbn. */
	private String isbn;
	/** The buzzwords to find the publication. */
	private String keywords;

	public String getNakId() {
		return nakId;
	}

	public void setNakId(String nakId) {
		this.nakId = nakId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(String dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}
