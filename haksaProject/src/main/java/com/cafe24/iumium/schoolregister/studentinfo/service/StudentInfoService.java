package com.cafe24.iumium.schoolregister.studentinfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iumium.common.dto.DepartmentCode;
import com.cafe24.iumium.lesson.lecture.dto.ClassByDepartment;
import com.cafe24.iumium.schoolregister.studentinfo.dao.StudentInfoDao;
import com.cafe24.iumium.schoolregister.studentinfo.dto.Advice;
import com.cafe24.iumium.schoolregister.studentinfo.dto.ClassChange;
import com.cafe24.iumium.schoolregister.studentinfo.dto.Family;
import com.cafe24.iumium.schoolregister.studentinfo.dto.HighSchool;
import com.cafe24.iumium.schoolregister.studentinfo.dto.MyProfile;
import com.cafe24.iumium.schoolregister.studentinfo.dto.ScholarshipBenefit;
import com.cafe24.iumium.schoolregister.studentinfo.dto.StudentInfo;
import com.cafe24.iumium.schoolregister.studentinfo.dto.StudentState;

@Service
@Transactional
public class StudentInfoService {
	
	@Autowired	private StudentInfoDao studentInfoDao;
	
	// 학과 코드 불러오기
	public List<DepartmentCode> getDeptCodeList() {
		System.out.println("학과코드 service");
		return studentInfoDao.selectDeptCodeList();
	}
	
	// 학년 불러오기
	public List<DepartmentCode> getgradeList(DepartmentCode departmentCode) {
		System.out.println("학년 service");
		List<DepartmentCode> list = new ArrayList<DepartmentCode>();
		DepartmentCode grade = studentInfoDao.selectgradeList(departmentCode);
		int j = grade.getDeptGraduatedGrade();
		
		for(int i=0; i<j; i++) {
			grade.setDeptGraduatedGrade(i+1);
			list.add(grade);
		}
		
		return list;
	}
	
	// 반 불러오기
	public List<String> getdepartmentClassList(DepartmentCode department) {
		System.out.println("반 service");
		List<ClassByDepartment> classByDepartmentList = studentInfoDao.selectdepartmentClassList(department);
		List<String> list = new ArrayList<String>();
		String className = null;
		
		for(int i=0; i<classByDepartmentList.size(); i++) {
			className = classByDepartmentList.get(i).getClassByDepartmentClass();
			list.add(className);
		}
		
		TreeSet<String> list2 = new TreeSet<String>(list);
		list = new ArrayList<String>(list2);
		
		return list;
	}
	
	// 학생정보 리스트
	public List<StudentInfo> getStudentInfoList(StudentInfo studentInfo) {
		System.out.println("학생정보 리스트 service");
		return studentInfoDao.selectStudentInfoList(studentInfo);
	}
	
	// 1명의 학생정보
	public StudentInfo getStudentInfo(String studentNumber) {
		System.out.println("1명의 학생정보 service");
		int graduationDepartment = studentInfoDao.selectgraduationDepartment(studentNumber);
		
		if(graduationDepartment == 0) {
			return studentInfoDao.selectStudentInfoNull(studentNumber);
		} else {
			return studentInfoDao.selectStudentInfo(studentNumber);
		}
	}
	
	// 장학금 수혜내역 리스트
	public List<ScholarshipBenefit> getScholarshipBenefitList() {
		System.out.println("장학금 수혜내역 리스트 service");
		return studentInfoDao.selectScholarshipBenefitList();
	}
	
	// 상담 리스트
	public List<Advice> getAdviceList() {
		System.out.println("상담 리스트 service");
		return studentInfoDao.selectAdviceList();
	}
	
	// 반 변경 리스트
	public List<ClassChange> getClassChangeList() {
		System.out.println("반 변경 리스트 service");
		return studentInfoDao.selectClassChangeList();
	}
	
	// 학생 1명의 장학금 수혜내역
	public List<ScholarshipBenefit> getScholarshipBenefit(String studentNumber) {
		System.out.println("학생 1명의 장학금 수혜내역 service");
		return studentInfoDao.selectScholarshipBenefit(studentNumber);
	}
	
	// 학생 1명의 상담내역
	public List<Advice> getAdvice(String studentNumber) {
		System.out.println("학생 1명의 상담내역 service");
		return studentInfoDao.selectAdvice(studentNumber);
	}
	
