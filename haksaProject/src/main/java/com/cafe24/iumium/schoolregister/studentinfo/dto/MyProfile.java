package com.cafe24.iumium.schoolregister.studentinfo.dto;

public class MyProfile {
	private String studentNumber;	// 학번
	private String humanPhoneNumber;	// 전화번호
	private String humanEmail;	// 이메일
	private String humanAddress;	// 주소
	private String humanEnglishAddress;	// 영문 주소
	
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
	public String getHumanEnglishAddress() {
		return humanEnglishAddress;
	}
	public void setHumanEnglishAddress(String humanEnglishAddress) {
		this.humanEnglishAddress = humanEnglishAddress;
	}
}
