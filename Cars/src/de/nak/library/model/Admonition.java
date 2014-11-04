package de.nak.library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Admonition entity. Part of the Admonition Process.
 * 
 * @author Kathrin Kurtz
 * 
 */
@Entity
public class Admonition {

	/** The identifier. */
	private Long admonitionId;

	/** Day when the admonition has been created. */
	private Date creationDay;

	/** The admonition process this admonition belongs to. */
	private AdmonitionProcess admonitionProcess;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getAdmonitionId() {
		return admonitionId;
	}

	public void setAdmonitionId(Long id) {
		this.admonitionId = id;
	}

	@Column(name = "CREATION_DAY")
	public Date getCreationDay() {
		return creationDay;
	}

	public void setCreationDay(Date creationDay) {
		this.creationDay = creationDay;
	}

	@ManyToOne
	@JoinColumn(name = "ADMONITION_PROCESS_ID")
	public AdmonitionProcess getAdmonitionProcess() {
		return admonitionProcess;
	}

	public void setAdmonitionProcess(AdmonitionProcess admonitionProcess) {
		this.admonitionProcess = admonitionProcess;
	}

}
