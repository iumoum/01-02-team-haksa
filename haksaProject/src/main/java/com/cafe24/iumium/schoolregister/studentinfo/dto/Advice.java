package com.cafe24.iumium.schoolregister.studentinfo.dto;

public class Advice {
	private String adviceHistoryNumber;	// 상담내역번호
	private String counselResultCode;	// 상담결과코드
	private String appointmentSchoolPersonnelNumber;	// 교직원번호
	private String studentNumber;	// 학번
	private String adviceContent;	// 상담내용
	private String adviceDate;	// 상담일자
	private String systemRegistrationDate;	// 시스템등록일자
	
	// join을 위한 변수
	private String counselResultName;	// 상담결과명
	private String counselTypeName;	// 상담구분명
	private String teacherName; // 지도교수명
	private String studentName; // 학생명
	
	public String getAdviceHistoryNumber() {
		return adviceHistoryNumber;
	}
	public void setAdviceHistoryNumber(String adviceHistoryNumber) {
		this.adviceHistoryNumber = adviceHistoryNumber;
	}
	public String getCounselResultCode() {
		return counselResultCode;
	}
	public void setCounselResultCode(String counselResultCode) {
		this.counselResultCode = counselResultCode;
	}
	public String getAppointmentSchoolPersonnelNumber() {
		return appointmentSchoolPersonnelNumber;
	}
	public void setAppointmentSchoolPersonnelNumber(String appointmentSchoolPersonnelNumber) {
		this.appointmentSchoolPersonnelNumber = appointmentSchoolPersonnelNumber;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getAdviceContent() {
		return adviceContent;
	}
	public void setAdviceContent(String adviceContent) {
		this.adviceContent = adviceContent;
	}
	public String getAdviceDate() {
		return adviceDate;
	}
	public void setAdviceDate(String adviceDate) {
		this.adviceDate = adviceDate;
	}
	public String getSystemRegistrationDate() {
		return systemRegistrationDate;
	}
	public void setSystemRegistrationDate(String systemRegistrationDate) {
		this.systemRegistrationDate = systemRegistrationDate;
	}
	public String getCounselResultName() {
		return counselResultName;
	}
	public void setCounselResultName(String counselResultName) {
		this.counselResultName = counselResultName;
	}
	public String getCounselTypeName() {
		return counselTypeName;
	}
	public void setCounselTypeName(String counselTypeName) {
		this.counselTypeName = counselTypeName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
