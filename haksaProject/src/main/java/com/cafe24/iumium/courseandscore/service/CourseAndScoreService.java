package com.cafe24.iumium.courseandscore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iumium.courseandscore.dao.CourseAndScoreDao;
import com.cafe24.iumium.courseandscore.dto.EnrolCourse;

@Service
@Transactional
public class CourseAndScoreService {
	
	@Autowired
	private CourseAndScoreDao courseAndScoreDao;
	
	/*1. 세션 아이디 받아서 학과별반번호 조회
	  2. 학과별반번호 일치하는 강의상황서 조회 
	  3. 조회된 과목 정보 출력
	*/
	
	public List<EnrolCourse> selectEnrolCourse(String id){ 
		System.out.println("CourseAndScoreService - selectEnrolCourse() 호출");
		List<EnrolCourse> list = new ArrayList<EnrolCourse>();
		
		int deptCode = courseAndScoreDao.inquireStudentDept(id);
		System.out.println("세션 학번으로 학과별반번호 조회 : " + deptCode);
		
		//list = courseAndScoreDao.inquireDeptCourse(deptCode);
		
		return list;
	}
	
	
}
