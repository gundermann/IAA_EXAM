package de.nak.cars.model;

import java.util.List;

/**
 * Admonition entity.
 * Is created when a lended Publication ist not returned in time.
 * @author Kathrin Kurtz
 *
 */
public class AdmonitionProcess {
	
	/** The identifier. */
	private Long id;
	/** The ID of the lending. */
	private long lendingId;
	/** List of the admonitions created in this admonation process. Max number is 3. */
	private List<Admonition> admonitions;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getLendingId() {
		return lendingId;
	}
	public void setLendingId(long lendingId) {
		this.lendingId = lendingId;
	}
	public List<Admonition> getAdmonitions() {
		return admonitions;
	}
	public void setAdmonitions(List<Admonition> admonitions) {
		this.admonitions = admonitions;
	}
	

	
}
