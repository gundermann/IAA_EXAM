package de.nak.cars.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Admonition entity. Is created when a lended Publication ist not returned in
 * time.
 * 
 * @author Kathrin Kurtz
 * 
 */
@Entity
public class AdmonitionProcess {

	/** The identifier. */
	private Long admonitionProcessId;

	/** The lending that this admonition process belongs to */
	private Lending lending;

	/**
	 * Set of the admonitions created in this admonition process. Maximum number
	 * is 3.
	 */
	private Set<Admonition> admonitions;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADMONITION_PROCESS_ID")
	public Long getAdmonitionProcessId() {
		return admonitionProcessId;
	}

	public void setAdmonitionProcessId(Long id) {
		this.admonitionProcessId = id;
	}

	@OneToMany(mappedBy = "admonitionProcess")
	public Set<Admonition> getAdmonitions() {
		return admonitions;
	}

	public void setAdmonitions(Set<Admonition> admonitions) {
		this.admonitions = admonitions;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public Lending getLending() {
		return lending;
	}

	public void setLending(Lending lending) {
		this.lending = lending;
	}

}
