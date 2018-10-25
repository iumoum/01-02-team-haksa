package com.cafe24.iumium.courseandscore.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.courseandscore.dto.EnrolCourse;
import com.cafe24.iumium.courseandscore.dto.InsertScore;

@Repository
public class CourseAndScoreDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String nameSpace = "com.cafe24.iumium.courseandscore.dao.CourseAndScoreMapper.";
	
	// 1.세션 아이디 받아서 학과코드, 반 조회
	public int inquireClassByDepartmentNumber(String id){
		System.out.println("CourseAndScoreDao - inquireClassByDepartmentNumber() 호출");
		List<EnrolCourse> list = sqlSessionTemplate.selectList(nameSpace + "inquireClassByDepartmentNumber", id);
		
		int classByDepartmentNumber = list.get(0).getClassByDepartmentNumber();
		System.out.println("학번으로 조회된 학과별반번호 : " + classByDepartmentNumber);
		
		return classByDepartmentNumber;
	}
	
	// 2.조회된 학과별반번호로 강의상황서 번호와 모든 속성코드 조회
	
	public List<EnrolCourse> inquireLectureStatus(int lectureStatusNumber){
		System.out.println("CourseAndScoreDao - inquireDeptCourse() 호출");
		
		return sqlSessionTemplate.selectList(nameSpace + "inquireLectureStatus", lectureStatusNumber);
	}
	// 2-1 관리자 계정일 시 모든 강의상황서 번호와 모든 속성코드 조회
	
	public List<EnrolCourse> inquireLectureStatusByAdmin(){
		System.out.println("CourseAndScoreDao - inquireLectureStatusByAdmin() 호출");
		return sqlSessionTemplate.selectList(nameSpace + "inquireLectureStatusByAdmin");
	}
	
	// 2-2 세션 아이디의 수강신청 내역 조회
	public List<EnrolCourse> inquireEnrolCourseList(String id) {
		return sqlSessionTemplate.selectList(nameSpace + "inquireEnrolCourseList", id);
	}
	
	// 3. 입력된 조건, 값으로 수강신청내역 테이블에서 학번이 일치하는 모든 레코드의 컬럼 값 조회
	
	public List<EnrolCourse> inquireSearchLectureById(String[] array) {
		return sqlSessionTemplate.selectList(nameSpace + "inquireSearchLectureById", array);
	}
	
	//	4. 세션 교수 아이디로 담당 과목코드 조회
	public List<InsertScore> inquireEnrolScoreCourseCode(String id) {
		return sqlSessionTemplate.selectList(nameSpace + "inquireEnrolScoreCourseCode", id);
	}
	
	//	4-1. 세션 관리자 아이디로 모든 과목코드 조회
	public List<InsertScore> inquireEnrolScoreCourseCodeByAdmin() {
		return sqlSessionTemplate.selectList(nameSpace + "inquireEnrolScoreCourseCodeByAdmin");
	}
	
	// 5. 교과명으로 수강신청내역 테이블 학번 리스트 조회
	public List<EnrolCourse> inquireEnrolScoreStudentNum(String subjectName) {
		System.out.println("CourseAndScoreDao - inquireEnrolScoreStudentNum()");
		return sqlSessionTemplate.selectList(nameSpace + "inquireEnrolScoreStudentNum", subjectName);
	}
	
	// 6. 입력받은 반의 값으로 성적입력테이블에서 반이 일치하는 학생들의 평균 총점을 조회한다.
	public List<EnrolCourse> inquireEnrolScoreCourseByClass(String ClassName) {
		System.out.println("CourseAndScoreDao - inquireEnrolScoreCourseByClass()");
		List<EnrolCourse> enrolCourse = sqlSessionTemplate.selectList(nameSpace + "inquireEnrolScoreCourseByClass", ClassName);
		
		if (enrolCourse.size() != 0) {
			System.out.println("학생 평점 출력 : " + enrolCourse.get(0).getInsertScoreTotalAverageScore());
		}
		
		return enrolCourse;
	}
	// 7. 입력받은 학과의 값으로 성적입력테이블에서 반이 일치하는 학생들의 평균 총점을 조회한다.
	public List<EnrolCourse> inquireprintScoreCourseByDept(String DeptName) {
		System.out.println("CourseAndScoreDao - inquireprintScoreCourseByDept()");
		List<EnrolCourse> enrolCourse = sqlSessionTemplate.selectList(nameSpace + "inquireprintScoreCourseByDept", DeptName);
		
		return enrolCourse;
	}
	// 8. 입력받은 데이터를 차례로 수강신청내역 테이블에 입력한다.
	public int insertEnrolCourse(Map<String, String> enrolCourse) {
		System.out.println("CourseAndScoreDao - insertEnrolCourse() id 호출 = " + enrolCourse.get("id"));
		return sqlSessionTemplate.insert(nameSpace + "insertEnrolCourse",enrolCourse);
	}
	
	// 8-1. 입력받은 수강신청내역 번호를 입력하여 수강신청 내역을 삭제한다.
	public int removeEnrolCourse(Map<String,String> lectureStatusNumberArr) {
		System.out.println("CourseAndScoreDao - removeEnrolCourse() = " + lectureStatusNumberArr.get("arr[0]"));
		return sqlSessionTemplate.delete(nameSpace + "removeEnrolCourse",lectureStatusNumberArr);
	}
}
