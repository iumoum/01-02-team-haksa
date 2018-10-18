// 이응빈
// 고등학력사항
package com.cafe24.iumium.personnel.appoint.dto;

public class HighSchool {
	private String studentTeacherNo;	// 학번교직원번호
	private String recordId;	// 등록자아이디
	private String highSchoolSchoolName;	// 학교명
	private String highSchoolGraduation;	// 졸업일자
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
	public String getHighSchoolSchoolName() {
		return highSchoolSchoolName;
	}
	public void setHighSchoolSchoolName(String highSchoolSchoolName) {
		this.highSchoolSchoolName = highSchoolSchoolName;
	}
	public String getHighSchoolGraduation() {
		return highSchoolGraduation;
	}
	public void setHighSchoolGraduation(String highSchoolGraduation) {
		this.highSchoolGraduation = highSchoolGraduation;
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
