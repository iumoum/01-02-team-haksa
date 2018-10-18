// 이응빈
// 승진처리
package com.cafe24.iumium.personnel.appoint.dto;

public class PersonnelPromotion {
	private String promotionNumber;	// 승진번호
	private String recordId;	// 시스템등록자아이디
	private String appointmentSchoolPersonnelNumber;	// 교직원번호
	private String rankCode;	// 발령직급
	private int promotionAppointmentAnnualIncome;	// 발령연봉
	private int promotionAppointmentSalaryclass;	// 발령호봉
	private String promotionDay;	// 승진일
	private String promotionAppointmentDay;	// 임용일
	private String promotionAppointReason;	// 임명사유
	private String promotionRegistrationDate;	// 시스템등록일자
	private String promotionModificationDate;	// 최종수정일자
	
	public String getPromotionNumber() {
		return promotionNumber;
	}
	public void setPromotionNumber(String promotionNumber) {
		this.promotionNumber = promotionNumber;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getAppointmentSchoolPersonnelNumber() {
		return appointmentSchoolPersonnelNumber;
	}
	public void setAppointmentSchoolPersonnelNumber(String appointmentSchoolPersonnelNumber) {
		this.appointmentSchoolPersonnelNumber = appointmentSchoolPersonnelNumber;
	}
	public String getRankCode() {
		return rankCode;
	}
	public void setRankCode(String rankCode) {
		this.rankCode = rankCode;
	}
	public int getPromotionAppointmentAnnualIncome() {
		return promotionAppointmentAnnualIncome;
	}
	public void setPromotionAppointmentAnnualIncome(int promotionAppointmentAnnualIncome) {
		this.promotionAppointmentAnnualIncome = promotionAppointmentAnnualIncome;
	}
	public int getPromotionAppointmentSalaryclass() {
		return promotionAppointmentSalaryclass;
	}
	public void setPromotionAppointmentSalaryclass(int promotionAppointmentSalaryclass) {
		this.promotionAppointmentSalaryclass = promotionAppointmentSalaryclass;
	}
	public String getPromotionDay() {
		return promotionDay;
	}
	public void setPromotionDay(String promotionDay) {
		this.promotionDay = promotionDay;
	}
	public String getPromotionAppointmentDay() {
		return promotionAppointmentDay;
	}
	public void setPromotionAppointmentDay(String promotionAppointmentDay) {
		this.promotionAppointmentDay = promotionAppointmentDay;
	}
	public String getPromotionAppointReason() {
		return promotionAppointReason;
	}
	public void setPromotionAppointReason(String promotionAppointReason) {
		this.promotionAppointReason = promotionAppointReason;
	}
	public String getPromotionRegistrationDate() {
		return promotionRegistrationDate;
	}
	public void setPromotionRegistrationDate(String promotionRegistrationDate) {
		this.promotionRegistrationDate = promotionRegistrationDate;
	}
	public String getPromotionModificationDate() {
		return promotionModificationDate;
	}
	public void setPromotionModificationDate(String promotionModificationDate) {
		this.promotionModificationDate = promotionModificationDate;
	}
}
