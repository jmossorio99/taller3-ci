package com.ossorio.taller3.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the SYMPTOMPOLL database table.
 *
 */
@Entity
@NamedQuery(name = "Symptompoll.findAll", query = "SELECT s FROM Symptompoll s")
public class Symptompoll implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SYMPTOMPOLL_SYMPOLLID_GENERATOR", sequenceName = "SYMPTOMPOLL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SYMPTOMPOLL_SYMPOLLID_GENERATOR")
	@Column(name = "SYMPOLL_ID")
	private long sympollId;

	@NotNull
	@Column(name = "INST_INST_ID")
	private long instInstId;

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "SYMPOLL_ENDDATE")
	private Date sympollEnddate;

	@NotBlank
	@Column(name = "SYMPOLL_NAME")
	private String sympollName;

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "SYMPOLL_STARTDATE")
	private Date sympollStartdate;

	// bi-directional many-to-one association to Epidemevent
	@NotNull
	@ManyToOne
	@JoinColumn(name = "EPIEVE_EPIEVE_ID")
	private Epidemevent epidemevent;

	// bi-directional many-to-one association to Symptomquestion
	@OneToMany(mappedBy = "symptompoll")
	private List<Symptomquestion> symptomquestions;

	public Symptompoll() {
	}

	public long getSympollId() {
		return sympollId;
	}

	public void setSympollId(long sympollId) {
		this.sympollId = sympollId;
	}

	public long getInstInstId() {
		return instInstId;
	}

	public void setInstInstId(long instInstId) {
		this.instInstId = instInstId;
	}

	public Date getSympollEnddate() {
		return sympollEnddate;
	}

	public void setSympollEnddate(Date sympollEnddate) {
		this.sympollEnddate = sympollEnddate;
	}

	public String getSympollName() {
		return sympollName;
	}

	public void setSympollName(String sympollName) {
		this.sympollName = sympollName;
	}

	public Date getSympollStartdate() {
		return sympollStartdate;
	}

	public void setSympollStartdate(Date sympollStartdate) {
		this.sympollStartdate = sympollStartdate;
	}

	public Epidemevent getEpidemevent() {
		return epidemevent;
	}

	public void setEpidemevent(Epidemevent epidemevent) {
		this.epidemevent = epidemevent;
	}

	public List<Symptomquestion> getSymptomquestions() {
		return symptomquestions;
	}

	public void setSymptomquestions(List<Symptomquestion> symptomquestions) {
		this.symptomquestions = symptomquestions;
	}

	public Symptomquestion addSymptomquestion(Symptomquestion symptomquestion) {
		getSymptomquestions().add(symptomquestion);
		symptomquestion.setSymptompoll(this);

		return symptomquestion;
	}

	public Symptomquestion removeSymptomquestion(Symptomquestion symptomquestion) {
		getSymptomquestions().remove(symptomquestion);
		symptomquestion.setSymptompoll(null);

		return symptomquestion;
	}

}