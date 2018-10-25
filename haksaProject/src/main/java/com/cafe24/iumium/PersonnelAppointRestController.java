// 이응빈 작업
package com.cafe24.iumium;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.iumium.personnel.appoint.dto.Career;
import com.cafe24.iumium.personnel.appoint.dto.Education;
import com.cafe24.iumium.personnel.appoint.dto.HighSchool;
import com.cafe24.iumium.personnel.appoint.dto.MyProfile;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelBasic;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelPermanentAppointment;
import com.cafe24.iumium.personnel.appoint.dto.Position;
import com.cafe24.iumium.personnel.appoint.service.PersonnelAppointmentService;
import com.cafe24.iumium.schoolregister.studentinfo.dto.Family;

@CrossOrigin
@RestController
public class PersonnelAppointRestController {
	@Autowired private PersonnelAppointmentService personnelAppointmentService;
	
	// 발령코드 호출
	@RequestMapping(value="/rest/personnelCommonAppointmentCode", method = RequestMethod.GET)
	public List<PersonnelPermanentAppointment> personnelCommonAppointmentCode() {
		System.out.println("/rest/personnelCommonAppointmentCode GET 방식");
		return personnelAppointmentService.getPersonnelCommonAppointmentCode();	
	}
	
	// 팀코드 호출
	@RequestMapping(value="/rest/teamCode", method = RequestMethod.GET)
	public List<PersonnelPermanentAppointment> teamCode() {
		System.out.println("/rest/teamCode GET 방식");
		return personnelAppointmentService.getTeamCode();	
	}
	
	// 직급코드 호출
	@RequestMapping(value="/rest/haksaJobRank", method = RequestMethod.GET)
	public List<PersonnelPermanentAppointment> haksaJobRank() {
		System.out.println("/rest/haksaJobRank GET 방식");
		return personnelAppointmentService.getHaksaJobRank();	
	}
	
	// 직위코드 호출
	@RequestMapping(value="/rest/jobPositionCode", method = RequestMethod.GET)
	public List<PersonnelBasic> jobPositionCode() {
		System.out.println("/rest/jobPositionCode GET 방식");
		return personnelAppointmentService.getJobPositionCode();	
	}
	
	// 인사기본사항 상세정보 호출
	@RequestMapping(value="/rest/personnelBasic", method = RequestMethod.GET)
	public PersonnelBasic personnelBasic(String number) {
		System.out.println("/rest/personnelBasic GET 방식");
		return personnelAppointmentService.getPersonnelBasic(number);	
	}
	
	// 경력사항 상세정보 호출
	@RequestMapping(value="/rest/career", method = RequestMethod.GET)
	public List<Career> career(String number) {
		System.out.println("/rest/career GET 방식");
		return personnelAppointmentService.getCareer(number);
	}
	
	// 보직사항 상세정보 호출
	@RequestMapping(value="/rest/position", method = RequestMethod.GET)
	public Position position(String number) {
		System.out.println("/rest/position GET 방식");
		return personnelAppointmentService.getPosition(number);
	}
	
	// 가족사항 상세정보 호출
	@RequestMapping(value="/rest/teacherFamily", method = RequestMethod.GET)
	public List<Family> family(String number) {
		System.out.println("/rest/teacherFamily GET 방식");
		return personnelAppointmentService.getFamily(number);
	}
	
	// 대학 상세정보 호출
	@RequestMapping(value="/rest/education", method = RequestMethod.GET)
	public Education education(String number) {
		System.out.println("/rest/education GET 방식");
		return personnelAppointmentService.getEducation(number);
	}
	
	// 신상명세정보 상세정보 호출
	@RequestMapping(value="/rest/teacherMyProfile", method = RequestMethod.GET)
	public MyProfile myProfile(String number) {
		System.out.println("/rest/teacherMyProfile GET 방식");
		return personnelAppointmentService.getMyProfile(number);
	}
	
	// 고등학력 상세정보 호출
	@RequestMapping(value="/rest/teacherHighSchool", method = RequestMethod.GET)
	public HighSchool highSchool(String number) {
		System.out.println("/rest/teacherHighSchool GET 방식");
		return personnelAppointmentService.getHighSchool(number);
	}
}
