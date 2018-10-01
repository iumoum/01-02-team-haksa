package com.cafe24.iumium.courseandscore;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.iumium.courseandscore.dto.EnrolCourse;
import com.cafe24.iumium.courseandscore.service.CourseAndScoreService;

@Controller
public class CourseAndScoreController {
	
	@Autowired
	private CourseAndScoreService courseAndScoreService;
	
	/*1. 세션 아이디 받아서 학과별반번호 조회
	  2. 학과별반번호 일치하는 강의상황서 조회 
	  3. 조회된 과목 정보 출력
	*/
	@RequestMapping(value="/courseAndScore/enrolCourse")
	public String enrolCourse(Model model, HttpSession session) {
		System.out.println("CourseAndScoreController - enrolCourse() 호출");
		
		String id = session.getId();
		
		List<EnrolCourse> enrolCourse = courseAndScoreService.selectEnrolCourse(id);
		
		// 직군 코드 model 객체 내부에 저장
		model.addAttribute("enrolCourse", enrolCourse);
		
		return "/courseAndScore/enrolCourse";
	}
	
	
	
	
}
