// 이응빈
// 무기계약
package com.cafe24.iumium.personnel.appoint.dto;

public class PersonnelAppointmentOther {
	private String appointmentSchoolPersonnelNumber;	// 교직원번호
	private String jobPositionCode;	// 직위
	private int otherAppointmentAnnualIncome;	// 지급연봉
	private String otherAppointmentCareerDivision;	// 경력구분
	private String otherAppointmentContractStartTerm;	// 계약시작기간
	private String otherAppointmentContractEndTerm;	// 계약만료기간
	private String otherAppointmentPositionTeam;	// 보(겸)직팀
	private int otherAppointmentSalaryclass;	// 호봉
	private String otherAppointmentSalaryclassPromotion;	// 호봉승급월
	private String otherAppointmentRegistrationDate;	// 시스템등록일자
	private String otherAppointmentModificationDate;	// 최종수정일자
	
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

	public String getAppointmentSchoolPersonnelNumber() {
		return appointmentSchoolPersonnelNumber;
	}

	public void setAppointmentSchoolPersonnelNumber(String appointmentSchoolPersonnelNumber) {
		this.appointmentSchoolPersonnelNumber = appointmentSchoolPersonnelNumber;
	}

	public String getJobPositionCode() {
		return jobPositionCode;
	}

	public void setJobPositionCode(String jobPositionCode) {
		this.jobPositionCode = jobPositionCode;
	}

	public int getOtherAppointmentAnnualIncome() {
		return otherAppointmentAnnualIncome;
	}

	public void setOtherAppointmentAnnualIncome(int otherAppointmentAnnualIncome) {
		this.otherAppointmentAnnualIncome = otherAppointmentAnnualIncome;
	}

	public String getOtherAppointmentCareerDivision() {
		return otherAppointmentCareerDivision;
	}

	public void setOtherAppointmentCareerDivision(String otherAppointmentCareerDivision) {
		this.otherAppointmentCareerDivision = otherAppointmentCareerDivision;
	}

	public String getOtherAppointmentContractStartTerm() {
		return otherAppointmentContractStartTerm;
	}

	public void setOtherAppointmentContractStartTerm(String otherAppointmentContractStartTerm) {
		this.otherAppointmentContractStartTerm = otherAppointmentContractStartTerm;
	}

	public String getOtherAppointmentContractEndTerm() {
		return otherAppointmentContractEndTerm;
	}

	public void setOtherAppointmentContractEndTerm(String otherAppointmentContractEndTerm) {
		this.otherAppointmentContractEndTerm = otherAppointmentContractEndTerm;
	}

	public String getOtherAppointmentPositionTeam() {
		return otherAppointmentPositionTeam;
	}

	public void setOtherAppointmentPositionTeam(String otherAppointmentPositionTeam) {
		this.otherAppointmentPositionTeam = otherAppointmentPositionTeam;
	}

	public int getOtherAppointmentSalaryclass() {
		return otherAppointmentSalaryclass;
	}

	public void setOtherAppointmentSalaryclass(int otherAppointmentSalaryclass) {
		this.otherAppointmentSalaryclass = otherAppointmentSalaryclass;
	}

	public String getOtherAppointmentSalaryclassPromotion() {
		return otherAppointmentSalaryclassPromotion;
	}

	public void setOtherAppointmentSalaryclassPromotion(String otherAppointmentSalaryclassPromotion) {
		this.otherAppointmentSalaryclassPromotion = otherAppointmentSalaryclassPromotion;
	}

	public String getOtherAppointmentRegistrationDate() {
		return otherAppointmentRegistrationDate;
	}

	public void setOtherAppointmentRegistrationDate(String otherAppointmentRegistrationDate) {
		this.otherAppointmentRegistrationDate = otherAppointmentRegistrationDate;
	}

	public String getOtherAppointmentModificationDate() {
		return otherAppointmentModificationDate;
	}

	public void setOtherAppointmentModificationDate(String otherAppointmentModificationDate) {
		this.otherAppointmentModificationDate = otherAppointmentModificationDate;
	}

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
}
