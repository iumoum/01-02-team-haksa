package com.cafe24.iumium.schoolregister.studentinfo.dto;

public class MyProfile {
	private String studentNumber;	// 학번
	private String humanPhoneNumber;	// 전화번호
	private String humanEmail;	// 이메일
	private String humanAddress;	// 주소
	private String recordId;	// 시스템 등록자 아이디
	
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
}
