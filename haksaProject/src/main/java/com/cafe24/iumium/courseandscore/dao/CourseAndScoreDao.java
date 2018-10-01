package com.cafe24.iumium.courseandscore.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.courseandscore.dto.EnrolCourse;

@Repository
public class CourseAndScoreDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String nameSpace = "com.cafe24.iumium.courseandscore.dao.CourseAndScoreMapper.";
	
	// 1.세션 아이디 받아서 학과코드, 반 조회
	public int inquireStudentDept(String id){
		System.out.println("CourseAndScoreDao - inquireStudentDept() 호출");
		List<EnrolCourse> list = sqlSessionTemplate.selectList(nameSpace + "inquireStudentDept", id);
		
		int deptCode = list.get(0).getDeptCode();
		System.out.println("학번으로 조회된 학과 코드 : " + deptCode);
		
		return deptCode;
	}
	
	// 조회된 학과로 강의상황서의 학과가 일치하는 과목코드 조회
	
	/*public List<EnrolCourse> inquireDeptCourse(int deptCode){
		System.out.println("CourseAndScoreDao - inquireDeptCourse() 호출");
		
		return sqlSessionTemplate.selectList(nameSpace + "inquireDeptCourse", deptCode);
	}*/
}
