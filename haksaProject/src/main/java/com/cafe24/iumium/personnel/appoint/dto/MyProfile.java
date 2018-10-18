// 이응빈
// 신상명세정보
package com.cafe24.iumium.personnel.appoint.dto;

public class MyProfile {
	private String studentTeacherNo;	// 학번교직원번호
	private String recordId;	// 등록자아이디
	private String humanPhoneNumber;	// 전화번호
	private String humanEmail;	// 이메일
	private String humanAddress;	// 주소
	private String humanEnglishAddress;	// 영문주소
	private String humanRegistrationDay;	// 시스템등록일자
	private String humanModificationDate;	// 최종수정일자
	
	public String getStudentTeacherNo() {
		return studentTeacherNo;
	}
	public void setStudentTeacherNo(String studentTeacherNo) {
		this.studentTeacherNo = studentTeacherNo;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getHumanPhoneNumber() {
		return humanPhoneNumber;
	}
	public void setHumanPhoneNumber(String humanPhoneNumber) {
		this.humanPhoneNumber = humanPhoneNumber;
	}
	public String getHumanEmail() {
		return humanEmail;
	}
	public void setHumanEmail(String humanEmail) {
		this.humanEmail = humanEmail;
	}
	public String getHumanAddress() {
		return humanAddress;
	}
	public void setHumanAddress(String humanAddress) {
		this.humanAddress = humanAddress;
	}
	public String getHumanEnglishAddress() {
		return humanEnglishAddress;
	}
	public void setHumanEnglishAddress(String humanEnglishAddress) {
		this.humanEnglishAddress = humanEnglishAddress;
	}
	public String getHumanRegistrationDay() {
		return humanRegistrationDay;
	}
	public void setHumanRegistrationDay(String humanRegistrationDay) {
		this.humanRegistrationDay = humanRegistrationDay;
	}
	public String getHumanModificationDate() {
		return humanModificationDate;
	}
	public void setHumanModificationDate(String humanModificationDate) {
		this.humanModificationDate = humanModificationDate;
	}
}
