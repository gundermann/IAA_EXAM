package de.nak.library.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<Admonition> getAdmonitions() {
		return admonitions;
	}

	public void setAdmonitions(Set<Admonition> admonitions) {
		this.admonitions = admonitions;
	}

}
