package com.cafe24.iumium.personnel.code.dto;

public class CertificateCode {
	private String certificateCode;
	private String certificateCodeName;
	private String certificateChangeReasonCause;
	private String certificatePersonnelPayDivision;
	private char certificateUseExistenceNonexistence;
	private String certificateRegistrationDate;
	private String certificateModificationDate;
	
	public String getCertificateCode() {
		return certificateCode;
	}
	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}
	public String getCertificateCodeName() {
		return certificateCodeName;
	}
	public void setCertificateCodeName(String certificateCodeName) {
		this.certificateCodeName = certificateCodeName;
	}
	public String getCertificateChangeReasonCause() {
		return certificateChangeReasonCause;
	}
	public void setCertificateChangeReasonCause(String certificateChangeReasonCause) {
		this.certificateChangeReasonCause = certificateChangeReasonCause;
	}
	public String getCertificatePersonnelPayDivision() {
		return certificatePersonnelPayDivision;
	}
	public void setCertificatePersonnelPayDivision(String certificatePersonnelPayDivision) {
		this.certificatePersonnelPayDivision = certificatePersonnelPayDivision;
	}
	public char getCertificateUseExistenceNonexistence() {
		return certificateUseExistenceNonexistence;
	}
	public void setCertificateUseExistenceNonexistence(char certificateUseExistenceNonexistence) {
		this.certificateUseExistenceNonexistence = certificateUseExistenceNonexistence;
	}
	public String getCertificateRegistrationDate() {
		return certificateRegistrationDate;
	}
	public void setCertificateRegistrationDate(String certificateRegistrationDate) {
		this.certificateRegistrationDate = certificateRegistrationDate;
	}
	public String getCertificateModificationDate() {
		return certificateModificationDate;
	}
	public void setCertificateModificationDate(String certificateModificationDate) {
		this.certificateModificationDate = certificateModificationDate;
	}
	
	@Override
	public String toString() {
		return "CertificateCode [certificateCode=" + certificateCode + ", certificateCodeName=" + certificateCodeName
				+ ", certificateChangeReasonCause=" + certificateChangeReasonCause
				+ ", certificatePersonnelPayDivision=" + certificatePersonnelPayDivision
				+ ", certificateUseExistenceNonexistence=" + certificateUseExistenceNonexistence
				+ ", certificateRegistrationDate=" + certificateRegistrationDate + ", certificateModificationDate="
				+ certificateModificationDate + "]";
	}
}
