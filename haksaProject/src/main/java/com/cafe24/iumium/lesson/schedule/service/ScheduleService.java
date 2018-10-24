package com.cafe24.iumium.lesson.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iumium.common.dto.RoomCode;
import com.cafe24.iumium.lesson.lecture.dto.ClassByDepartment;
import com.cafe24.iumium.lesson.lecture.dto.LectureStatus;
import com.cafe24.iumium.lesson.schedule.dao.ScheduleDao;
import com.cafe24.iumium.lesson.schedule.dto.Schedule;
import com.cafe24.iumium.lesson.schedule.dto.Search;

@Service
@Transactional
public class ScheduleService {
	@Autowired private ScheduleDao scheduleDao;
	
	// 교수명 조회
	public String professorSearch(String professorNumber) {
		return scheduleDao.professorSearchOne(professorNumber);
	}
	
	// 학과 조회
	public List<ClassByDepartment> departmentSearch(String semesterCode) {
		return scheduleDao.departmentSearchList(semesterCode);
	}
	
	// 학년 조회
	public List<ClassByDepartment> gradeSearch(String departmentCode) {
		return scheduleDao.gradeSearchList(departmentCode);
	}
	
	// 반 조회
	public List<ClassByDepartment> classSearch(int gradeCode) {
		return scheduleDao.classSearchList(gradeCode);
	}
	
	// 강의실 조회
	public List<RoomCode> roomSearch(String buildingCode) {
		return scheduleDao.roomSearchList(buildingCode);
	}
	
	// 과목, 강의실, 교수님이름 조회
	public List<LectureStatus> scheduleSearch(Search search) {
		return scheduleDao.lectureStatusSearchList(search);
	}
	
	// 시간표 조회
	public List<Schedule> scheduleSearchList(Search search) {
		return scheduleDao.scheduleList(search);
	}
	
	// 교수 시간표 조회
	public List<Schedule> professorScheduleSearch(ClassByDepartment classByDepartment) {
		return scheduleDao.professorScheduleList(classByDepartment);
	}
	
	// 강의실 시간표 조회
	public List<Schedule> roomScheduleSearch(Search search) {
		return scheduleDao.roomScheduleList(search);
	}
	
	// 교수강의과목조회
	public List<LectureStatus> professorSubjectSearch(Search search) {
		return scheduleDao.professorSubjectList(search);
	}
}
