package com.cafe24.iumium.personnel.code.dto;

public class TrainingCode {
	private String trainingCode;
	private String trainingCodeName;
	private String trainingHomeAndAbroadDivision;
	private String trainingChangeReasonCause;
	private char trainingUseExistenceNonexistence;
	private String trainingRegistrationDate;
	private String trainingModificationDate;
	
	public String getTrainingCode() {
		return trainingCode;
	}
	public void setTrainingCode(String trainingCode) {
		this.trainingCode = trainingCode;
	}
	public String getTrainingCodeName() {
		return trainingCodeName;
	}
	public void setTrainingCodeName(String trainingCodeName) {
		this.trainingCodeName = trainingCodeName;
	}
	public String getTrainingHomeAndAbroadDivision() {
		return trainingHomeAndAbroadDivision;
	}
	public void setTrainingHomeAndAbroadDivision(String trainingHomeAndAbroadDivision) {
		this.trainingHomeAndAbroadDivision = trainingHomeAndAbroadDivision;
	}
	public String getTrainingChangeReasonCause() {
		return trainingChangeReasonCause;
	}
	public void setTrainingChangeReasonCause(String trainingChangeReasonCause) {
		this.trainingChangeReasonCause = trainingChangeReasonCause;
	}
	public char getTrainingUseExistenceNonexistence() {
		return trainingUseExistenceNonexistence;
	}
	public void setTrainingUseExistenceNonexistence(char trainingUseExistenceNonexistence) {
		this.trainingUseExistenceNonexistence = trainingUseExistenceNonexistence;
	}
	public String getTrainingRegistrationDate() {
		return trainingRegistrationDate;
	}
	public void setTrainingRegistrationDate(String trainingRegistrationDate) {
		this.trainingRegistrationDate = trainingRegistrationDate;
	}
	public String getTrainingModificationDate() {
		return trainingModificationDate;
	}
	public void setTrainingModificationDate(String trainingModificationDate) {
		this.trainingModificationDate = trainingModificationDate;
	}
	
	@Override
	public String toString() {
		return "TrainingCode [trainingCode=" + trainingCode + ", trainingCodeName=" + trainingCodeName
				+ ", trainingHomeAndAbroadDivision=" + trainingHomeAndAbroadDivision + ", trainingChangeReasonCause="
				+ trainingChangeReasonCause + ", trainingUseExistenceNonexistence=" + trainingUseExistenceNonexistence
				+ ", trainingRegistrationDate=" + trainingRegistrationDate + ", trainingModificationDate="
				+ trainingModificationDate + "]";
	}
}
