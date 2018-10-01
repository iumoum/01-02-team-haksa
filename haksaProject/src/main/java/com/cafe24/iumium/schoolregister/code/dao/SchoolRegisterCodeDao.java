package com.cafe24.iumium.schoolregister.code.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.schoolregister.code.dto.SemesterCode;

@Repository
public class SchoolRegisterCodeDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String nameSpace = "com.cafe24.iumium.schoolregister.code.dao.SchoolRegisterCodeMapper.";
	
	// 모든 학기코드 조회
	public List<SemesterCode> selectAllSemesterCodes(){
		return sqlSessionTemplate.selectList(nameSpace + "selectAllSemesterCodes");
	}
}
