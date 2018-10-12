package com.cafe24.iumium.schoolregister.studentinfo.dto;

public class Family {
	private int familyNumber;	// 가족사항번호
	private String studentNumber;	// 학번
	private String familyRelationship;	// 가족관계
	private String familyPhoneNumber;	//가족의 전화번호
	private String familyBirthday;	// 가족의 생년월일
	private String familyAcademicBackground;	// 가족의 학력
	private String familyJob;	//가족의 직업
	private String familyResidence;	// 가족의 주소
	
	public int getFamilyNumber() {
		return familyNumber;
	}
	public void setFamilyNumber(int familyNumber) {
		this.familyNumber = familyNumber;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getFamilyRelationship() {
		return familyRelationship;
	}
	public void setFamilyRelationship(String familyRelationship) {
		this.familyRelationship = familyRelationship;
	}
	public String getFamilyPhoneNumber() {
		return familyPhoneNumber;
	}
	public void setFamilyPhoneNumber(String familyPhoneNumber) {
		this.familyPhoneNumber = familyPhoneNumber;
	}
	public String getFamilyBirthday() {
		return familyBirthday;
	}
	public void setFamilyBirthday(String familyBirthday) {
		this.familyBirthday = familyBirthday;
	}
	public String getFamilyAcademicBackground() {
		return familyAcademicBackground;
	}
	public void setFamilyAcademicBackground(String familyAcademicBackground) {
		this.familyAcademicBackground = familyAcademicBackground;
	}
	public String getFamilyJob() {
		return familyJob;
	}
	public void setFamilyJob(String familyJob) {
		this.familyJob = familyJob;
	}
	public String getFamilyResidence() {
		return familyResidence;
	}
	public void setFamilyResidence(String familyResidence) {
		this.familyResidence = familyResidence;
	}
}
