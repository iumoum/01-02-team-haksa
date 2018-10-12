package com.cafe24.iumium.schoolregister.studentinfo.dto;

public class ScholarshipBenefit {
	private String scholarshipBenefitNumber;	//장학금수혜번호
	private String studentNumber;	// 학번
	private String recordId;	// 시스템등록자아이디
	private String scholarshipName;	// 장학명
	private int scholarship;	// 장학금액
	private String scholarshipSeparation;	// 장학금(구분)
	private String scholarshipGiveOrganization;	// 수여기관
	private String scholarshipDetail;	// 상세내용
	private String scholarshipFile;	// 첨부파일
	private String scholarshipGiveDate;	// 지급일자
	private String systemRegistrationDate;	// 시스템등록일자
	
	public String getScholarshipBenefitNumber() {
		return scholarshipBenefitNumber;
	}
	public void setScholarshipBenefitNumber(String scholarshipBenefitNumber) {
		this.scholarshipBenefitNumber = scholarshipBenefitNumber;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getScholarshipName() {
		return scholarshipName;
	}
	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}
	public int getScholarship() {
		return scholarship;
	}
	public void setScholarship(int scholarship) {
		this.scholarship = scholarship;
	}
	public String getScholarshipSeparation() {
		return scholarshipSeparation;
	}
	public void setScholarshipSeparation(String scholarshipSeparation) {
		this.scholarshipSeparation = scholarshipSeparation;
	}
	public String getScholarshipGiveOrganization() {
		return scholarshipGiveOrganization;
	}
	public void setScholarshipGiveOrganization(String scholarshipGiveOrganization) {
		this.scholarshipGiveOrganization = scholarshipGiveOrganization;
	}
	public String getScholarshipDetail() {
		return scholarshipDetail;
	}
	public void setScholarshipDetail(String scholarshipDetail) {
		this.scholarshipDetail = scholarshipDetail;
	}
	public String getScholarshipFile() {
		return scholarshipFile;
	}
	public void setScholarshipFile(String scholarshipFile) {
		this.scholarshipFile = scholarshipFile;
	}
	public String getScholarshipGiveDate() {
		return scholarshipGiveDate;
	}
	public void setScholarshipGiveDate(String scholarshipGiveDate) {
		this.scholarshipGiveDate = scholarshipGiveDate;
	}
	public String getSystemRegistrationDate() {
		return systemRegistrationDate;
	}
	public void setSystemRegistrationDate(String systemRegistrationDate) {
		this.systemRegistrationDate = systemRegistrationDate;
	}
}
