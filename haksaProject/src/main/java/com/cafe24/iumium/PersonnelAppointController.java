package com.cafe24.iumium;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.iumium.personnel.appoint.dto.Career;
import com.cafe24.iumium.personnel.appoint.dto.Education;
import com.cafe24.iumium.personnel.appoint.dto.Family;
import com.cafe24.iumium.personnel.appoint.dto.HighSchool;
import com.cafe24.iumium.personnel.appoint.dto.MyProfile;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelAppointmentOther;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelBasic;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelPermanentAppointment;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelPromotion;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelTemporaryAppointment;
import com.cafe24.iumium.personnel.appoint.dto.Position;
import com.cafe24.iumium.personnel.appoint.service.PersonnelAppointmentService;
import com.cafe24.iumium.personnel.appoint.service.PersonnelPromotionService;



@Controller
public class PersonnelAppointController {
	@Autowired private PersonnelAppointmentService personnelAppointmentService;
	@Autowired private PersonnelPromotionService personnelPromotionService;
	
	// 정규직 임용 입력페이지 호출
	@RequestMapping(value="/personnelAppoint/addPermanentAppointment", method = RequestMethod.GET)
	public String addPermanentAppointment() {
		System.out.println("정규직 임용 입력 페이지 호출");
		return "personnel/personnelAppoint/addPermanentAppointment";	
	}
	
	// 승진처리 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addPromotion", method = RequestMethod.GET)
	public String addPromotion() {
		System.out.println("승진 입력 페이지 호출");
		return "personnel/personnelAppoint/addPromotion";	
	}
	
	// 승진처리 페이지에서 저장버튼 눌렀을 시 DB 입력처리 메소드
	@ResponseBody
	@RequestMapping(value="/personnelAppoint/savePromotion", method = RequestMethod.POST)
	//Json으로 보낸 파라미터값을 받기 위해 어노테이션 @RequestBody 선언
	public void savePromotion(@RequestBody PersonnelPromotion personnelPromotion) {
		personnelPromotionService.savePersonnelPromotion(personnelPromotion);
		System.out.println();
		System.out.println("호출");
	}
	
	// 이 밑으로 이응빈 작업
	
	// 승진처리 리스트 페이지 호출
	@RequestMapping(value="/personnelAppoint/listPromotionProcess", method = RequestMethod.GET)
	public String promotionProcessList(Model model) {
		System.out.println("승진 처리 리스트 페이지 호출");
		List<PersonnelPromotion> promotionList = personnelPromotionService.personnelPromotionList();
		
		model.addAttribute("promotionList", promotionList);
		
		return "personnel/personnelAppoint/listPromotionProcess";
	}
	
	// 정규직 임용 리스트 페이지 호출
	@RequestMapping(value="/personnelAppoint/listPermanentAppointment", method = RequestMethod.GET)
	public String permanentAppointmentList(Model model) {
		System.out.println("정규직 임용 리스트 페이지 호출");
		List<PersonnelPermanentAppointment> permanentAppointmentList = personnelAppointmentService.personnelPermanentAppointmentList();
		model.addAttribute("permanentAppointmentList", permanentAppointmentList);
		return "personnel/personnelAppoint/listPermanentAppointment";	
	}
	
	// 정규직 임용 상세정보 페이지 호출
	@RequestMapping(value="/personnelAppoint/detailPermanentAppointment", method = RequestMethod.GET)
	public String permanentAppointmentDetail(Model model, HttpServletRequest request) {
		System.out.println("정규직 임용 상세정보 페이지 호출");
		String appointmentSchoolPersonnelNumber = request.getParameter("appointmentSchoolPersonnelNumber");
		PersonnelPermanentAppointment detailPermanentAppointment = personnelAppointmentService.getDetailPermanentAppointment(appointmentSchoolPersonnelNumber);
		model.addAttribute("detailPermanentAppointment", detailPermanentAppointment);
		return "personnel/personnelAppoint/detailPermanentAppointment";	
	}
	
