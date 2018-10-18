package com.cafe24.iumium.personnel.code.dto;

public class PersonnelCommonCode {
	private String personnelCommonAppointmentCode;
	private String personnelCommonAppointmentCodeName;
	private char personnelCommonUseExistenceNonexistence;
	private String personnelCommonRegistrationDate;
	private String personnelCommonModificationDate;
	
	public String getPersonnelCommonAppointmentCode() {
		return personnelCommonAppointmentCode;
	}
	public void setPersonnelCommonAppointmentCode(String personnelCommonAppointmentCode) {
		this.personnelCommonAppointmentCode = personnelCommonAppointmentCode;
	}
	public String getPersonnelCommonAppointmentCodeName() {
		return personnelCommonAppointmentCodeName;
	}
	public void setPersonnelCommonAppointmentCodeName(String personnelCommonAppointmentCodeName) {
		this.personnelCommonAppointmentCodeName = personnelCommonAppointmentCodeName;
	}
	public char getPersonnelCommonUseExistenceNonexistence() {
		return personnelCommonUseExistenceNonexistence;
	}
	public void setPersonnelCommonUseExistenceNonexistence(char personnelCommonUseExistenceNonexistence) {
		this.personnelCommonUseExistenceNonexistence = personnelCommonUseExistenceNonexistence;
	}
	public String getPersonnelCommonRegistrationDate() {
		return personnelCommonRegistrationDate;
	}
	public void setPersonnelCommonRegistrationDate(String personnelCommonRegistrationDate) {
		this.personnelCommonRegistrationDate = personnelCommonRegistrationDate;
	}
	public String getPersonnelCommonModificationDate() {
		return personnelCommonModificationDate;
	}
	public void setPersonnelCommonModificationDate(String personnelCommonModificationDate) {
		this.personnelCommonModificationDate = personnelCommonModificationDate;
	}
	
	// 값이 제대로 담겼는지 확인하기위해 toString메소드 작성
	@Override
	public String toString() {
		return "PersonnelCommonCode [personnelCommonAppointmentCode=" + personnelCommonAppointmentCode
				+ ", personnelCommonAppointmentCodeName=" + personnelCommonAppointmentCodeName
				+ ", personnelCommonUseExistenceNonexistence=" + personnelCommonUseExistenceNonexistence
				+ ", personnelCommonRegistrationDate=" + personnelCommonRegistrationDate
				+ ", personnelCommonModificationDate=" + personnelCommonModificationDate + "]";
	}
}
