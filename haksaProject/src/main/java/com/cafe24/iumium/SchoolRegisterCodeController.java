package com.cafe24.iumium;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.iumium.schoolregister.code.dto.Calander;
import com.cafe24.iumium.schoolregister.code.dto.ReasonForCantGraduate;
import com.cafe24.iumium.schoolregister.code.dto.ReasonForChangeSchoolRegister;
import com.cafe24.iumium.schoolregister.code.dto.ResultOfCounselCode;
import com.cafe24.iumium.schoolregister.code.dto.SemesterCode;
import com.cafe24.iumium.schoolregister.code.service.SchoolRegisterCodeService;

@Controller
public class SchoolRegisterCodeController {
	@Autowired
	private SchoolRegisterCodeService schoolRegisterCodeService;
	
	// 학기코드 리스트 조회
	@RequestMapping(value="/schoolRegister/codes/semester")
	public String getAllSemesterCodes(Model model) {
		List<SemesterCode> semesterCodes = schoolRegisterCodeService.selectAllSemesterCodes();
		model.addAttribute("semesterCodes", semesterCodes);
		return "schoolRegister/schoolRegisterCode/listSemesterCode";
	}
	
	// 학기코드 입력 화면
	@RequestMapping(value="/schoolRegister/codes/addSemesterCode")
	public String semesterCode() {
		return "schoolRegister/schoolRegisterCode/addSemesterCode";
	}
	
	// 학기별 상세일정 리스트 조회
	@RequestMapping(value="/schoolRegister/codes/calander", method = RequestMethod.GET)
	public String getAllCalanders(Model model) {
		List<Calander> calanders = schoolRegisterCodeService.selectAllCalanders();
		model.addAttribute("calanders", calanders);
		return "schoolRegister/schoolRegisterCode/listCalander";
	}
	
	// 학기별 상세일정 입력 화면
	@RequestMapping(value="/schoolRegister/codes/addCalander", method = RequestMethod.GET)
	public String calander() {
		return "schoolRegister/schoolRegisterCode/addCalander";
	}
	
	// 학적변동사유코드 리스트 조회
	@RequestMapping(value="/schoolRegister/codes/reasonForChangeSchoolRegister", method = RequestMethod.GET)
	public String getAllReasonsForChangeSchoolRegister(Model model) {
		List<ReasonForChangeSchoolRegister> reasonsForChangeSchoolRegister = schoolRegisterCodeService.selectAllReasonsForChangeSchoolRegister();
		model.addAttribute("reasonsForChangeSchoolRegister", reasonsForChangeSchoolRegister);
		return "schoolRegister/schoolRegisterCode/listReasonForChangeSchoolRegister";
	}
	
	// 학적변동사유코드 입력 화면
	@RequestMapping(value="/schoolRegister/codes/addReasonForChangeSchoolRegister", method = RequestMethod.GET)
	public String reasonsForChangeSchoolRegister() {
		return "schoolRegister/schoolRegisterCode/addReasonForChangeSchoolRegister";
	}
	
	// 상담구분코드 입력 화면
	@RequestMapping(value="/schoolRegister/codes/addTypeOfCounsel", method = RequestMethod.GET)
	public String typeOfCounselCode() {
		return "schoolRegister/schoolRegisterCode/addTypeOfCounselCode";
	}
	
	// 상담구분코드 리스트 조회
	@RequestMapping(value="/schoolRegister/codes/typeOfCounsel", method = RequestMethod.GET)
	public String getAllResultOfCounselCodes(Model model) {
		List<ResultOfCounselCode> resultOfCounselCodes = schoolRegisterCodeService.selectAllResultOfCounselCodes();
		model.addAttribute("resultOfCounselCodes", resultOfCounselCodes);
		return "schoolRegister/schoolRegisterCode/listTypeOfCounselCode";
	}
	
	// 학기별 상세일정 리스트 조회
	@RequestMapping(value = "/rest/calander", method = RequestMethod.GET)
	public @ResponseBody List<Calander> getCalander() {
		return schoolRegisterCodeService.selectAllCalander();
	}
	// 졸업불가사유코드 입력 화면
	@RequestMapping(value="/schoolRegister/codes/addReasonForCantGraduate", method = RequestMethod.GET)
	public String reasonForCantGraduateCode() {
		return "schoolRegister/schoolRegisterCode/addReasonForCantGraduate";
	}	
			
	// 졸업불가사유코드 리스트 조회	
	@RequestMapping(value="/schoolRegister/codes/reasonForCantGraduate", method = RequestMethod.GET)	
	public String getAllReasonForCantGraduateCodes(Model model) {	
		List<ReasonForCantGraduate> reasonForCantGraduateCodes = schoolRegisterCodeService.selectAllReasonForCantGraduateCodes();	
		model.addAttribute("reasonForCantGraduateCodes", reasonForCantGraduateCodes);	
		return "schoolRegister/schoolRegisterCode/listReasonForCantGraduate";
	}
}
