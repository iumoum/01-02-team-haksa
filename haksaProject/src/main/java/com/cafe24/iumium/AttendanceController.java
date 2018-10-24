package com.cafe24.iumium;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.iumium.lesson.attendance.service.AttendanceService;
import com.cafe24.iumium.lesson.schedule.dto.Schedule;
import com.cafe24.iumium.lesson.schedule.dto.Search;
import com.cafe24.iumium.manage.lecture.dto.SubjectCode;

@CrossOrigin
@Controller
public class AttendanceController {
	@Autowired private AttendanceService attendanceService;
	
	// 출석부 입력 페이지
	@RequestMapping(value="/lesson/attendance/addAttendance", method=RequestMethod.GET)
	public String addAttendance() {
		System.out.println("출석부 입력 폼");
		return "attendance/addAttendance";
	}
	
	// 강의 출결조회 리스트
	@RequestMapping(value="/lesson/attendance/listAttendance", method=RequestMethod.GET)
	public String listAttendance() {
		System.out.println("강의 출결조회 리스트");
		return "attendance/listAttendance";
	}
	
	// 과목 조회
	@RequestMapping(value="/rest/attendance/subject", method=RequestMethod.POST)
	public @ResponseBody List<SubjectCode> subjectList(Search search) {
		System.out.println("과목 조회");
		return attendanceService.subjectSearch(search);
	}
	
	// 강의일자 조회
	@RequestMapping(value="/rest/attendance/lectureDate", method=RequestMethod.GET)
	public @ResponseBody List<Schedule> lectureDateList(@RequestParam(value="subjectCode", required=true) String subjectCode) {
		System.out.println("강의일자 조회");
		return attendanceService.lectureDateSearch(subjectCode);
	}
	
	// 수강신청한 학생 조회
	@RequestMapping(value="/rest/attendance/course", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> courseStudentList(Search search) {
		
		Map<String, Object> courseMap = attendanceService.courseSearch(search);
		System.out.println("출석부 폼 생성");
		return courseMap;
	}
	
	// 출석부 출결 조회
	@RequestMapping(value="/rest/attendance/attendanceList", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> attendanceList(Search search) {
		System.out.println("출석부 출결 조회");
		return attendanceService.attendanceSearch(search);
	}
}
