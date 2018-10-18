package com.cafe24.iumium.personnel.code.dto;

public class RewardPunishmentCode {
	private String rewardPunishmentCode;
	private String rewardPunishmentCodeName;
	private String rewardChangeReasonCause;
	private String rewardPunishmentDivision;
	private char rewardPunishmentUseExistenceNonexistence;
	private String rewardPunishmentRegistrationDate;
	private String rewardPunishmentModificationDate;
	
	public String getRewardPunishmentCode() {
		return rewardPunishmentCode;
	}
	public void setRewardPunishmentCode(String rewardPunishmentCode) {
		this.rewardPunishmentCode = rewardPunishmentCode;
	}
	public String getRewardPunishmentCodeName() {
		return rewardPunishmentCodeName;
	}
	public void setRewardPunishmentCodeName(String rewardPunishmentCodeName) {
		this.rewardPunishmentCodeName = rewardPunishmentCodeName;
	}
	public String getRewardChangeReasonCause() {
		return rewardChangeReasonCause;
	}
	public void setRewardChangeReasonCause(String rewardChangeReasonCause) {
		this.rewardChangeReasonCause = rewardChangeReasonCause;
	}
	public String getRewardPunishmentDivision() {
		return rewardPunishmentDivision;
	}
	public void setRewardPunishmentDivision(String rewardPunishmentDivision) {
		this.rewardPunishmentDivision = rewardPunishmentDivision;
	}
	public char getRewardPunishmentUseExistenceNonexistence() {
		return rewardPunishmentUseExistenceNonexistence;
	}
	public void setRewardPunishmentUseExistenceNonexistence(char rewardPunishmentUseExistenceNonexistence) {
		this.rewardPunishmentUseExistenceNonexistence = rewardPunishmentUseExistenceNonexistence;
	}
	public String getRewardPunishmentRegistrationDate() {
		return rewardPunishmentRegistrationDate;
	}
	public void setRewardPunishmentRegistrationDate(String rewardPunishmentRegistrationDate) {
		this.rewardPunishmentRegistrationDate = rewardPunishmentRegistrationDate;
	}
	public String getRewardPunishmentModificationDate() {
		return rewardPunishmentModificationDate;
	}
	public void setRewardPunishmentModificationDate(String rewardPunishmentModificationDate) {
		this.rewardPunishmentModificationDate = rewardPunishmentModificationDate;
	}
	
	@Override
	public String toString() {
		return "RewardPunishmentCode [rewardPunishmentCode=" + rewardPunishmentCode + ", rewardPunishmentCodeName="
				+ rewardPunishmentCodeName + ", rewardChangeReasonCause=" + rewardChangeReasonCause
				+ ", rewardPunishmentDivision=" + rewardPunishmentDivision
				+ ", rewardPunishmentUseExistenceNonexistence=" + rewardPunishmentUseExistenceNonexistence
				+ ", rewardPunishmentRegistrationDate=" + rewardPunishmentRegistrationDate
				+ ", rewardPunishmentModificationDate=" + rewardPunishmentModificationDate + "]";
	}
}
