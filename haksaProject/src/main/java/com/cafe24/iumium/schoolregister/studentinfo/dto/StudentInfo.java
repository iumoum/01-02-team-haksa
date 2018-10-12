package com.cafe24.iumium.schoolregister.studentinfo.dto;

public class StudentInfo {
	private String studentNumber;	// 학번
	private String deptCode;	// 부서코드
	private String classByDepartmentNumber;	// 학과별 반 번호
	private String recordId;	// 시스템등록자아이디
	private String studentState;	// 학생상태
	private String studentEntranceDepartment;	// 입학학과
	private String studentEntranceDayAndNight;	// 입학주야
	private String studentGraduationDepartment;	// 졸업학과
	private String studentGraduationCertificateNumber;	// 졸업증서번호
	private String studentDegreeNumber;	// 학위번호
	private String studentEntranceDate;	// 입학일자
	private String studentGraduationScheduleDate;	// 졸업예정일자
	private String systemRegistrationDate;	// 시스템등록일자
	
	/*	join하기 위한 변수 */
	private int classByDepartmentGrade;	// 학년
	private String classByDepartmentClass;	// 반
	private String classByDepartmentDayAndNight;	// 주야
	private String deptNameKorean;	// 학과명
	private String countryCode;	// 국가코드
	private String countryNameKorean;	// 국가명
	private String humanNameEnglish;	// 성명(영어)
	private String humanName;	// 이름
	private String humanGender;	// 성별
	private String humanResidentRegistrationNumber;	// 주민번호
	private String humanMilitaryService; // 병역여부
	private String humanPicture;	// 사진
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getClassByDepartmentNumber() {
		return classByDepartmentNumber;
	}
	public void setClassByDepartmentNumber(String classByDepartmentNumber) {
		this.classByDepartmentNumber = classByDepartmentNumber;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getStudentState() {
		return studentState;
	}
	public void setStudentState(String studentState) {
		this.studentState = studentState;
	}
	public String getStudentEntranceDepartment() {
		return studentEntranceDepartment;
	}
	public void setStudentEntranceDepartment(String studentEntranceDepartment) {
		this.studentEntranceDepartment = studentEntranceDepartment;
	}
	public String getStudentEntranceDayAndNight() {
		return studentEntranceDayAndNight;
	}
	public void setStudentEntranceDayAndNight(String studentEntranceDayAndNight) {
		this.studentEntranceDayAndNight = studentEntranceDayAndNight;
	}
	public String getStudentGraduationDepartment() {
		return studentGraduationDepartment;
	}
	public void setStudentGraduationDepartment(String studentGraduationDepartment) {
		this.studentGraduationDepartment = studentGraduationDepartment;
	}
	public String getStudentGraduationCertificateNumber() {
		return studentGraduationCertificateNumber;
	}
	public void setStudentGraduationCertificateNumber(String studentGraduationCertificateNumber) {
		this.studentGraduationCertificateNumber = studentGraduationCertificateNumber;
	}
	public String getStudentDegreeNumber() {
		return studentDegreeNumber;
	}
	public void setStudentDegreeNumber(String studentDegreeNumber) {
		this.studentDegreeNumber = studentDegreeNumber;
	}
	public String getStudentEntranceDate() {
		return studentEntranceDate;
	}
	public void setStudentEntranceDate(String studentEntranceDate) {
		this.studentEntranceDate = studentEntranceDate;
	}
	public String getStudentGraduationScheduleDate() {
		return studentGraduationScheduleDate;
	}
	public void setStudentGraduationScheduleDate(String studentGraduationScheduleDate) {
		this.studentGraduationScheduleDate = studentGraduationScheduleDate;
	}
	public String getSystemRegistrationDate() {
		return systemRegistrationDate;
	}
	public void setSystemRegistrationDate(String systemRegistrationDate) {
		this.systemRegistrationDate = systemRegistrationDate;
	}
	public int getClassByDepartmentGrade() {
		return classByDepartmentGrade;
	}
	public void setClassByDepartmentGrade(int classByDepartmentGrade) {
		this.classByDepartmentGrade = classByDepartmentGrade;
	}
	public String getClassByDepartmentClass() {
		return classByDepartmentClass;
	}
	public void setClassByDepartmentClass(String classByDepartmentClass) {
		this.classByDepartmentClass = classByDepartmentClass;
	}
	public String getClassByDepartmentDayAndNight() {
		return classByDepartmentDayAndNight;
	}
	public void setClassByDepartmentDayAndNight(String classByDepartmentDayAndNight) {
		this.classByDepartmentDayAndNight = classByDepartmentDayAndNight;
	}
	public String getDeptNameKorean() {
		return deptNameKorean;
	}
	public void setDeptNameKorean(String deptNameKorean) {
		this.deptNameKorean = deptNameKorean;
	}
	public String getCountryNameKorean() {
		return countryNameKorean;
	}
	public void setCountryNameKorean(String countryNameKorean) {
		this.countryNameKorean = countryNameKorean;
	}
	public String getHumanNameEnglish() {
		return humanNameEnglish;
	}
	public void setHumanNameEnglish(String humanNameEnglish) {
		this.humanNameEnglish = humanNameEnglish;
	}
	public String getHumanName() {
		return humanName;
	}
	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}
	public String getHumanGender() {
		return humanGender;
	}
	public void setHumanGender(String humanGender) {
		this.humanGender = humanGender;
	}
	public String getHumanResidentRegistrationNumber() {
		return humanResidentRegistrationNumber;
	}
	public void setHumanResidentRegistrationNumber(String humanResidentRegistrationNumber) {
		this.humanResidentRegistrationNumber = humanResidentRegistrationNumber;
	}
	public String getHumanMilitaryService() {
		return humanMilitaryService;
	}
	public void setHumanMilitaryService(String humanMilitaryService) {
		this.humanMilitaryService = humanMilitaryService;
	}
	public String getHumanPicture() {
		return humanPicture;
	}
	public void setHumanPicture(String humanPicture) {
		this.humanPicture = humanPicture;
	}
}
