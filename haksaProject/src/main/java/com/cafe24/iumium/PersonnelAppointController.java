package com.cafe24.iumium;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.iumium.personnel.appoint.dto.PersonnelAppointmentOther;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelPermanentAppointment;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelPromotion;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelTemporaryAppointment;
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
		return "personnelAppoint/addPermanentAppointment";	
	}
	
	// 승진처리 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addPromotion", method = RequestMethod.GET)
	public String addPromotion() {
		System.out.println("승진 입력 페이지 호출");
		return "personnelAppoint/addPromotion";	
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
		
		return "personnelAppoint/listPromotionProcess";
	}
	
	// 정규직 임용 리스트 페이지 호출
	@RequestMapping(value="/personnelAppoint/listPermanentAppointment", method = RequestMethod.GET)
	public String permanentAppointmentList(Model model) {
		System.out.println("정규직 임용 리스트 페이지 호출");
		List<PersonnelPermanentAppointment> permanentAppointmentList = personnelAppointmentService.personnelPermanentAppointmentList();
		model.addAttribute("permanentAppointmentList", permanentAppointmentList);
		return "personnelAppoint/listPermanentAppointment";	
	}
	
	// 정규직 임용 상세정보 페이지 호출
	@RequestMapping(value="/personnelAppoint/detailPermanentAppointment", method = RequestMethod.GET)
	public String permanentAppointmentDetail(Model model, HttpServletRequest request) {
		System.out.println("정규직 임용 상세정보 페이지 호출");
		String appointmentSchoolPersonnelNumber = request.getParameter("appointmentSchoolPersonnelNumber");
		PersonnelPermanentAppointment detailPermanentAppointment = personnelAppointmentService.getDetailPermanentAppointment(appointmentSchoolPersonnelNumber);
		model.addAttribute("detailPermanentAppointment", detailPermanentAppointment);
		return "personnelAppoint/detailPermanentAppointment";	
	}
	
	// 인사기본사항 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addPersonnelBasic", method = RequestMethod.GET)
	public String addPersonnelBasic() {
		System.out.println("인사기본사항 입력 페이지 호출");
		return "personnelAppoint/addPersonnelBasic";	
	}
	
	// 경력사항 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addCareer", method = RequestMethod.GET)
	public String addCareer() {
		System.out.println("경력사항 입력 페이지 호출");
		return "personnelAppoint/addCareer";	
	}
	
	// 보직사항 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addPosition", method = RequestMethod.GET)
	public String addPosition() {
		System.out.println("보직사항 입력 페이지 호출");
		return "personnelAppoint/addPosition";	
	}
	
	// 가족사항 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addFamily", method = RequestMethod.GET)
	public String addFamily() {
		System.out.println("가족사항 입력 페이지 호출");
		return "personnelAppoint/addFamily";	
	}
	
	// 대학교학력사항 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addEducation", method = RequestMethod.GET)
	public String addEducation() {
		System.out.println("대학교학력사항 입력 페이지 호출");
		return "personnelAppoint/addEducation";	
	}
	
	// 신상명세정보 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addMyProfile", method = RequestMethod.GET)
	public String addMyProfile() {
		System.out.println("신상명세정보 입력 페이지 호출");
		return "personnelAppoint/addMyProfile";	
	}
	
	// 고등학력사항 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addHighSchool", method = RequestMethod.GET)
	public String addHighSchool() {
		System.out.println("고등학력사항 입력 페이지 호출");
		return "personnelAppoint/addHighSchool";	
	}
	
	// 비정규직 임용 리스트 페이지 호출
	@RequestMapping(value="/personnelAppoint/listTemporaryAppointment", method = RequestMethod.GET)
	public String temporaryAppointmentList(Model model) {
		System.out.println("비정규직 임용 리스트 페이지 호출");
		List<PersonnelTemporaryAppointment> temporaryAppointmentList = personnelAppointmentService.temporaryAppointmentList();
		model.addAttribute("temporaryAppointmentList", temporaryAppointmentList);
		return "personnelAppoint/listTemporaryAppointment";	
	}
	
	// 비정규직 임용 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addTemporaryAppointment", method = RequestMethod.GET)
	public String addTemporaryAppointment() {
		System.out.println("비정규직 임용 입력 페이지 호출");
		return "personnelAppoint/addTemporaryAppointment";	
	}
	
	// 비정규직 임용 상세정보 페이지 호출
	@RequestMapping(value="/personnelAppoint/detailTemporaryAppointment", method = RequestMethod.GET)
	public String detailTemporaryAppointment(Model model, HttpServletRequest request) {
		System.out.println("비정규직 임용 상세정보 페이지 호출");
		String appointmentSchoolPersonnelNumber = request.getParameter("appointmentSchoolPersonnelNumber");
		PersonnelTemporaryAppointment detailTemporaryAppointment = personnelAppointmentService.detailTemporaryAppointment(appointmentSchoolPersonnelNumber);
		model.addAttribute("detailTemporaryAppointment", detailTemporaryAppointment);
		return "personnelAppoint/detailTemporaryAppointment";	
	}
	
	// 무기계약 임용 리스트 페이지 호출
	@RequestMapping(value="/personnelAppoint/listOtherAppointment", method = RequestMethod.GET)
	public String otherAppointmentList(Model model) {
		System.out.println("무기계약 임용 리스트 페이지 호출");
		List<PersonnelAppointmentOther> appointmentOtherList = personnelAppointmentService.appointmentOtherList();
		model.addAttribute("appointmentOtherList", appointmentOtherList);
		return "personnelAppoint/listOtherAppointment";	
	}
	
	// 무기계약 임용 입력 페이지 호출
	@RequestMapping(value="/personnelAppoint/addOtherAppointment", method = RequestMethod.GET)
	public String addOtherAppointment(Model model) {
		System.out.println("무기계약 임용 입력 페이지 호출");
		return "personnelAppoint/addOtherAppointment";
	}
	
	// 무기계약 임용 상세정보 페이지 호출
	@RequestMapping(value="/personnelAppoint/detailOtherAppointment", method = RequestMethod.GET)
	public String detailOtherAppointment(Model model, HttpServletRequest request) {
		System.out.println("무기계약 임용 상세정보 페이지 호출");
		String appointmentSchoolPersonnelNumber = request.getParameter("appointmentSchoolPersonnelNumber");
		PersonnelAppointmentOther detailOtherAppointment = personnelAppointmentService.detailOtherAppointment(appointmentSchoolPersonnelNumber);
		model.addAttribute("detailOtherAppointment", detailOtherAppointment);
		return "personnelAppoint/detailOtherAppointment";
	}
}
