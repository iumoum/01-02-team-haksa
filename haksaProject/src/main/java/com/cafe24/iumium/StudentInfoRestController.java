package com.cafe24.iumium;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.iumium.common.dto.DepartmentCode;
import com.cafe24.iumium.schoolregister.studentinfo.dto.Advice;
import com.cafe24.iumium.schoolregister.studentinfo.dto.ClassChange;
import com.cafe24.iumium.schoolregister.studentinfo.dto.Family;
import com.cafe24.iumium.schoolregister.studentinfo.dto.HighSchool;
import com.cafe24.iumium.schoolregister.studentinfo.dto.MyProfile;
import com.cafe24.iumium.schoolregister.studentinfo.dto.ScholarshipBenefit;
import com.cafe24.iumium.schoolregister.studentinfo.dto.StudentInfo;
import com.cafe24.iumium.schoolregister.studentinfo.service.StudentInfoService;


@CrossOrigin
@RestController
public class StudentInfoRestController {
	
	@Autowired	private StudentInfoService studentInfoService;
	
	// 학과 코드 불러오기
	@RequestMapping(value = "/rest/deptCode", method = RequestMethod.GET)
	public List<DepartmentCode> deptCodeList() {
		System.out.println("/rest/deptCode GET 방식 주소");
		return studentInfoService.getDeptCodeList();
	}
	
	// 학년 불러오기
	@RequestMapping(value = "/rest/grade", method = RequestMethod.GET)
	public List<DepartmentCode> gradeList(DepartmentCode department) {
		System.out.println("/rest/grade get");
		return studentInfoService.getgradeList(department);
	}
	
	// 반 불러오기
	@RequestMapping(value = "/rest/departmentClass", method = RequestMethod.GET)
	public List<String> departmentClassList(DepartmentCode department) {
		System.out.println("/rest/departmentClass get");
		return studentInfoService.getdepartmentClassList(department);
	}
	
	// 학생정보 리스트
	@RequestMapping(value = "/rest/studentList", method = RequestMethod.GET)
	public List<StudentInfo> studentInfoList(StudentInfo studentInfo) {
		System.out.println("/rest/studentList get");
		return studentInfoService.getStudentInfoList(studentInfo);
	}
	
	// 학생 1명의 장학금 수혜내역
	@RequestMapping(value = "/rest/scholarshipBenefit", method = RequestMethod.GET)
	public List<ScholarshipBenefit> scholarshipBenefit(String studentNumber) {
		System.out.println("/rest/scholarshipBenefit get");
		return studentInfoService.getScholarshipBenefit(studentNumber);
	}
	
	// 학생 1명의 상담내역
	@RequestMapping(value = "/rest/advice", method = RequestMethod.GET)
	public List<Advice> advice(String studentNumber) {
		System.out.println("/rest/advice get");
		return studentInfoService.getAdvice(studentNumber);
	}
	
	// 학생 1명의 반 변경 내역
	@RequestMapping(value = "/rest/classChange", method = RequestMethod.GET)
	public List<ClassChange> classChange(String studentNumber) {
		System.out.println("/rest/classChange get");
		return studentInfoService.getClassChange(studentNumber);
	}
	
	// 학생 1명의 가족사항
	@RequestMapping(value = "/rest/family", method = RequestMethod.GET)
	public List<Family> family(String studentNumber) {
		System.out.println("/rest/family get");
		return studentInfoService.getFamily(studentNumber);
	}
	
	// 학생 1명의 신상명세사항
	@RequestMapping(value = "/rest/myProfile", method = RequestMethod.GET)
	public MyProfile myProfile(String studentNumber) {
		System.out.println("/rest/myProfile get");
		return studentInfoService.getMyProfile(studentNumber);
	}
	
	// 학생 1명의 고등학력사항
	@RequestMapping(value = "/rest/highSchool", method = RequestMethod.GET)
	public HighSchool highSchool(String studentNumber) {
		System.out.println("/rest/highSchool get");
		return studentInfoService.getHighSchool(studentNumber);
	}
	
	// 국가 코드 불러오기
	@RequestMapping(value = "/rest/countryCode", method = RequestMethod.GET)
	public List<StudentInfo> countryCode() {
		System.out.println("/rest/countryCode get");
		return studentInfoService.getCountryCode();
	}
	
	// 학생정보 입력
	@ResponseBody
	@RequestMapping(value = "/rest/addStudentInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String insertStudentInfo(@RequestBody StudentInfo studentInfo) {
		System.out.println("/rest/insertStudentInfo get");
		return studentInfoService.addStudentInfo(studentInfo);
	}
	
	// 상담 입력
	@ResponseBody
	@RequestMapping(value = "/rest/addAdvice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String insertAdvice(@RequestBody Advice advice) {
		System.out.println("/rest/addAdvice get");
		return studentInfoService.addAdvice(advice);
	}
	
	// 상담결과코드 불러오기
	@RequestMapping(value = "/rest/counselResultCode", method = RequestMethod.GET)
	public List<Advice> counselResultCode() {
		System.out.println("/rest/counselResultCode get");
		return studentInfoService.getCounselResultCode();
	}
}
