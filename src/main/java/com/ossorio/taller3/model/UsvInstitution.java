package com.ossorio.taller3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * The persistent class for the USV_INSTITUTION database table.
 *
 */
@Entity
@Table(name = "USV_INSTITUTION")
@NamedQuery(name = "UsvInstitution.findAll", query = "SELECT u FROM UsvInstitution u")
public class UsvInstitution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USV_INSTITUTION_INSTID_GENERATOR", sequenceName = "USV_INSTITUTION_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USV_INSTITUTION_INSTID_GENERATOR")
	@Column(name = "INST_ID")
	private long instId;

//	@NotBlank
	@Column(name = "INST_ACADEMICSERVERURL")
	private String instAcademicserverurl;

//	@NotBlank
	@Column(name = "INST_ACADEXTRADATAURL")
	private String instAcadextradataurl;

	@Column(name = "INST_ACADLOGINPASSWORD")
	private String instAcadloginpassword;

//	@NotBlank
	@Column(name = "INST_ACADLOGINURL")
	private String instAcadloginurl;

	@Column(name = "INST_ACADLOGINUSERNAME")
	private String instAcadloginusername;

	@Column(name = "INST_ACADPERSONINFODOCURL")
	private String instAcadpersoninfodocurl;

//	@NotBlank
	@Column(name = "INST_ACADPERSONINFOIDURL")
	private String instAcadpersoninfoidurl;

//	@NotBlank
	@Column(name = "INST_ACADPHYSICALSPACESURL")
	private String instAcadphysicalspacesurl;

	@Column(name = "INST_ACADPROGRAMMEDCOURSESURL")
	private String instAcadprogrammedcoursesurl;

	@Column(name = "INST_LDAPBASEDN")
	private String instLdapbasedn;

	@Column(name = "INST_LDAPPASSWORD")
	private String instLdappassword;

//	@NotBlank
	@Size(min = 11)
	@Column(name = "INST_LDAPURL")
	private String instLdapurl;

	@Column(name = "INST_LDAPUSERNAME")
	private String instLdapusername;

	@Column(name = "INST_LDAPUSERSEARCHBASE")
	private String instLdapusersearchbase;

	@Column(name = "INST_LDAPUSERSEARCHFILTER")
	private String instLdapusersearchfilter;

//	@NotBlank
	@Column(name = "INST_NAME")
	private String instName;

	public UsvInstitution() {
	}

	public long getInstId() {
		return instId;
	}

	public void setInstId(long instId) {
		this.instId = instId;
	}

	public String getInstAcademicserverurl() {
		return instAcademicserverurl;
	}

	public void setInstAcademicserverurl(String instAcademicserverurl) {
		this.instAcademicserverurl = instAcademicserverurl;
	}

	public String getInstAcadextradataurl() {
		return instAcadextradataurl;
	}

	public void setInstAcadextradataurl(String instAcadextradataurl) {
		this.instAcadextradataurl = instAcadextradataurl;
	}

	public String getInstAcadloginpassword() {
		return instAcadloginpassword;
	}

	public void setInstAcadloginpassword(String instAcadloginpassword) {
		this.instAcadloginpassword = instAcadloginpassword;
	}

	public String getInstAcadloginurl() {
		return instAcadloginurl;
	}

	public void setInstAcadloginurl(String instAcadloginurl) {
		this.instAcadloginurl = instAcadloginurl;
	}

	public String getInstAcadloginusername() {
		return instAcadloginusername;
	}

	public void setInstAcadloginusername(String instAcadloginusername) {
		this.instAcadloginusername = instAcadloginusername;
	}

	public String getInstAcadpersoninfodocurl() {
		return instAcadpersoninfodocurl;
	}

	public void setInstAcadpersoninfodocurl(String instAcadpersoninfodocurl) {
		this.instAcadpersoninfodocurl = instAcadpersoninfodocurl;
	}

	public String getInstAcadpersoninfoidurl() {
		return instAcadpersoninfoidurl;
	}

	public void setInstAcadpersoninfoidurl(String instAcadpersoninfoidurl) {
		this.instAcadpersoninfoidurl = instAcadpersoninfoidurl;
	}

	public String getInstAcadphysicalspacesurl() {
		return instAcadphysicalspacesurl;
	}

	public void setInstAcadphysicalspacesurl(String instAcadphysicalspacesurl) {
		this.instAcadphysicalspacesurl = instAcadphysicalspacesurl;
	}

	public String getInstAcadprogrammedcoursesurl() {
		return instAcadprogrammedcoursesurl;
	}

	public void setInstAcadprogrammedcoursesurl(String instAcadprogrammedcoursesurl) {
		this.instAcadprogrammedcoursesurl = instAcadprogrammedcoursesurl;
	}

	public String getInstLdapbasedn() {
		return instLdapbasedn;
	}

	public void setInstLdapbasedn(String instLdapbasedn) {
		this.instLdapbasedn = instLdapbasedn;
	}

	public String getInstLdappassword() {
		return instLdappassword;
	}

	public void setInstLdappassword(String instLdappassword) {
		this.instLdappassword = instLdappassword;
	}

	public String getInstLdapurl() {
		return instLdapurl;
	}

	public void setInstLdapurl(String instLdapurl) {
		this.instLdapurl = instLdapurl;
	}

	public String getInstLdapusername() {
		return instLdapusername;
	}

	public void setInstLdapusername(String instLdapusername) {
		this.instLdapusername = instLdapusername;
	}

	public String getInstLdapusersearchbase() {
		return instLdapusersearchbase;
	}

	public void setInstLdapusersearchbase(String instLdapusersearchbase) {
		this.instLdapusersearchbase = instLdapusersearchbase;
	}

	public String getInstLdapusersearchfilter() {
		return instLdapusersearchfilter;
	}

	public void setInstLdapusersearchfilter(String instLdapusersearchfilter) {
		this.instLdapusersearchfilter = instLdapusersearchfilter;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

}