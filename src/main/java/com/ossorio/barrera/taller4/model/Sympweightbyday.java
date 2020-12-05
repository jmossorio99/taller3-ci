package com.ossorio.barrera.taller4.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the SYMPWEIGHTBYDAYS database table.
 *
 */
@Entity
@Table(name = "SYMPWEIGHTBYDAYS")
@NamedQuery(name = "Sympweightbyday.findAll", query = "SELECT s FROM Sympweightbyday s")
public class Sympweightbyday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SYMPWEIGHTBYDAYS_SYMPWEIDAYSID_GENERATOR", sequenceName = "SYMPWEIGHTBYDAYS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SYMPWEIGHTBYDAYS_SYMPWEIDAYSID_GENERATOR")
	@Column(name = "SYMPWEIDAYS_ID")
	private long sympweidaysId;

	@NotNull
	@Column(name = "SYMPWEIDAYS_MAX")
	private BigDecimal sympweidaysMax;

	@NotNull
	@Column(name = "SYMPWEIDAYS_MIN")
	private BigDecimal sympweidaysMin;

	@NotNull
	@Column(name = "SYMPWEIDAYS_WEIGHT")
	private BigDecimal sympweidaysWeight;

	// bi-directional many-to-one association to Symptomquestion
	@ManyToOne
	@JoinColumn(name = "SYMPQUES_SYMPQUES_ID")
	private Symptomquestion symptomquestion;

	public Sympweightbyday() {
	}

	public long getSympweidaysId() {
		return sympweidaysId;
	}

	public void setSympweidaysId(long sympweidaysId) {
		this.sympweidaysId = sympweidaysId;
	}

	public BigDecimal getSympweidaysMax() {
		return sympweidaysMax;
	}

	public void setSympweidaysMax(BigDecimal sympweidaysMax) {
		this.sympweidaysMax = sympweidaysMax;
	}

	public BigDecimal getSympweidaysMin() {
		return sympweidaysMin;
	}

	public void setSympweidaysMin(BigDecimal sympweidaysMin) {
		this.sympweidaysMin = sympweidaysMin;
	}

	public BigDecimal getSympweidaysWeight() {
		return sympweidaysWeight;
	}

	public void setSympweidaysWeight(BigDecimal sympweidaysWeight) {
		this.sympweidaysWeight = sympweidaysWeight;
	}

	public Symptomquestion getSymptomquestion() {
		return symptomquestion;
	}

	public void setSymptomquestion(Symptomquestion symptomquestion) {
		this.symptomquestion = symptomquestion;
	}

}