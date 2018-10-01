package com.cafe24.iumium;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.iumium.lesson.lecture.dto.ClassByDepartment;
import com.cafe24.iumium.lesson.lecture.service.LessonLectureService;

@Controller
public class LessonLectureController {
	@Autowired
	private LessonLectureService lessonLectureService;
	
	// 학과별 반 리스트 조회
	@RequestMapping(value="/lesson/lecture/classByDepartment", method = RequestMethod.GET)
	public String getAllClassByDepartment(Model model) {
		
		List<ClassByDepartment> classesByDepartment = lessonLectureService.selectAllClassesByDepartment();
		model.addAttribute("classesByDepartment", classesByDepartment);
		
		return "lesson/lecture/classByDepartment";
	}
}
