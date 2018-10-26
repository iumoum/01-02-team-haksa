// 이응빈
package com.cafe24.iumium.personnel.appoint.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.personnel.appoint.dto.Career;
import com.cafe24.iumium.personnel.appoint.dto.Education;
import com.cafe24.iumium.personnel.appoint.dto.HighSchool;
import com.cafe24.iumium.personnel.appoint.dto.MyProfile;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelAppointmentOther;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelBasic;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelPermanentAppointment;
import com.cafe24.iumium.personnel.appoint.dto.PersonnelTemporaryAppointment;
import com.cafe24.iumium.personnel.appoint.dto.Position;
import com.cafe24.iumium.schoolregister.studentinfo.dto.Family;

@Repository
public class PersonnelAppointmentDao {
	private final String NS = "com.cafe24.iumium.personnel.appoint.dao.PersonnelAppointmentMapper.";
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	// 정규직 임용리스트 dao
	public List<PersonnelPermanentAppointment> personnelPermanentAppointmentList() {
		System.out.println("정규직 임용리스트 dao");
		return sqlSessionTemplate.selectList(NS+"personnelPermanentAppointmentList");
	}
	
	// 발령코드 불러오기 dao
	public List<PersonnelPermanentAppointment> getPersonnelCommonAppointmentCode() {
		System.out.println("발령코드 불러오기 dao");
		return sqlSessionTemplate.selectList(NS+"personnelCommonAppointmentCode");
	}
	
	// 팀코드 불러오기 dao
	public List<PersonnelPermanentAppointment> getTeamCode() {
		System.out.println("팀코드 불러오기 dao");
		return sqlSessionTemplate.selectList(NS+"teamCode");
	}
	
	// 직급코드 불러오기 dao
	public List<PersonnelPermanentAppointment> getHaksaJobRank() {
		System.out.println("직급코드 불러오기 dao");
		return sqlSessionTemplate.selectList(NS+"haksaJobRank");
	}
	
	// 정규직 임용 상세정보 dao
	public PersonnelPermanentAppointment getDetailPermanentAppointment(String appointmentSchoolPersonnelNumber) {
		System.out.println("1명의 정보 임용 정규직 dao");
		return sqlSessionTemplate.selectOne(NS+"detailPermanentAppointment", appointmentSchoolPersonnelNumber);
	}
	
	// 직위코드 불러오기 dao
	public List<PersonnelBasic> getJobPositionCode() {
		System.out.println("직위코드 불러오기 dao");
		return sqlSessionTemplate.selectList(NS+"jobPositionCode");
	}
	
	// 비정규직 임용 리스트 dao
	public List<PersonnelTemporaryAppointment> getTemporaryAppointmentList() {
		System.out.println("비정규직 임용 리스트 dao");
		return sqlSessionTemplate.selectList(NS+"temporaryAppointmentList");
	}
	
	// 비정규직 임용 상세정보 dao
	public PersonnelTemporaryAppointment getDetailTemporaryAppointment(String appointmentSchoolPersonnelNumber) {
		System.out.println("비정규직 임용 상세정보 dao");
		return sqlSessionTemplate.selectOne(NS+"detailTemporaryAppointment", appointmentSchoolPersonnelNumber);
	}
	
	// 무기계약 임용 리스트 dao
	public List<PersonnelAppointmentOther> getAppointmentOtherList() {
		System.out.println("무기계약 임용 리스트 dao");
		return sqlSessionTemplate.selectList(NS+"appointmentOtherList");
	}
	
	// 무기계약 임용 상세정보 dao
	public PersonnelAppointmentOther getDetailOtherAppointment(String appointmentSchoolPersonnelNumber) {
		System.out.println("무기계약 임용 상세정보 dao");
		return sqlSessionTemplate.selectOne(NS+"detailOtherAppointment", appointmentSchoolPersonnelNumber);
	}
	
	// 인사기본사항 상세정보 dao
	public PersonnelBasic getPersonnelBasic(String number) {
		System.out.println("인사기본사항 상세정보 dao");
		return sqlSessionTemplate.selectOne(NS+"personnelBasic", number);
	}
	
	// 경력사항 상세정보 dao
	public List<Career> getCareer(String number) {
		System.out.println("경력사항 상세정보 dao");
		return sqlSessionTemplate.selectList(NS+"career", number);
	}
	
	// 보직사항 상세정보 dao
	public Position getPosition(String number) {
		System.out.println("보직사항 상세정보 dao");
		return sqlSessionTemplate.selectOne(NS+"position", number);
	}
	
	// 가족사항 상세정보 dao
	public List<Family> getFamily(String number) {
		System.out.println("가족사항 상세정보 dao");
		return sqlSessionTemplate.selectList(NS+"family", number);
	}
	
	// 대학 상세정보 dao
	public Education getEducation(String number) {
		System.out.println("대학 상세정보 dao");
		return sqlSessionTemplate.selectOne(NS+"education", number);
	}
	
	// 신상명세정보 상세정보 dao
	public MyProfile getMyProfile(String number) {
		System.out.println("신상명세정보 상세정보 dao");
		return sqlSessionTemplate.selectOne(NS+"myProfile", number);
	}
	
	// 고등학력 상세정보 dao
	public HighSchool getHighSchool(String number) {
		System.out.println("고등학력 상세정보 dao");
		return sqlSessionTemplate.selectOne(NS+"highSchool", number);
	}
	
	// 송원민
	// 인사기본사항 dao
	public int insertPersonnelBasic(PersonnelBasic personnelBasic) {
		System.out.println("인사기본사항 저장 dao");
		return sqlSessionTemplate.insert(NS+"insertPersonnelBasic", personnelBasic);
	}
	
	// 인사기본사항 번호 조회 dao
	public int selectPersonnelBasicNumber() {
		System.out.println("인사기본사항 번호 조회 dao");
		return sqlSessionTemplate.selectOne(NS+"selectPersonnelBasicNumber");
	}
	
	// 경력사항 저장 dao
	public int insertCareer(Career career) {
		System.out.println("경력사항 저장 dao");
		return sqlSessionTemplate.insert(NS+"insertCareer", career);
	}
	
	// 경력사항 번호 조회 dao
	public int selectCareerNumber() {
		System.out.println("경력사항 번호 조회 dao");
		return sqlSessionTemplate.selectOne(NS+"selectCareerNumber");
	}
	
	// 보직사항 저장 dao
	public int insertPosition(Position position) {
		System.out.println("보직사항 저장 dao");
		return sqlSessionTemplate.insert(NS+"insertPosition", position);
	}
	
	// 보직사항 번호 조회 dao
	public int selectPositionNumber() {
		System.out.println("보직사항 번호 조회 dao");
		return sqlSessionTemplate.selectOne(NS+"selectPositionNumber");
	}
	
	// 가족사항 저장 dao
	public int insertFamily(Family family) {
		System.out.println("가족사항사항 저장 dao");
		return sqlSessionTemplate.insert(NS+"insertFamily", family);
	}
	
	// 가족사항 번호 조회 dao
	public int selectFamilyNumber() {
		System.out.println("가족사항 번호 조회 dao");
		return sqlSessionTemplate.selectOne(NS+"selectFamilyNumber");
	}
}
