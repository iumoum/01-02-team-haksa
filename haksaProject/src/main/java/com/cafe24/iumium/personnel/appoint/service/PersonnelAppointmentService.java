// 이응빈
package com.cafe24.iumium.personnel.appoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iumium.personnel.appoint.dao.PersonnelAppointmentDao;
import com.cafe24.iumium.personnel.appoint.dto.Career;
import com.cafe24.iumium.personnel.appoint.dto.Education;
import com.cafe24.iumium.personnel.appoint.dto.HighSchool;
import com.cafe24.iumium.personnel.appoint.dto.MyProfile;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelAppointmentOther;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelBasic;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelPermanentAppointment;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelTemporaryAppointment;
import com.cafe24.iumium.personnel.appoint.dto.Position;
import com.cafe24.iumium.personnel.appoint.dto.Family;

@Service
@Transactional
public class PersonnelAppointmentService {
	@Autowired
	private PersonnelAppointmentDao personnelAppointmentDao;
	
	// 정규직 임용 리스트 Service
	public List<PersonnelPermanentAppointment> personnelPermanentAppointmentList() {
		System.out.println("정규직 임용 리스트 Service");
		return personnelAppointmentDao.personnelPermanentAppointmentList();
	}
	
	// 발령코드 불러오기 Service
	public List<PersonnelPermanentAppointment> getPersonnelCommonAppointmentCode() {
		System.out.println("발령코드 불러오기 Service");
		return personnelAppointmentDao.getPersonnelCommonAppointmentCode();
	}
	
	// 팀코드 불러오기 Service
	public List<PersonnelPermanentAppointment> getTeamCode() {
		System.out.println("팀코드 불러오기 Service");
		return personnelAppointmentDao.getTeamCode();
	}
	
	// 직급코드 불러오기 Service
	public List<PersonnelPermanentAppointment> getHaksaJobRank() {
		System.out.println("직급코드 불러오기 Service");
		return personnelAppointmentDao.getHaksaJobRank();
	}
	
	// 정규직 임용 상세정보 Service
	public PersonnelPermanentAppointment getDetailPermanentAppointment(String appointmentSchoolPersonnelNumber) {
		System.out.println("1명의 정보 임용 정규직 Service");
		return personnelAppointmentDao.getDetailPermanentAppointment(appointmentSchoolPersonnelNumber);
	}
	
	// 직위코드 불러오기 Service
	public List<PersonnelBasic> getJobPositionCode() {
		System.out.println("직위코드 불러오기 Service");
		return personnelAppointmentDao.getJobPositionCode();
	}
	
	// 비정규직 임용 리스트 Service
	public List<PersonnelTemporaryAppointment> temporaryAppointmentList() {
		System.out.println("비정규직 임용 리스트 Service");
		return personnelAppointmentDao.getTemporaryAppointmentList();
	}
	
	// 비정규직 임용 상세정보 Service
	public PersonnelTemporaryAppointment detailTemporaryAppointment(String appointmentSchoolPersonnelNumber) {
		System.out.println("비정규직 임용 상세정보 Service");
		return personnelAppointmentDao.getDetailTemporaryAppointment(appointmentSchoolPersonnelNumber);
	}
	
	// 무기계약 임용 리스트 Service
	public List<PersonnelAppointmentOther> appointmentOtherList() {
		System.out.println("무기계약 임용 리스트 Service");
		return personnelAppointmentDao.getAppointmentOtherList();
	}
	
	// 무기계약 임용 상세정보 Service
	public PersonnelAppointmentOther detailOtherAppointment(String appointmentSchoolPersonnelNumber) {
		System.out.println("무기계약 임용 상세정보 Service");
		return personnelAppointmentDao.getDetailOtherAppointment(appointmentSchoolPersonnelNumber);
	}
	
	// 인사기본사항 상세정보 Service
	public PersonnelBasic getPersonnelBasic(String number) {
		System.out.println("인사기본사항 상세정보 Service");
		return personnelAppointmentDao.getPersonnelBasic(number);
	}
	
	// 경력사항 상세정보 Service
	public List<Career> getCareer(String number) {
		System.out.println("경력사항 상세정보 Service");
		return personnelAppointmentDao.getCareer(number);
	}
	
