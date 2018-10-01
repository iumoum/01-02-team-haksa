package com.cafe24.iumium.lesson.lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iumium.lesson.lecture.dao.LessonLectureDao;
import com.cafe24.iumium.lesson.lecture.dto.ClassByDepartment;

@Service
@Transactional
public class LessonLectureService {
	@Autowired
	private LessonLectureDao lessonLectureDao;
	
	// 학과별 반 리스트 조회
	public List<ClassByDepartment> selectAllClassesByDepartment(){
		return lessonLectureDao.selectAllClassesByDepartment();
	}
}