	// 학생 1명의  반 변경 내역
	public List<ClassChange> getClassChange(String studentNumber) {
		System.out.println("학생 1명의  반 변경 내역 service");
		return studentInfoDao.selectClassChange(studentNumber);
	}
	
	// 학생 1명의 가족사항
	public List<Family> getFamily(String studentNumber) {
		System.out.println("학생 1명의 가족사항 service");
		return studentInfoDao.selectFamily(studentNumber);
	}
	
	// 학생 1명의 신상명세사항
	public MyProfile getMyProfile(String studentNumber) {
		System.out.println("학생 1명의 신상명세사항 service");
		return studentInfoDao.selectMyProfile(studentNumber);
	}
	
	// 학생 1명의 고등학력사항
	public HighSchool getHighSchool(String studentNumber) {
		System.out.println("학생 1명의 고등학력사항 service");
		return studentInfoDao.selectHighSchool(studentNumber);
	}
	
	// 국가 코드 불러오기
	public List<StudentInfo> getCountryCode() {
		System.out.println("국가 코드 불러오기 service");
		return studentInfoDao.selectCountryCode();
	}

	// 학생정보 입력
	public String addStudentInfo(StudentInfo studentInfo) {
		System.out.println("학생정보 입력 service");
		StudentInfo student = studentInfo;
		int i  = studentInfoDao.selectStudentNumber(studentInfo); // 중복체크 0이면 중복이 아니고 1이상이면 중복
		String check = null; // 중복과 입력이 제대로 되는지 확인하는 변수
		
		if(i != 0) {
			System.out.println("학번이 중복입니다.");
			check = "학번중복";
		} else {
			StudentInfo classByDepartment = studentInfoDao.selectClassByDepartment(studentInfo);
			student.setClassByDepartmentNumber(classByDepartment.getClassByDepartmentNumber());
			studentInfoDao.insertStudentInfo(student); // 학생정보 입력
			studentInfoDao.insertHuman(student); // 인적사항 입력
			String password = student.getHumanResidentRegistrationNumber().substring(0, 6); // 주민번호 앞자리 6자리를 잘라서 퍄스워드로 사용
			student.setHumanResidentRegistrationNumber(password);
			studentInfoDao.insertAccountManagement(student); // 로그인 테이블 입력
			
			check = "입력성공";
		}
		
		return check;
	}
	
	// 상담 입력
	public String addAdvice(Advice advice) {
		System.out.println("상담 입력 service");
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentNumber(advice.getStudentNumber()); // 학번 저장
		int i  = studentInfoDao.selectStudentNumber(studentInfo); // 학번이 있는지 확인하기 위한 변수
		String check = null; // 중복과 입력이 제대로 되는지 확인하는 변수
		
		if(i == 0) {
			System.out.println("학번이 없습니다.");
			check = "학번없음";
		} else {
			String adviceNumber = String.valueOf(studentInfoDao.selectAdviceNumber()+1);
			advice.setAdviceHistoryNumber(adviceNumber);
			studentInfoDao.insertAdvice(advice);
			check = "입력성공";
		}
		return check;
	}
	
	// 상담결과코드 불러오기
	public List<Advice> getCounselResultCode() {
		System.out.println("국가 코드 불러오기 service");
		return studentInfoDao.selectCounselResultCode();
	}
	
	// 반 변경 입력
	public String addClassChange(ClassChange classChange) {
		System.out.println("반 변경 입력 service");
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentNumber(classChange.getStudentNumber()); // 학번 저장
		studentInfo.setDeptCode(classChange.getDeptCode()); // 학과 저장
		studentInfo.setClassByDepartmentGrade(classChange.getClassByDepartmentGrade()); // 학년 저장
		studentInfo.setClassByDepartmentClass(classChange.getClassChangeAfter()); // 반 저장
		studentInfo.setClassByDepartmentDayAndNight(classChange.getClassChangeAfterDayAndNight()); // 주야 저장
		
		int i  = studentInfoDao.selectStudentNumber(studentInfo); // 학번이 있는지 확인하기 위한 변수
		String check = null; // 중복과 입력이 제대로 되는지 확인하는 변수
		
		if(i== 0) {
			System.out.println("학번이 없습니다.");
			check = "학번없음";
		} else {
			studentInfo.setClassByDepartmentNumber(studentInfoDao.selectClassByDepartment(studentInfo).getClassByDepartmentNumber());
			
			int j = studentInfoDao.updateStudentClassChange(studentInfo);
			
			if(j == 1) {
				String classChangeNumber = String.valueOf(studentInfoDao.selectClassChangeNumber()+1);
				classChange.setClassChangeNumber(classChangeNumber);
				String degreeSeparation = String.valueOf(studentInfoDao.selectDegreeSeparation(classChange)+1);
				classChange.setClassChangeDegreeSeparation(degreeSeparation);
				studentInfoDao.insertClassChange(classChange);
				
				check = "입력성공";
			}
		}
		return check;
	}
	
