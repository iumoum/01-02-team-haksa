package com.cafe24.iumium.schoolregister.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iumium.schoolregister.code.dao.SchoolRegisterCodeDao;
import com.cafe24.iumium.schoolregister.code.dto.SemesterCode;

@Service
@Transactional
public class SchoolRegisterCodeService {
	
	@Autowired
	private SchoolRegisterCodeDao schoolRegisterCodeDao;
	
	// 모든 학기코드 조회
	public List<SemesterCode> selectAllSemesterCodes(){
		return schoolRegisterCodeDao.selectAllSemesterCodes();
	}
}
