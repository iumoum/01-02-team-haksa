// 이응빈
// 정규직
package com.cafe24.iumium.personnel.appoint.dto;

public class PersonnelPermanentAppointment {
	private String appointmentSchoolPersonnelNumber;
	private int appointmentPermanentAnnualIncome;
	private String appointmentPermanentCareerDivision;
	private String appointmentPermanentContractStartTerm;
	private String appointmentPermanentContractEndTerm;
	private String appointmentPermanentAppointmentStartTerm;
	private String appointmentPermanentAppointmentEndTerm;
	private int appointmentPermanentSalaryclass;
	private String appointmentPermanentSalaryclassPromotion;
	private String appointmentPermanentAppointReason;
	private String appointmentPermanentRegistrationDate;
	private String appointmentPermanentModificationDate;
	
	// 이 밑으로 이응빈 작업
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
	public String getAppointmentSchoolPersonnelNumber() {
		return appointmentSchoolPersonnelNumber;
	}
	public void setAppointmentSchoolPersonnelNumber(String appointmentSchoolPersonnelNumber) {
		this.appointmentSchoolPersonnelNumber = appointmentSchoolPersonnelNumber;
	}
	public int getAppointmentPermanentAnnualIncome() {
		return appointmentPermanentAnnualIncome;
	}
	public void setAppointmentPermanentAnnualIncome(int appointmentPermanentAnnualIncome) {
		this.appointmentPermanentAnnualIncome = appointmentPermanentAnnualIncome;
	}
	public String getAppointmentPermanentCareerDivision() {
		return appointmentPermanentCareerDivision;
	}
	public void setAppointmentPermanentCareerDivision(String appointmentPermanentCareerDivision) {
		this.appointmentPermanentCareerDivision = appointmentPermanentCareerDivision;
	}
	public String getAppointmentPermanentContractStartTerm() {
		return appointmentPermanentContractStartTerm;
	}
	public void setAppointmentPermanentContractStartTerm(String appointmentPermanentContractStartTerm) {
		this.appointmentPermanentContractStartTerm = appointmentPermanentContractStartTerm;
	}
	public String getAppointmentPermanentContractEndTerm() {
		return appointmentPermanentContractEndTerm;
	}
	public void setAppointmentPermanentContractEndTerm(String appointmentPermanentContractEndTerm) {
		this.appointmentPermanentContractEndTerm = appointmentPermanentContractEndTerm;
	}
	public String getAppointmentPermanentAppointmentStartTerm() {
		return appointmentPermanentAppointmentStartTerm;
	}
	public void setAppointmentPermanentAppointmentStartTerm(String appointmentPermanentAppointmentStartTerm) {
		this.appointmentPermanentAppointmentStartTerm = appointmentPermanentAppointmentStartTerm;
	}
	public String getAppointmentPermanentAppointmentEndTerm() {
		return appointmentPermanentAppointmentEndTerm;
	}
	public void setAppointmentPermanentAppointmentEndTerm(String appointmentPermanentAppointmentEndTerm) {
		this.appointmentPermanentAppointmentEndTerm = appointmentPermanentAppointmentEndTerm;
	}
	public int getAppointmentPermanentSalaryclass() {
		return appointmentPermanentSalaryclass;
	}
	public void setAppointmentPermanentSalaryclass(int appointmentPermanentSalaryclass) {
		this.appointmentPermanentSalaryclass = appointmentPermanentSalaryclass;
	}
	public String getAppointmentPermanentSalaryclassPromotion() {
		return appointmentPermanentSalaryclassPromotion;
	}
	public void setAppointmentPermanentSalaryclassPromotion(String appointmentPermanentSalaryclassPromotion) {
		this.appointmentPermanentSalaryclassPromotion = appointmentPermanentSalaryclassPromotion;
	}
	public String getAppointmentPermanentAppointReason() {
		return appointmentPermanentAppointReason;
	}
	public void setAppointmentPermanentAppointReason(String appointmentPermanentAppointReason) {
		this.appointmentPermanentAppointReason = appointmentPermanentAppointReason;
	}
	public String getAppointmentPermanentRegistrationDate() {
		return appointmentPermanentRegistrationDate;
	}
	public void setAppointmentPermanentRegistrationDate(String appointmentPermanentRegistrationDate) {
		this.appointmentPermanentRegistrationDate = appointmentPermanentRegistrationDate;
	}
	public String getAppointmentPermanentModificationDate() {
		return appointmentPermanentModificationDate;
	}
	public void setAppointmentPermanentModificationDate(String appointmentPermanentModificationDate) {
		this.appointmentPermanentModificationDate = appointmentPermanentModificationDate;
	}
	
	// 값이 잘 담겼는지에 대한 to String() 메소드 선언
	@Override
	public String toString() {
		return "PersonnelPermanentAppointment [appointmentSchoolPersonnelNumber=" + appointmentSchoolPersonnelNumber
				+ ", appointmentPermanentAnnualIncome=" + appointmentPermanentAnnualIncome
				+ ", appointmentPermanentCareerDivision=" + appointmentPermanentCareerDivision
				+ ", appointmentPermanentContractStartTerm=" + appointmentPermanentContractStartTerm
				+ ", appointmentPermanentContractEndTerm=" + appointmentPermanentContractEndTerm
				+ ", appointmentPermanentAppointmentStartTerm=" + appointmentPermanentAppointmentStartTerm
				+ ", appointmentPermanentAppointmentEndTerm=" + appointmentPermanentAppointmentEndTerm
				+ ", appointmentPermanentSalaryclass=" + appointmentPermanentSalaryclass
				+ ", appointmentPermanentSalaryclassPromotion=" + appointmentPermanentSalaryclassPromotion
				+ ", appointmentPermanentAppointReason=" + appointmentPermanentAppointReason
				+ ", appointmentPermanentRegistrationDate=" + appointmentPermanentRegistrationDate
				+ ", appointmentPermanentModificationDate=" + appointmentPermanentModificationDate + "]";
	}
}
