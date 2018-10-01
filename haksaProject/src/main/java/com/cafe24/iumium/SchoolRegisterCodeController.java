package com.cafe24.iumium;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.iumium.schoolregistercode.dto.SemesterCode;
import com.cafe24.iumium.schoolregistercode.service.SchoolRegisterCodeService;

@Controller
public class SchoolRegisterCodeController {
	@Autowired
	private SchoolRegisterCodeService schoolRegisterCodeService;
	
	// 학기코드 리스트 조회
	@RequestMapping(value="/schoolRegister/codes/semester")
	public String getAllSemesterCodes(Model model) {
		List<SemesterCode> semesterCodes = schoolRegisterCodeService.selectAllSemesterCodes();
		model.addAttribute("semesterCodes", semesterCodes);
		return "semesterCode";
	}
}
