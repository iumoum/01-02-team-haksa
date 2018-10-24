package com.cafe24.iumium.lesson.attendance.dto;

public class Attendance {
	private String studentNumber;
	private String professorName;
	private String attendState;
	
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
}
