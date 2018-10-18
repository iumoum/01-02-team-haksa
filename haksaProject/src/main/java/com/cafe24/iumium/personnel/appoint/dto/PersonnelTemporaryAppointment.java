// 이응빈
// 비정규직
package com.cafe24.iumium.personnel.appoint.dto;

public class PersonnelTemporaryAppointment {
	private String appointmentSchoolPersonnelNumber;	// 교직원번호
	private String appointmentTemporaryCareerDivision;	// 경력구분
	private String appointmentTemporaryContractStartTerm;	// 계약시작기간
	private String appointmentTemporaryContractEndTerm;	// 계약만료기간
	private String appointmentTemporaryAppointmentStartTerm;	// 임용시작기간
	private String appointmentTemporaryAppointmentEndTerm;	// 임용만료기간
	private String appointmentTemporaryAppointReason;	// 임명사유
	private String appointmentTemporaryRegistrationDate;	// 시스템등록일자
	private String appointmentTemporaryModificationDate;	// 최종수정일자
	
	// join 하기 위한 변수
	private String personnelCommonAppointmentCodeName;	// 발령코드명
	private String teamNameKorean;	// 팀명(국문)
	private String jobRankNameKorean;	// 직급명(국문)
	private String jobTypeName;	// 직종명
	private String jobGroupName;	// 직군명
	private String appointmentAppointDay;	// 임명일
	
	private String personnelCommonAppointmentCode;	// 발령코드
	private String teamCode;	// 팀코드
	private String haksaJobRank;	// 직급코드
	private String jobTypeCode;	// 직종 코드
	private String jobGroupCode;	// 직군 코드
	
	private String countryCode;	// 국가코드
	private String humanNameEnglish;	// 성명(영어)
	private String humanName;	// 성명
	private String humanGender;	// 성별
	private String humanResidentRegistrationNumber;	// 주민번호
	private String humanMilitaryService;	// 병역여부
	private String humanPicture;	// 사진
	
	private String countryNameKorean;	// 국가명
	
