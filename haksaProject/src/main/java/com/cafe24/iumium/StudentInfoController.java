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
import com.cafe24.iumium.schoolregister.studentinfo.dto.Family;
import com.cafe24.iumium.schoolregister.studentinfo.dto.HighSchool;
import com.cafe24.iumium.schoolregister.studentinfo.dto.MyProfile;
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
	@RequestMapping(value = "/addStudentInfo", method = RequestMethod.GET)
	public String insertStudentInfo() {
		System.out.println("/addStudentInfo GET");
		return "schoolRegister/studentInfo/addStudentInfo";
	}
	
	// 상담 입력 화면
	@RequestMapping(value = "/addAdvice", method = RequestMethod.GET)
	public String insertAdvice() {
		System.out.println("/addAdvice GET");
		return "schoolRegister/studentInfo/addAdvice";
	}
	
	// 반 변경 입력 화면
	@RequestMapping(value = "/addClassChange", method = RequestMethod.GET)
	public String insertClassChange() {
		System.out.println("/addClassChange GET");
		return "schoolRegister/studentInfo/addClassChange";
	}
	
	// 장학금 수혜 입력 화면
	@RequestMapping(value = "/addScholarshipBenefit", method = RequestMethod.GET)
	public String insertScholarshipBenefit() {
		System.out.println("/insertScholarshipBenefit GET");
		return "schoolRegister/studentInfo/addScholarshipBenefit";
	}
	
	// 가족사항 입력 화면
	@RequestMapping(value = "/addFamily", method = RequestMethod.GET)
	public String insertFamily(Model model, HttpServletRequest request) {
		System.out.println("/addFamily GET");
		String studentNumber = request.getParameter("studentNumber");
		Family familyStudentNumber = new Family();
		familyStudentNumber.setStudentNumber(studentNumber);
		model.addAttribute("familyStudentNumber", familyStudentNumber);
		return "schoolRegister/studentInfo/addFamily";
	}
	
	// 신상명세정보 입력 화면
	@RequestMapping(value = "/addMyProfile", method = RequestMethod.GET)
	public String insertMyProfile(Model model, HttpServletRequest request) {
		System.out.println("/addMyProfile GET");
		String studentNumber = request.getParameter("studentNumber");
		MyProfile myProfileNumber = new MyProfile();
		myProfileNumber.setStudentNumber(studentNumber);
		model.addAttribute("myProfileNumber", myProfileNumber);
		return "schoolRegister/studentInfo/addMyProfile";
	}
	
	// 고등학력사항 입력 화면
	@RequestMapping(value = "/addHighSchool", method = RequestMethod.GET)
	public String insertHighSchool(Model model, HttpServletRequest request) {
		System.out.println("/addHighSchool GET");
		String studentNumber = request.getParameter("studentNumber");
		HighSchool highSchoolNumber = new HighSchool();
		highSchoolNumber.setStudentNumber(studentNumber);
		model.addAttribute("highSchoolNumber", highSchoolNumber);
		return "schoolRegister/studentInfo/addHighSchool";
	}
}