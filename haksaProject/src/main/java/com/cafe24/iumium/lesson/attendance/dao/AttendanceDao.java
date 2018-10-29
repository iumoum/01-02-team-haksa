package com.cafe24.iumium.lesson.attendance.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.courseandscore.dto.EnrolCourse;
import com.cafe24.iumium.lesson.attendance.dto.Attendance;
import com.cafe24.iumium.lesson.schedule.dto.Schedule;
import com.cafe24.iumium.lesson.schedule.dto.Search;
import com.cafe24.iumium.manage.lecture.dto.SubjectCode;

@Repository
public class AttendanceDao {
	private final String NS = "com.cafe24.iumium.lesson.attendance.dao.AttendanceMapper.";
	@Autowired private SqlSessionTemplate sqlSessionTemplate;
	
	// 과목 조회 쿼리문 실행
	public List<SubjectCode> subjectSearchList(Search search){
		return sqlSessionTemplate.selectList(NS+"getSubjectList", search);
	}
	
	// 강의일자 조회 쿼리문 실행
	public List<Schedule> lectureDateList(String subjectCode){
		return sqlSessionTemplate.selectList(NS+"getLectureDateList", subjectCode);
	}
	
	// 수강신청한 학생 조회 쿼리문 실행
	public List<EnrolCourse> courseSearchList(Search search){
		return sqlSessionTemplate.selectList(NS+"getCourseList", search);
	}
	
	// 수강신청한 학생이름 조회 쿼리문 실행
	public String courseNameSearchList(String course){
		return sqlSessionTemplate.selectOne(NS+"getStudentName", course);
	}
	
	// 출석부 출결 조회  쿼리문 실행
	public List<Attendance> attendanceSearchList(Search search){
		return sqlSessionTemplate.selectList(NS+"getAttendanceList", search);
	}
	
	// 결석이유 조회 쿼리문 실행
	public String absentReasonSearch(String attendanceNo){
		return sqlSessionTemplate.selectOne(NS+"getAbsentReason", attendanceNo);
	}
	
}
