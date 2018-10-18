package com.cafe24.iumium.personnel.code.dto;

public class CertificatePurposeCode {
	private String certificatePurposeCode;
	private String certificatePurposeCodeName;
	private String certificatePurposeChangeReasonCause;
	private String certificatePurposePersonnelPayDivision;
	private char certificatePurposeUseExistenceNonexistence;
	private String certificatePurposeRegistrationDate;
	private String certificatePurposeModificationDate;
	public String getCertificatePurposeCode() {
		return certificatePurposeCode;
	}
	public void setCertificatePurposeCode(String certificatePurposeCode) {
		this.certificatePurposeCode = certificatePurposeCode;
	}
	public String getCertificatePurposeCodeName() {
		return certificatePurposeCodeName;
	}
	public void setCertificatePurposeCodeName(String certificatePurposeCodeName) {
		this.certificatePurposeCodeName = certificatePurposeCodeName;
	}
	public String getCertificatePurposeChangeReasonCause() {
		return certificatePurposeChangeReasonCause;
	}
	public void setCertificatePurposeChangeReasonCause(String certificatePurposeChangeReasonCause) {
		this.certificatePurposeChangeReasonCause = certificatePurposeChangeReasonCause;
	}
	public String getCertificatePurposePersonnelPayDivision() {
		return certificatePurposePersonnelPayDivision;
	}
	public void setCertificatePurposePersonnelPayDivision(String certificatePurposePersonnelPayDivision) {
		this.certificatePurposePersonnelPayDivision = certificatePurposePersonnelPayDivision;
	}
	public char getCertificatePurposeUseExistenceNonexistence() {
		return certificatePurposeUseExistenceNonexistence;
	}
	public void setCertificatePurposeUseExistenceNonexistence(char certificatePurposeUseExistenceNonexistence) {
		this.certificatePurposeUseExistenceNonexistence = certificatePurposeUseExistenceNonexistence;
	}
	public String getCertificatePurposeRegistrationDate() {
		return certificatePurposeRegistrationDate;
	}
	public void setCertificatePurposeRegistrationDate(String certificatePurposeRegistrationDate) {
		this.certificatePurposeRegistrationDate = certificatePurposeRegistrationDate;
	}
	public String getCertificatePurposeModificationDate() {
		return certificatePurposeModificationDate;
	}
	public void setCertificatePurposeModificationDate(String certificatePurposeModificationDate) {
		this.certificatePurposeModificationDate = certificatePurposeModificationDate;
	}
	
	@Override
	public String toString() {
		return "CertificatePurposeCode [certificatePurposeCode=" + certificatePurposeCode
				+ ", certificatePurposeCodeName=" + certificatePurposeCodeName
				+ ", certificatePurposeChangeReasonCause=" + certificatePurposeChangeReasonCause
				+ ", certificatePurposePersonnelPayDivision=" + certificatePurposePersonnelPayDivision
				+ ", certificatePurposeUseExistenceNonexistence=" + certificatePurposeUseExistenceNonexistence
				+ ", certificatePurposeRegistrationDate=" + certificatePurposeRegistrationDate
				+ ", certificatePurposeModificationDate=" + certificatePurposeModificationDate + "]";
	}
}