	// 인사기본사항 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addPersonnelBasic", method = RequestMethod.GET)
	public String addPersonnelBasic(Model model
			, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
			, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
			, @RequestParam(value="otherAppointmentSchoolPersonnelNumber1", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println("인사기본사항 입력 페이지 호출");
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("permanentAppointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			System.out.println("인사기본 정규직 넘버" + permanentAppointmentSchoolPersonnelNumber);
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("temporaryAppointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			System.out.println("인사기본 비정규직 넘버" + temporaryAppointmentSchoolPersonnelNumber);
		} else {
			model.addAttribute("otherAppointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			System.out.println("인사기본 무기계약 넘버" + otherAppointmentSchoolPersonnelNumber);
		}
		return "personnel/personnelAppoint/addPersonnelBasic";	
	}
	
	// 경력사항 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addCareer", method = RequestMethod.GET)
	public String addCareer(Model model 
							, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
							, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
							, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println("경력사항 입력 페이지 호출");
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("permanentAppointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			System.out.println("경력사항 정규직 넘버" + permanentAppointmentSchoolPersonnelNumber);
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("temporaryAppointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			System.out.println("경력사항 비정규직 넘버" + temporaryAppointmentSchoolPersonnelNumber);
		} else {
			model.addAttribute("otherAppointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			System.out.println("경력사항 무기계약 넘버" + otherAppointmentSchoolPersonnelNumber);
		}
		return "personnel/personnelAppoint/addCareer";	
	}
	
	// 보직사항 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addPosition", method = RequestMethod.GET)
	public String addPosition(Model model
			, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
			, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
			, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println("보직사항 입력 페이지 호출");
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("permanentAppointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			System.out.println("보직사항 정규직 넘버" + permanentAppointmentSchoolPersonnelNumber);
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("temporaryAppointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			System.out.println("보직사항 비정규직 넘버" + temporaryAppointmentSchoolPersonnelNumber);
		} else {
			model.addAttribute("otherAppointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			System.out.println("보직사항 무기계약 넘버" + otherAppointmentSchoolPersonnelNumber);
		}
		return "personnel/personnelAppoint/addPosition";	
	}
	
	// 가족사항 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addFamily", method = RequestMethod.GET)
	public String addFamily(Model model
			, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
			, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
			, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println("가족사항 입력 페이지 호출");
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("permanentAppointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			System.out.println("가족사항 정규직 넘버" + permanentAppointmentSchoolPersonnelNumber);
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("temporaryAppointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			System.out.println("가족사항 비정규직 넘버" + temporaryAppointmentSchoolPersonnelNumber);
		} else {
			model.addAttribute("otherAppointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			System.out.println("가족사항 무기계약 넘버" + otherAppointmentSchoolPersonnelNumber);
		}
		return "personnel/personnelAppoint/addFamily";	
	}
	
	// 대학교학력사항 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addEducation", method = RequestMethod.GET)
	public String addEducation(Model model
			, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
			, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
			, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println("대학교학력사항 입력 페이지 호출");
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("permanentAppointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			System.out.println("대학교학력사항 정규직 넘버" + permanentAppointmentSchoolPersonnelNumber);
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("temporaryAppointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			System.out.println("대학교학력사항 비정규직 넘버" + temporaryAppointmentSchoolPersonnelNumber);
		} else {
			model.addAttribute("otherAppointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			System.out.println("대학교학력사항 무기계약 넘버" + otherAppointmentSchoolPersonnelNumber);
		}
		return "personnel/personnelAppoint/addEducation";	
	}
	
	// 신상명세정보 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addMyProfile", method = RequestMethod.GET)
	public String addMyProfile(Model model
			, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
			, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
			, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println("신상명세정보 입력 페이지 호출");
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("permanentAppointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			System.out.println("신상명세정보 정규직 넘버" + permanentAppointmentSchoolPersonnelNumber);
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("temporaryAppointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			System.out.println("신상명세정보 비정규직 넘버" + temporaryAppointmentSchoolPersonnelNumber);
		} else {
			model.addAttribute("otherAppointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			System.out.println("신상명세정보 무기계약 넘버" + otherAppointmentSchoolPersonnelNumber);
		}
		return "personnel/personnelAppoint/addMyProfile";	
	}
	
	// 고등학력사항 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addHighSchool", method = RequestMethod.GET)
	public String addHighSchool(Model model
			, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
			, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
			, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println("고등학력사항 입력 페이지 호출");
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("permanentAppointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			System.out.println("가족사항 정규직 넘버" + permanentAppointmentSchoolPersonnelNumber);
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			model.addAttribute("temporaryAppointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			System.out.println("가족사항 비정규직 넘버" + temporaryAppointmentSchoolPersonnelNumber);
		} else {
			model.addAttribute("otherAppointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			System.out.println("가족사항 무기계약 넘버" + otherAppointmentSchoolPersonnelNumber);
		}
		return "personnel/personnelAppoint/addHighSchool";	
	}
	
	// 비정규직 임용 리스트 페이지 호출
	@RequestMapping(value="/personnelAppoint/listTemporaryAppointment", method = RequestMethod.GET)
	public String temporaryAppointmentList(Model model) {
		System.out.println("비정규직 임용 리스트 페이지 호출");
		List<PersonnelTemporaryAppointment> temporaryAppointmentList = personnelAppointmentService.temporaryAppointmentList();
		model.addAttribute("temporaryAppointmentList", temporaryAppointmentList);
		return "personnel/personnelAppoint/listTemporaryAppointment";	
	}
	
	// 비정규직 임용 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addTemporaryAppointment", method = RequestMethod.GET)
	public String addTemporaryAppointment() {
		System.out.println("비정규직 임용 입력 페이지 호출");
		return "personnel/personnelAppoint/addTemporaryAppointment";	
	}
	
	// 비정규직 임용 상세정보 페이지 호출
	@RequestMapping(value="/personnelAppoint/detailTemporaryAppointment", method = RequestMethod.GET)
	public String detailTemporaryAppointment(Model model, HttpServletRequest request) {
		System.out.println("비정규직 임용 상세정보 페이지 호출");
		String appointmentSchoolPersonnelNumber = request.getParameter("appointmentSchoolPersonnelNumber");
		PersonnelTemporaryAppointment detailTemporaryAppointment = personnelAppointmentService.detailTemporaryAppointment(appointmentSchoolPersonnelNumber);
		model.addAttribute("detailTemporaryAppointment", detailTemporaryAppointment);
		return "personnel/personnelAppoint/detailTemporaryAppointment";	
	}
	
	// 무기계약 임용 리스트 페이지 호출
	@RequestMapping(value="/personnelAppoint/listOtherAppointment", method = RequestMethod.GET)
	public String otherAppointmentList(Model model) {
		System.out.println("무기계약 임용 리스트 페이지 호출");
		List<PersonnelAppointmentOther> appointmentOtherList = personnelAppointmentService.appointmentOtherList();
		model.addAttribute("appointmentOtherList", appointmentOtherList);
		return "personnel/personnelAppoint/listOtherAppointment";	
	}
	
	// 무기계약 임용 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addOtherAppointment", method = RequestMethod.GET)
	public String addOtherAppointment(Model model) {
		System.out.println("무기계약 임용 입력 페이지 호출");
		return "personnel/personnelAppoint/addOtherAppointment";
	}
	
	// 무기계약 임용 상세정보 페이지 호출
	@RequestMapping(value="/personnelAppoint/detailOtherAppointment", method = RequestMethod.GET)
	public String detailOtherAppointment(Model model, HttpServletRequest request) {
		System.out.println("무기계약 임용 상세정보 페이지 호출");
		String appointmentSchoolPersonnelNumber = request.getParameter("appointmentSchoolPersonnelNumber");
		PersonnelAppointmentOther detailOtherAppointment = personnelAppointmentService.detailOtherAppointment(appointmentSchoolPersonnelNumber);
		model.addAttribute("detailOtherAppointment", detailOtherAppointment);
		return "personnel/personnelAppoint/detailOtherAppointment";
	}
	
	// 송원민
	// 인사기본사항 데이터 저장 기능
	@RequestMapping(value="/personnelAppoint/savePersonnelBasic", method = RequestMethod.POST)
	public String savePersonnelBasic(Model model, PersonnelBasic personnelBasic, HttpSession session
						, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
						, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
						, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {

		String id = (String) session.getAttribute("userId");
		personnelBasic.setRecordId(id);
		
		// 조건문을 걸어 경우의수 정규직, 비정규직, 무기계약 3가지를 두고 페이지이동, 뷰에 넘버값을 유지시키기 위한 model 사용
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			personnelBasic.setAppointmentSchoolPersonnelNumber(permanentAppointmentSchoolPersonnelNumber);
			System.out.println(permanentAppointmentSchoolPersonnelNumber +"인사기본사항 정규직 교직원번호");
			personnelAppointmentService.insertPersonnelBasic(personnelBasic);
			model.addAttribute("appointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailPermanentAppointment";
		
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			personnelBasic.setAppointmentSchoolPersonnelNumber(temporaryAppointmentSchoolPersonnelNumber);
			System.out.println(temporaryAppointmentSchoolPersonnelNumber +"인사기본사항 비정규직 교직원번호");
			personnelAppointmentService.insertPersonnelBasic(personnelBasic);
			model.addAttribute("appointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailTemporaryAppointment";
		
		} else {
			personnelBasic.setAppointmentSchoolPersonnelNumber(otherAppointmentSchoolPersonnelNumber);
			System.out.println(otherAppointmentSchoolPersonnelNumber +"인사기본사항 무기계약 교직원번호");
			personnelAppointmentService.insertPersonnelBasic(personnelBasic);
			model.addAttribute("appointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailOtherAppointment";
		}
	}
	
	
	// 경력사항 데이터 저장 기능
	@RequestMapping(value="/personnelAppoint/saveCareer", method = RequestMethod.POST)
	public String saveCareer(Model model, Career career, HttpSession session
						, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
						, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
						, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println(permanentAppointmentSchoolPersonnelNumber +"경력 정규직 교직원번호");
		System.out.println(temporaryAppointmentSchoolPersonnelNumber +"경력 비정규직 교직원번호");
		System.out.println(otherAppointmentSchoolPersonnelNumber +"경력 무기계약 교직원번호");
		String id = (String) session.getAttribute("userId");
		career.setRecordId(id);
		
		
		// 조건문을 걸어 경우의수  정규직, 비정규직, 무기계약  3가지를 두고 페이지이동, 뷰에 넘버값을 유지시키기 위한 model 사용
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			career.setAppointmentSchoolPersonnelNumber(permanentAppointmentSchoolPersonnelNumber);
			System.out.println(permanentAppointmentSchoolPersonnelNumber +"경력사항 정규직 교직원번호");
			personnelAppointmentService.insertCareer(career);
			model.addAttribute("appointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailPermanentAppointment";
		
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			career.setAppointmentSchoolPersonnelNumber(temporaryAppointmentSchoolPersonnelNumber);
			System.out.println(temporaryAppointmentSchoolPersonnelNumber +"경력사항 비정규직 교직원번호");
			personnelAppointmentService.insertCareer(career);
			model.addAttribute("appointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailTemporaryAppointment";
		
		} else {
			career.setAppointmentSchoolPersonnelNumber(otherAppointmentSchoolPersonnelNumber);
			System.out.println(otherAppointmentSchoolPersonnelNumber +"경력사항 무기계약 교직원번호");
			personnelAppointmentService.insertCareer(career);
			model.addAttribute("appointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailOtherAppointment";
		}
	}
	
	// 보직사항 데이터 저장 기능
	@RequestMapping(value="/personnelAppoint/savePosition", method = RequestMethod.POST)
	public String savePosition(Model model, Position position, HttpSession session
						, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
						, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
						, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println(permanentAppointmentSchoolPersonnelNumber +"보직사항 정규직 교직원번호");
		System.out.println(temporaryAppointmentSchoolPersonnelNumber +"보직사항 비정규직 교직원번호");
		System.out.println(otherAppointmentSchoolPersonnelNumber +"보직사항 무기계약 교직원번호");
		String id = (String) session.getAttribute("userId");
		position.setRecordId(id);
		
		
		// 조건문을 걸어 경우의수  정규직, 비정규직, 무기계약  3가지를 두고 페이지이동, 뷰에 넘버값을 유지시키기 위한 model 사용
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			position.setStudentTeacherNo(permanentAppointmentSchoolPersonnelNumber);
			System.out.println(permanentAppointmentSchoolPersonnelNumber +"보직사항 정규직 교직원번호(<-view)");
			personnelAppointmentService.insertPosition(position);
			model.addAttribute("appointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailPermanentAppointment";
		
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			position.setStudentTeacherNo(temporaryAppointmentSchoolPersonnelNumber);
			System.out.println(temporaryAppointmentSchoolPersonnelNumber +"보직사항 비정규직 교직원번호(<-view)");
			personnelAppointmentService.insertPosition(position);
			model.addAttribute("appointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailTemporaryAppointment";
		
		} else {
			position.setStudentTeacherNo(otherAppointmentSchoolPersonnelNumber);
			System.out.println(otherAppointmentSchoolPersonnelNumber +"보직사항 무기계약 교직원번호(<-view)");
			personnelAppointmentService.insertPosition(position);
			model.addAttribute("appointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailOtherAppointment";
		}
	}
	
	// 가족사항 데이터 저장 기능
	@RequestMapping(value="/personnelAppoint/saveFamily", method = RequestMethod.POST)
	public String saveFamily(Model model, Family family, HttpSession session
						, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
						, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
						, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println(permanentAppointmentSchoolPersonnelNumber +"가족사항 정규직 교직원번호");
		System.out.println(temporaryAppointmentSchoolPersonnelNumber +"가족사항 비정규직 교직원번호");
		System.out.println(otherAppointmentSchoolPersonnelNumber +"가족사항 무기계약 교직원번호");
		String id = (String) session.getAttribute("userId");
		family.setRecordId(id);
		
		
		// 조건문을 걸어 경우의수  정규직, 비정규직, 무기계약  3가지를 두고 페이지이동, 뷰에 넘버값을 유지시키기 위한 model 사용
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			family.setStudentTeacherNo(permanentAppointmentSchoolPersonnelNumber);
			System.out.println(permanentAppointmentSchoolPersonnelNumber +"가족사항 정규직 교직원번호(<-view)");
			personnelAppointmentService.insertFamily(family);
			model.addAttribute("appointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailPermanentAppointment";
		
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			family.setStudentTeacherNo(temporaryAppointmentSchoolPersonnelNumber);
			System.out.println(temporaryAppointmentSchoolPersonnelNumber +"가족사항 비정규직 교직원번호(<-view)");
			personnelAppointmentService.insertFamily(family);
			model.addAttribute("appointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailTemporaryAppointment";
		
		} else {
			family.setStudentTeacherNo(otherAppointmentSchoolPersonnelNumber);
			System.out.println(otherAppointmentSchoolPersonnelNumber +"가족사항 무기계약 교직원번호(<-view)");
			personnelAppointmentService.insertFamily(family);
			model.addAttribute("appointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailOtherAppointment";
		}
	}
	
	// 대학교학력사항 데이터 저장 기능
	@RequestMapping(value="/personnelAppoint/saveEducation", method = RequestMethod.POST)
	public String saveEducation(Model model, Education education, HttpSession session
						, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
						, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
						, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println(permanentAppointmentSchoolPersonnelNumber +"대학교학력사항 정규직 교직원번호");
		System.out.println(temporaryAppointmentSchoolPersonnelNumber +"대학교학력사항 비정규직 교직원번호");
		System.out.println(otherAppointmentSchoolPersonnelNumber +"대학교학력사항 무기계약 교직원번호");
		String id = (String) session.getAttribute("userId");
		education.setRecordId(id);
		
		
		// 조건문을 걸어 경우의수  정규직, 비정규직, 무기계약 3가지를 두고 페이지이동, 뷰에 넘버값을 유지시키기 위한 model 사용
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			education.setStudentTeacherNo(permanentAppointmentSchoolPersonnelNumber);
			System.out.println(permanentAppointmentSchoolPersonnelNumber +"대학교학력사항 정규직 교직원번호(<-view)");
			personnelAppointmentService.insertEducation(education);
			model.addAttribute("appointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailPermanentAppointment";
		
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			education.setStudentTeacherNo(temporaryAppointmentSchoolPersonnelNumber);
			System.out.println(temporaryAppointmentSchoolPersonnelNumber +"대학교학력사항 비정규직 교직원번호(<-view)");
			personnelAppointmentService.insertEducation(education);
			model.addAttribute("appointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailTemporaryAppointment";
		
		} else {
			education.setStudentTeacherNo(otherAppointmentSchoolPersonnelNumber);
			System.out.println(otherAppointmentSchoolPersonnelNumber +"대학교학력사항 무기계약 교직원번호(<-view)");
			personnelAppointmentService.insertEducation(education);
			model.addAttribute("appointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailOtherAppointment";
		}
	}
	
	// 신상명세정보 데이터 저장 기능
	@RequestMapping(value="/personnelAppoint/saveMyProfile", method = RequestMethod.POST)
	public String saveMyProfile(Model model, MyProfile myProfile, HttpSession session
						, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
						, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
						, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println(permanentAppointmentSchoolPersonnelNumber +"신상명세정보 정규직 교직원번호");
		System.out.println(temporaryAppointmentSchoolPersonnelNumber +"신상명세정보 비정규직 교직원번호");
		System.out.println(otherAppointmentSchoolPersonnelNumber +"신상명세정보 무기계약 교직원번호");
		String id = (String) session.getAttribute("userId");
		myProfile.setRecordId(id);
		
		
		// 조건문을 걸어 경우의수  정규직, 비정규직, 무기계약 3가지를 두고 페이지이동, 뷰에 넘버값을 유지시키기 위한 model 사용
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			myProfile.setStudentTeacherNo(permanentAppointmentSchoolPersonnelNumber);
			System.out.println(permanentAppointmentSchoolPersonnelNumber +"신상명세정보 정규직 교직원번호(<-view)");
			personnelAppointmentService.insertMyProfile(myProfile);
			model.addAttribute("appointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailPermanentAppointment";
		
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			myProfile.setStudentTeacherNo(temporaryAppointmentSchoolPersonnelNumber);
			System.out.println(temporaryAppointmentSchoolPersonnelNumber +"신상명세정보 비정규직 교직원번호(<-view)");
			personnelAppointmentService.insertMyProfile(myProfile);
			model.addAttribute("appointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailTemporaryAppointment";
		
		} else {
			myProfile.setStudentTeacherNo(otherAppointmentSchoolPersonnelNumber);
			System.out.println(otherAppointmentSchoolPersonnelNumber +"신상명세정보 무기계약 교직원번호(<-view)");
			personnelAppointmentService.insertMyProfile(myProfile);
			model.addAttribute("appointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailOtherAppointment";
		}
	}
		
	
	// 고등학력사항 데이터 저장 기능
	@RequestMapping(value="/personnelAppoint/saveHighSchool", method = RequestMethod.POST)
	public String saveHighSchool(Model model, HighSchool highSchool, HttpSession session
						, @RequestParam(value="permanentAppointmentSchoolPersonnelNumber", required=false) String permanentAppointmentSchoolPersonnelNumber
						, @RequestParam(value="temporaryAppointmentSchoolPersonnelNumber", required=false) String temporaryAppointmentSchoolPersonnelNumber
						, @RequestParam(value="otherAppointmentSchoolPersonnelNumber", required=false) String otherAppointmentSchoolPersonnelNumber) {
		System.out.println(permanentAppointmentSchoolPersonnelNumber +"고등학력사항 정규직 교직원번호");
		System.out.println(temporaryAppointmentSchoolPersonnelNumber +"고등학력사항 비정규직 교직원번호");
		System.out.println(otherAppointmentSchoolPersonnelNumber +"고등학력사항 무기계약 교직원번호");
		String id = (String) session.getAttribute("userId");
		highSchool.setRecordId(id);
		
		
		// 조건문을 걸어 경우의수  정규직, 비정규직, 무기계약 3가지를 두고 페이지이동, 뷰에 넘버값을 유지시키기 위한 model 사용
		if(permanentAppointmentSchoolPersonnelNumber != null) {
			highSchool.setStudentTeacherNo(permanentAppointmentSchoolPersonnelNumber);
			System.out.println(permanentAppointmentSchoolPersonnelNumber +"고등학력사항 정규직 교직원번호(<-view)");
			personnelAppointmentService.insertHighSchool(highSchool);
			model.addAttribute("appointmentSchoolPersonnelNumber", permanentAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailPermanentAppointment";
		
		} else if(temporaryAppointmentSchoolPersonnelNumber != null) {
			highSchool.setStudentTeacherNo(temporaryAppointmentSchoolPersonnelNumber);
			System.out.println(temporaryAppointmentSchoolPersonnelNumber +"고등학력사항 비정규직 교직원번호(<-view)");
			personnelAppointmentService.insertHighSchool(highSchool);
			model.addAttribute("appointmentSchoolPersonnelNumber", temporaryAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailTemporaryAppointment";
		
		} else {
			highSchool.setStudentTeacherNo(otherAppointmentSchoolPersonnelNumber);
			System.out.println(otherAppointmentSchoolPersonnelNumber +"고등학력사항 무기계약 교직원번호(<-view)");
			personnelAppointmentService.insertHighSchool(highSchool);
			model.addAttribute("appointmentSchoolPersonnelNumber", otherAppointmentSchoolPersonnelNumber);
			return "redirect:/personnelAppoint/detailOtherAppointment";
		}
	}
}
