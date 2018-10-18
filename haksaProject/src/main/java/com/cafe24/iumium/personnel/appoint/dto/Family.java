// 이응빈
// 가족사항
package com.cafe24.iumium.personnel.appoint.dto;

public class Family {
	private String familyNumber;	// 가족사항번호
	private String recordId;	// 등록자 아이디
	private String studentTeacherNo;	// 학번교직원번호
	private String familyRelationship;	// 가족관계
	private String familyPhoneNumber;	// 가족전화번호
	private String familyBirthday;	// 생년월일
	private String familyAcademicBackground;	// 학력
	private String familyJob;	// 직업
	private String familyResidence;	// 거주지(시,군)
	private String humanRegistrationDay;	// 시스템등록일자
	private String humanModificationDate;	// 최종수정일자
	private String familyName;	// 성명
	
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilyNumber() {
		return familyNumber;
	}
	public void setFamilyNumber(String familyNumber) {
		this.familyNumber = familyNumber;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getStudentTeacherNo() {
		return studentTeacherNo;
	}
	public void setStudentTeacherNo(String studentTeacherNo) {
		this.studentTeacherNo = studentTeacherNo;
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
