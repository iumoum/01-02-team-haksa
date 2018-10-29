package com.cafe24.iumium.lesson.attendance.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iumium.courseandscore.dto.EnrolCourse;
import com.cafe24.iumium.lesson.attendance.dao.AttendanceDao;
import com.cafe24.iumium.lesson.attendance.dto.Attendance;
import com.cafe24.iumium.lesson.schedule.dto.Schedule;
import com.cafe24.iumium.lesson.schedule.dto.Search;
import com.cafe24.iumium.manage.lecture.dto.SubjectCode;

@Service
@Transactional
public class AttendanceService {
	@Autowired AttendanceDao attendanceDao;
	
	// 교수명 조회
	public List<SubjectCode> subjectSearch(Search search) {
		return attendanceDao.subjectSearchList(search);
	}
	
	// 강의일자 조회
	public List<Schedule> lectureDateSearch(String subjectCode) {
		return attendanceDao.lectureDateList(subjectCode);
	}
	
	// 수강신청한 학생 조회
	public Map<String, Object> courseSearch(Search search) {
		List<String> courseName = new ArrayList<String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<EnrolCourse> courseList = attendanceDao.courseSearchList(search);
		resultMap.put("courseList", courseList);
		
		for(EnrolCourse course : courseList) {
			String studentName = attendanceDao.courseNameSearchList(course.getEnrolCourseStudentNumber());
			courseName.add(studentName);
		}
		resultMap.put("courseName", courseName);
		return resultMap;
	}
	
	// 출석부 출결 조회
	public Map<String, Object> attendanceSearch(Search search) {
		List<String> attendName = new ArrayList<String>();
		Map<String, Object> attendancce = new HashMap<String, Object>();
		
		// 출석부 조회
		List<Attendance> attendList = attendanceDao.attendanceSearchList(search);
		attendancce.put("attendList", attendList);
		
		// 이름 조회
		for(Attendance name : attendList) {
			String studentName = attendanceDao.courseNameSearchList(name.getStudentNumber());
			attendName.add(studentName);
			
			//결석이유 조회
			if("결석".equals(name.getAttendState())) {
				String absentReason = attendanceDao.absentReasonSearch(name.getAttendanceNo());
				name.setAbsentReason(absentReason);
			}
		}
		attendancce.put("attendName", attendName);
		
		return attendancce;
	}
}
