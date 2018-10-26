package com.cafe24.iumium.lesson.attendance.dto;

public class Attendance {
	private String studentNumber;
	private String professorName;
	private String attendState;
	private String attendanceNo;
	private String absentReason;
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getAttendState() {
		return attendState;
	}
	public void setAttendState(String attendState) {
		this.attendState = attendState;
	}
	public String getAttendanceNo() {
		return attendanceNo;
	}
	public void setAttendanceNo(String attendanceNo) {
		this.attendanceNo = attendanceNo;
	}
	public String getAbsentReason() {
		return absentReason;
	}
	public void setAbsentReason(String absentReason) {
		this.absentReason = absentReason;
	}
}