	public String getPersonnelCommonAppointmentCodeName() {
		return personnelCommonAppointmentCodeName;
	}
	public void setPersonnelCommonAppointmentCodeName(String personnelCommonAppointmentCodeName) {
		this.personnelCommonAppointmentCodeName = personnelCommonAppointmentCodeName;
	}
	public String getTeamNameKorean() {
		return teamNameKorean;
	}
	public void setTeamNameKorean(String teamNameKorean) {
		this.teamNameKorean = teamNameKorean;
	}
	public String getJobRankNameKorean() {
		return jobRankNameKorean;
	}
	public void setJobRankNameKorean(String jobRankNameKorean) {
		this.jobRankNameKorean = jobRankNameKorean;
	}
	public String getJobTypeName() {
		return jobTypeName;
	}
	public void setJobTypeName(String jobTypeName) {
		this.jobTypeName = jobTypeName;
	}
	public String getJobGroupName() {
		return jobGroupName;
	}
	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}
	public String getAppointmentAppointDay() {
		return appointmentAppointDay;
	}
	public void setAppointmentAppointDay(String appointmentAppointDay) {
		this.appointmentAppointDay = appointmentAppointDay;
	}
	public String getPersonnelCommonAppointmentCode() {
		return personnelCommonAppointmentCode;
	}
	public void setPersonnelCommonAppointmentCode(String personnelCommonAppointmentCode) {
		this.personnelCommonAppointmentCode = personnelCommonAppointmentCode;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public String getHaksaJobRank() {
		return haksaJobRank;
	}
	public void setHaksaJobRank(String haksaJobRank) {
		this.haksaJobRank = haksaJobRank;
	}
	public String getJobTypeCode() {
		return jobTypeCode;
	}
	public void setJobTypeCode(String jobTypeCode) {
		this.jobTypeCode = jobTypeCode;
	}
	public String getJobGroupCode() {
		return jobGroupCode;
	}
	public void setJobGroupCode(String jobGroupCode) {
		this.jobGroupCode = jobGroupCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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
	public String getCountryNameKorean() {
		return countryNameKorean;
	}
	public void setCountryNameKorean(String countryNameKorean) {
		this.countryNameKorean = countryNameKorean;
	}
	public String getAppointmentSchoolPersonnelNumber() {
		return appointmentSchoolPersonnelNumber;
	}
	public void setAppointmentSchoolPersonnelNumber(String appointmentSchoolPersonnelNumber) {
		this.appointmentSchoolPersonnelNumber = appointmentSchoolPersonnelNumber;
	}
	public String getAppointmentTemporaryCareerDivision() {
		return appointmentTemporaryCareerDivision;
	}
	public void setAppointmentTemporaryCareerDivision(String appointmentTemporaryCareerDivision) {
		this.appointmentTemporaryCareerDivision = appointmentTemporaryCareerDivision;
	}
	public String getAppointmentTemporaryContractStartTerm() {
		return appointmentTemporaryContractStartTerm;
	}
	public void setAppointmentTemporaryContractStartTerm(String appointmentTemporaryContractStartTerm) {
		this.appointmentTemporaryContractStartTerm = appointmentTemporaryContractStartTerm;
	}
	public String getAppointmentTemporaryContractEndTerm() {
		return appointmentTemporaryContractEndTerm;
	}
	public void setAppointmentTemporaryContractEndTerm(String appointmentTemporaryContractEndTerm) {
		this.appointmentTemporaryContractEndTerm = appointmentTemporaryContractEndTerm;
	}
	public String getAppointmentTemporaryAppointmentStartTerm() {
		return appointmentTemporaryAppointmentStartTerm;
	}
	public void setAppointmentTemporaryAppointmentStartTerm(String appointmentTemporaryAppointmentStartTerm) {
		this.appointmentTemporaryAppointmentStartTerm = appointmentTemporaryAppointmentStartTerm;
	}
	public String getAppointmentTemporaryAppointmentEndTerm() {
		return appointmentTemporaryAppointmentEndTerm;
	}
	public void setAppointmentTemporaryAppointmentEndTerm(String appointmentTemporaryAppointmentEndTerm) {
		this.appointmentTemporaryAppointmentEndTerm = appointmentTemporaryAppointmentEndTerm;
	}
	public String getAppointmentTemporaryAppointReason() {
		return appointmentTemporaryAppointReason;
	}
	public void setAppointmentTemporaryAppointReason(String appointmentTemporaryAppointReason) {
		this.appointmentTemporaryAppointReason = appointmentTemporaryAppointReason;
	}
	public String getAppointmentTemporaryRegistrationDate() {
		return appointmentTemporaryRegistrationDate;
	}
	public void setAppointmentTemporaryRegistrationDate(String appointmentTemporaryRegistrationDate) {
		this.appointmentTemporaryRegistrationDate = appointmentTemporaryRegistrationDate;
	}
	public String getAppointmentTemporaryModificationDate() {
		return appointmentTemporaryModificationDate;
	}
	public void setAppointmentTemporaryModificationDate(String appointmentTemporaryModificationDate) {
		this.appointmentTemporaryModificationDate = appointmentTemporaryModificationDate;
	}
	
	@Override
	public String toString() {
		return "PersonnelTemporaryAppointment [appointmentSchoolPersonnelNumber=" + appointmentSchoolPersonnelNumber
				+ ", appointmentTemporaryCareerDivision=" + appointmentTemporaryCareerDivision
				+ ", appointmentTemporaryContractStartTerm=" + appointmentTemporaryContractStartTerm
				+ ", appointmentTemporaryContractEndTerm=" + appointmentTemporaryContractEndTerm
				+ ", appointmentTemporaryAppointmentStartTerm=" + appointmentTemporaryAppointmentStartTerm
				+ ", appointmentTemporaryAppointmentEndTerm=" + appointmentTemporaryAppointmentEndTerm
				+ ", appointmentTemporaryAppointReason=" + appointmentTemporaryAppointReason
				+ ", appointmentTemporaryRegistrationDate=" + appointmentTemporaryRegistrationDate
				+ ", appointmentTemporaryModificationDate=" + appointmentTemporaryModificationDate + "]";
	}
}
