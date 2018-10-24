package com.cafe24.iumium;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.iumium.personnel.code.dto.CertificateCode;
import com.cafe24.iumium.personnel.code.dto.CertificatePurposeCode;
import com.cafe24.iumium.personnel.code.dto.PersonnelCommonCode;
import com.cafe24.iumium.personnel.code.dto.RewardPunishmentCode;
import com.cafe24.iumium.personnel.code.dto.TrainingCode;
import com.cafe24.iumium.personnel.code.service.PersonnelCodeService;


@Controller
public class PersonnelCodeController {
	@Autowired
	private PersonnelCodeService PersonnelCodeService;
	
	// 인사입력 페이지 호출
	@RequestMapping(value="/personnelCode/addPersonnelCommonCode", method = RequestMethod.GET)
	public String insertPersonnelCommonCode() {
		System.out.println("인사입력페이지 호출");
		return "personnel/personnelCode/addPersonnelCommonCode";	
	}
	
	// 인사공통코드 리스트 페이지 데이터 호출
	@RequestMapping(value="/personnelCode/listPersonnelCommonCode", method = RequestMethod.GET)
	public String personnelCommonCodeList(Model model) {
		System.out.println("인사공통코드 리스트 service");
		List<PersonnelCommonCode> personnelCommonCodeList = PersonnelCodeService.selectPersonnelCommonCodeList();
		model.addAttribute("PersonnelCommonCode", personnelCommonCodeList);
		return "personnel/personnelCode/listPersonnelCommonCode";
	}
	
	// 상벌코드 입력 페이지 호출
	@RequestMapping(value="/personnelCode/addRewardPunishment", method = RequestMethod.GET)
	public String addRewardPunishment() {
		System.out.println("상벌 입력 페이지 호출");
		return "personnel/personnelCode/addRewardPunishment";	
	}
	
	// 상벌코드 리스트 페이지 호출
	@RequestMapping(value="/personnelCode/listRewardPunishmentCode", method = RequestMethod.GET)
	public String rewardPunishmentList(Model model) {
		System.out.println("상벌리스트 페이지 호출");
		List<RewardPunishmentCode> rewardPunishmentList = PersonnelCodeService.getrewardPunishmentCode();
		model.addAttribute("rewardPunishmentCodeList", rewardPunishmentList);
		return "personnel/personnelCode/listRewardPunishmentCode";	
	}
	
	// 연수코드 입력 페이지 호출
	@RequestMapping(value="/personnelCode/addTraining", method = RequestMethod.GET)
	public String addTraining() {
		System.out.println("연수 입력 페이지 호출");
		return "personnel/personnelCode/addTraining";	
	}
	
	// 연수코드 리스트 페이지 호출
	@RequestMapping(value="/personnelCode/listTrainingCode", method = RequestMethod.GET)
	public String trainingList(Model model) {
		System.out.println("연수코드 리스트 페이지 호출");
		List<TrainingCode> trainingList = PersonnelCodeService.getTrainingCodeList();
		model.addAttribute("getTrainingList", trainingList);
		return "personnel/personnelCode/listTrainingCode";	
	}
	
	// 증명서코드 입력 페이지 호출
	@RequestMapping(value="/personnelCode/addCertificate", method = RequestMethod.GET)
	public String addCertificate() {
		System.out.println("증명서코드 입력 페이지 호출");
		return "personnel/personnelCode/addCertificate";	
	}
	
	// 증명서코드 리스트 페이지 호출
	@RequestMapping(value="/personnelCode/listCertificateCode", method = RequestMethod.GET)
	public String certificateList(Model model) {
		System.out.println("증명서코드 리스트 페이지 호출");
		List<CertificateCode> certificateList = PersonnelCodeService.getCertificateCodeList();
		model.addAttribute("getCertificateList", certificateList);
		return "personnel/personnelCode/listCertificateCode";	
	}
	
	// 증명서용도코드 입력 페이지 호출
	@RequestMapping(value="/personnelCode/addCertificatePurpose", method = RequestMethod.GET)
	public String addPCertificatePurpose() {
		System.out.println("증명서용도코드 입력 페이지 호출");
		return "personnel/personnelCode/addCertificatePurpose";	
	}
	
	// 증명서용도코드 리스트 페이지 호출
	@RequestMapping(value="/personnelCode/listCertificatePurposeCode", method = RequestMethod.GET)
	public String certificatePurposeList(Model model) {
		System.out.println("증명서용도코드 리스트 페이지 호출");
		List<CertificatePurposeCode> certificatePurposeList = PersonnelCodeService.getCertificatePurposeCodeList();
		model.addAttribute("getCertificatePurposeList", certificatePurposeList);
		return "personnel/personnelCode/listCertificatePurposeCode";	
	}
}