	// 보직사항 상세정보 Service
	public Position getPosition(String number) {
		System.out.println("보직사항 상세정보 Service");
		return personnelAppointmentDao.getPosition(number);
	}
	
	// 가족사항 상세정보 Service
	public List<Family> getFamily(String number) {
		System.out.println("가족사항 상세정보 Service");
		return personnelAppointmentDao.getFamily(number);
	}
	
	// 대학 상세정보 Service
	public Education getEducation(String number) {
		System.out.println("대학 상세정보 Service");
		return personnelAppointmentDao.getEducation(number);
	}
	
	// 신상명세정보 상세정보 Service
	public MyProfile getMyProfile(String number) {
		System.out.println("신상명세정보 상세정보 Service");
		return personnelAppointmentDao.getMyProfile(number);
	}
	
	// 고등학력 상세정보 Service
	public HighSchool getHighSchool(String number) {
		System.out.println("고등학력 상세정보 Service");
		return personnelAppointmentDao.getHighSchool(number);
	}
	
	// 송원민, 각각의 기본키에 대한 번호는 view 에서 입력하지 않아 쿼리를 사용하여 번호를 가져옴
	// 인사기본사항 저장 Service
	public int insertPersonnelBasic(PersonnelBasic personnelBasic) {
		System.out.println("인사기본사항 저장 Service");
		// 인사기본사항 기본키 넘버
		String personnelBasicNumber = String.valueOf(personnelAppointmentDao.selectPersonnelBasicNumber()+1);
		personnelBasic.setPersonnelBasicNumber(personnelBasicNumber); 
		return personnelAppointmentDao.insertPersonnelBasic(personnelBasic);
	}
	
	// 경력사항 저장 Service
	public int insertCareer(Career career) {
		System.out.println("경력사항 저장 Service");
		// 인사기본사항 기본키 넘버
		String careerNumber = String.valueOf(personnelAppointmentDao.selectCareerNumber()+1);
		career.setCareerNumber(careerNumber);
		return personnelAppointmentDao.insertCareer(career);
	}
	
	// 보직사항 저장 Service
	public int insertPosition(Position position) {
		System.out.println("보직사항 저장 Service");
		// 보직사항 기본키 넘버
		String positionNumber = String.valueOf(personnelAppointmentDao.selectPositionNumber()+1);
		position.setPositionNumber(positionNumber);
		return personnelAppointmentDao.insertPosition(position);
	}
	
	// 가족사항 저장 Service
	public int insertFamily(Family family) {
		System.out.println("가족사항 저장 Service");
		// 가족사항 기본키 넘버
		String familyNumber = String.valueOf(personnelAppointmentDao.selectFamilyNumber()+1);
		family.setFamilyNumber(familyNumber);
		return personnelAppointmentDao.insertFamily(family);
	}
	
	// 대학교학력사항 저장 Service
	public int insertEducation(Education education) {
		System.out.println("대학교학력사항사항 저장 Service");
		// 대학교학력사항 기본키 넘버
		String educationNumber = String.valueOf(personnelAppointmentDao.selectEducationNumber()+1);
		education.setStudentTeacherNo(educationNumber);
		return personnelAppointmentDao.insertEducation(education);
	}
	
	// 신상명세정보 저장 Service
	public int insertMyProfile(MyProfile myProfile) {
		System.out.println("신상명세정보 저장 Service");
		// 신상명세정보 기본키 넘버
		String MyProfileNumber = String.valueOf(personnelAppointmentDao.selectMyProfileNumber()+1);
		myProfile.setStudentTeacherNo(MyProfileNumber);
		return personnelAppointmentDao.insertMyProfile(myProfile);
	}
	
	// 고등학력 사항 저장 Service
	public int insertHighSchool(HighSchool highSchool) {
		System.out.println("고등학력 저장 Service");
		// 고등학력 기본키 넘버
		String highSchoolNumber = String.valueOf(personnelAppointmentDao.selectHighSchoolNumber()+1);
		highSchool.setStudentTeacherNo(highSchoolNumber);
		return personnelAppointmentDao.insertHighSchool(highSchool);
	}
}