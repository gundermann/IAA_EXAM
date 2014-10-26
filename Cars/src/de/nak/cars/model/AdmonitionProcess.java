package de.nak.cars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	// /** The lending. */
	// private Lending lending;
	// /** List of the admonitions created in this admonation process. Max
	// number is 3. */
	// private Set<Admonition> admonitions;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADMONITION_PROCESS_ID")
	public Long getAdmonitionProcessId() {
		return admonitionProcessId;
	}

	public void setAdmonitionProcessId(Long id) {
		this.admonitionProcessId = id;
	}

	// public Lending getLendingId() {
	// return lending;
	// }
	//
	// public void setLendingId(Lending lending) {
	// this.lending = lending;
	// }
	//
	// TODO: Mapping korrigieren
	// @OneToMany(mappedBy = "admonitionprocess")
	// public Set<Admonition> getAdmonitions() {
	// return admonitions;
	// }
	//
	// public void setAdmonitions(Set<Admonition> admonitions) {
	// this.admonitions = admonitions;
	// }

}
