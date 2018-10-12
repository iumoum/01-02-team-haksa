package com.cafe24.iumium.schoolregister.studentinfo.dto;

public class ClassChange {
	private String classChangeNumber;	// 반 변경 번호
	private String recordId;	// 시스템 등록자아이디
	private String studentNumber;	// 학번
	private String classChangeBefore;	// 변경 전 반
	private String classChangeAfter;	// 변경 후 반
	private String classChangeBeforeDayAndNight;	// 변경 전 주야
	private String classChangeAfterDayAndNight;	// 변경 후 주야
	private String classChangeDegreeSeparation;	// 차수구분
	private String classChangeReason;	// 변경사유
	private String classChangeDate;	// 변경일자
	private String systemRegistrationDate;	// 시스템등록일자
	
	public String getClassChangeNumber() {
		return classChangeNumber;
	}
	public void setClassChangeNumber(String classChangeNumber) {
		this.classChangeNumber = classChangeNumber;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getClassChangeBefore() {
		return classChangeBefore;
	}
	public void setClassChangeBefore(String classChangeBefore) {
		this.classChangeBefore = classChangeBefore;
	}
	public String getClassChangeAfter() {
		return classChangeAfter;
	}
	public void setClassChangeAfter(String classChangeAfter) {
		this.classChangeAfter = classChangeAfter;
	}
	public String getClassChangeBeforeDayAndNight() {
		return classChangeBeforeDayAndNight;
	}
	public void setClassChangeBeforeDayAndNight(String classChangeBeforeDayAndNight) {
		this.classChangeBeforeDayAndNight = classChangeBeforeDayAndNight;
	}
	public String getClassChangeAfterDayAndNight() {
		return classChangeAfterDayAndNight;
	}
	public void setClassChangeAfterDayAndNight(String classChangeAfterDayAndNight) {
		this.classChangeAfterDayAndNight = classChangeAfterDayAndNight;
	}
	public String getClassChangeDegreeSeparation() {
		return classChangeDegreeSeparation;
	}
	public void setClassChangeDegreeSeparation(String classChangeDegreeSeparation) {
		this.classChangeDegreeSeparation = classChangeDegreeSeparation;
	}
	public String getClassChangeReason() {
		return classChangeReason;
	}
	public void setClassChangeReason(String classChangeReason) {
		this.classChangeReason = classChangeReason;
	}
	public String getClassChangeDate() {
		return classChangeDate;
	}
	public void setClassChangeDate(String classChangeDate) {
		this.classChangeDate = classChangeDate;
	}
	public String getSystemRegistrationDate() {
		return systemRegistrationDate;
	}
	public void setSystemRegistrationDate(String systemRegistrationDate) {
		this.systemRegistrationDate = systemRegistrationDate;
	}
}
