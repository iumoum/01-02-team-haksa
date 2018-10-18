// 이응빈
// 보직사항
package com.cafe24.iumium.personnel.appoint.dto;

public class Position {
	private String positionNumber;	// 보직사항 번호
	private String recordId;	// 등록자 아이디
	private String teamCode;	// 보직팀코드
	private String studentTeacherNo;	// 학번교직원번호
	private String jobPositionCode;	// 직위
	private String positionStartOfWork;	// 보직임명일
	private String positionEndOfWork;	// 보직만료일
	private String humanRegistrationDay;	// 시스템등록일자
	private String humanModificationDate;	// 최종수정일자
	
	// join 하기 위한 변수
	private String teamNameKorean;
	
	public String getTeamNameKorean() {
		return teamNameKorean;
	}
	public void setTeamNameKorean(String teamNameKorean) {
		this.teamNameKorean = teamNameKorean;
	}
	public String getPositionNumber() {
		return positionNumber;
	}
	public void setPositionNumber(String positionNumber) {
		this.positionNumber = positionNumber;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public String getStudentTeacherNo() {
		return studentTeacherNo;
	}
	public void setStudentTeacherNo(String studentTeacherNo) {
		this.studentTeacherNo = studentTeacherNo;
	}
	public String getJobPositionCode() {
		return jobPositionCode;
	}
	public void setJobPositionCode(String jobPositionCode) {
		this.jobPositionCode = jobPositionCode;
	}
	public String getPositionStartOfWork() {
		return positionStartOfWork;
	}
	public void setPositionStartOfWork(String positionStartOfWork) {
		this.positionStartOfWork = positionStartOfWork;
	}
	public String getPositionEndOfWork() {
		return positionEndOfWork;
	}
	public void setPositionEndOfWork(String positionEndOfWork) {
		this.positionEndOfWork = positionEndOfWork;
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
