package com.cafe24.iumium;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.iumium.schoolregister.studentinfo.dto.Advice;
import com.cafe24.iumium.schoolregister.studentinfo.dto.ClassChange;
import com.cafe24.iumium.schoolregister.studentinfo.dto.ScholarshipBenefit;
import com.cafe24.iumium.schoolregister.studentinfo.dto.StudentInfo;
import com.cafe24.iumium.schoolregister.studentinfo.service.StudentInfoService;

@Controller
public class StudentInfoController {

	@Autowired	private StudentInfoService studentInfoService;
	
	// 학생정보 조회 페이지
	@RequestMapping(value = "/listStudentInfo", method = RequestMethod.GET)
	public String listStudentInfo() {
		System.out.println("/listStudentInfo GET");
		return "schoolRegister/studentInfo/listStudentInfo";
	}
	
	// 1명의 학생정보 페이지
	@RequestMapping(value = "/detailStudentInfo", method = RequestMethod.GET)
	public String detailStudentInfo(Model model, HttpServletRequest request) {
		System.out.println("/detailStudentInfo GET");
		String studentNumber = request.getParameter("studentNumber");
		StudentInfo studentInfo = studentInfoService.getStudentInfo(studentNumber);
		model.addAttribute("studentInfo", studentInfo);
		
		return "schoolRegister/studentInfo/detailStudentInfo";
	}
	
	// 장학금 수혜내역 리스트
	@RequestMapping(value = "/listScholarshipBenefit", method = RequestMethod.GET)
	public String scholarshipBenefitList(Model model) {
		System.out.println("/listScholarshipBenefit GET");
		List<ScholarshipBenefit> scholarshipBenefit = studentInfoService.getScholarshipBenefitList();
		model.addAttribute("scholarshipBenefit", scholarshipBenefit);
		
		return "schoolRegister/studentInfo/listScholarshipBenefit";
	}
	
	// 상담 리스트
	@RequestMapping(value = "/listAdvice", method = RequestMethod.GET)
	public String adviceList(Model model) {
		System.out.println("/listAdvice GET");
		List<Advice> advice = studentInfoService.getAdviceList();
		model.addAttribute("advice", advice);
		
		return "schoolRegister/studentInfo/listAdvice";
	}
	
	// 반 변경 리스트
	@RequestMapping(value = "/listClassChange", method = RequestMethod.GET)
	public String classChangeList(Model model) {
		System.out.println("/listClassChange GET");
		List<ClassChange> classChange = studentInfoService.getClassChangeList();
		model.addAttribute("classChange", classChange);
		
		return "schoolRegister/studentInfo/listClassChange";
	}
	
	// 학생정보 입력 화면
	@RequestMapping(value = "/insertStudentInfo", method = RequestMethod.GET)
	public String insertStudentInfo() {
		System.out.println("/insertStudentInfo GET");
		return "schoolRegister/studentInfo/insertStudentInfo";
	}
	
	// 상담 입력 화면
	@RequestMapping(value = "/insertAdvice", method = RequestMethod.GET)
	public String insertAdvice() {
		System.out.println("/insertAdvice GET");
		return "schoolRegister/studentInfo/insertAdvice";
	}
	
	// 반 변경 입력 화면
	@RequestMapping(value = "/insertClassChange", method = RequestMethod.GET)
	public String insertClassChange() {
		System.out.println("/insertClassChange GET");
		return "schoolRegister/studentInfo/insertClassChange";
	}
	
	// 장학금 수혜 입력 화면
	@RequestMapping(value = "/insertScholarshipBenefit", method = RequestMethod.GET)
	public String insertScholarshipBenefit() {
		System.out.println("/insertScholarshipBenefit GET");
		return "schoolRegister/studentInfo/insertScholarshipBenefit";
	}
	
	// 가족사항 입력 화면
	@RequestMapping(value = "/insertFamily", method = RequestMethod.GET)
	public String insertFamily() {
		System.out.println("/insertFamily GET");
		return "schoolRegister/studentInfo/insertFamily";
	}
	
	// 신상명세정보 입력 화면
	@RequestMapping(value = "/insertMyProfile", method = RequestMethod.GET)
	public String insertMyProfile() {
		System.out.println("/insertMyProfile GET");
		return "schoolRegister/studentInfo/insertMyProfile";
	}
	
	// 고등학력사항 입력 화면
	@RequestMapping(value = "/insertHighSchool", method = RequestMethod.GET)
	public String insertHighSchool() {
		System.out.println("/insertHighSchool GET");
		return "schoolRegister/studentInfo/insertHighSchool";
	}
}