	// 장학금 입력
	public String addScholarshipBenefit(ScholarshipBenefit scholarshipBenefit) {
		System.out.println("장학금 입력 service");
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentNumber(scholarshipBenefit.getStudentNumber()); // 학번 저장
		int i  = studentInfoDao.selectStudentNumber(studentInfo); // 학번이 있는지 확인하기 위한 변수
		String check = null; // 중복과 입력이 제대로 되는지 확인하는 변수
		
		if(i== 0) {
			System.out.println("학번이 없습니다.");
			check = "학번없음";
		} else {
			String scholarshipBenefitNumber = String.valueOf(studentInfoDao.selectScholarshipBenefitNumber()+1);
			scholarshipBenefit.setScholarshipBenefitNumber(scholarshipBenefitNumber);
			studentInfoDao.insertScholarshipBenefit(scholarshipBenefit);
			check = "입력성공";
		}
		return check;
	}
	
	// 가족 입력
	public String addFamily(Family family) {
		System.out.println("가족 입력 service");
		String check = null;
		String familyNumber = String.valueOf(studentInfoDao.selectFamilyNumber()+1);
		family.setFamilyNumber(familyNumber);
		int i = studentInfoDao.insertFamily(family);
		
		if(i == 0) {
			check = "입력실패";
		} else {
			check = "입력성공";
		}
		
		return check;
	}
	
	// 고등학력사항 입력
	public String addHighSchool(HighSchool highSchool) {
		System.out.println("고등학력사항 입력 service");
		String check = null;
		int i = studentInfoDao.insertHighSchool(highSchool);
		
		if(i == 0) {
			check = "입력실패";
		} else {
			check = "입력성공";
		}
		
		return check;
	}
	
	// 신상명세사항 입력
	public String addMyProfile(MyProfile myProfile) {
		System.out.println("신상명세사항 입력 service");
		String check = null;
		int i = studentInfoDao.insertMyProfile(myProfile);
		
		if(i == 0) {
			check = "입력실패";
		} else {
			check = "입력성공";
		}
		
		return check;
	}
	
	// 학생상태 불러오기
	public List<StudentState> getStudentState() {
		System.out.println("학생상태 불러오기 service");
		List<StudentState> studentState = new ArrayList<StudentState>();
		StudentState studentState2016 = new StudentState();
		StudentState studentState2017 = new StudentState();
		StudentState studentState2018 = new StudentState();
		
		studentState2016.setEnrolledStudent(studentInfoDao.selectEnrolledStudent2016()); // 2016년도 재학생 저장
		studentState2016.setFreshman(studentInfoDao.selectEnrolledStudent2016()); // 2016년도 신입생 저장
		
		studentState2017.setEnrolledStudent(studentInfoDao.selectEnrolledStudent2017()); // 2017년도 재학생 저장
		studentState2017.setFreshman(studentInfoDao.selectFreshman2017()); // 2017년도 신입생 저장
		
		studentState2018.setEnrolledStudent(studentInfoDao.selectEnrolledStudent2018()); // 2018년도 재학생 저장
		studentState2018.setFreshman(studentInfoDao.selectFreshman2018()); // 2018년도 신입생 저장
		
		studentState.add(0, studentState2016);
		studentState.add(1, studentState2017);
		studentState.add(2, studentState2018);
		
		return studentState;
	}
	
	// 반 변경하기 위한 학생정보 불러오기
	public StudentInfo getStudentClassChange(String studentNumber) {
		System.out.println("반 변경하기 위한 학생정보 불러오기 service");
		return studentInfoDao.selectStudentClassChange(studentNumber);
	}
}