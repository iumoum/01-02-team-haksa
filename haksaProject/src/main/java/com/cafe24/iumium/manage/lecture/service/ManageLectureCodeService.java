package com.cafe24.iumium.manage.lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iumium.manage.lecture.dao.ManageLectureCodeDao;
import com.cafe24.iumium.manage.lecture.dto.AssignmentForEvaluateCode;
import com.cafe24.iumium.manage.lecture.dto.GradingCriteriaCode;
import com.cafe24.iumium.manage.lecture.dto.QuestionForEvaluateLectureCode;
import com.cafe24.iumium.manage.lecture.dto.SubjectCode;
import com.cafe24.iumium.manage.lecture.dto.TypeOfCompletionCode;

@Service
@Transactional
public class ManageLectureCodeService {
	@Autowired
	private ManageLectureCodeDao lectureCode;
	
	// 이수 구분 코드 리스트
	public List<TypeOfCompletionCode> selectManageLectureTocList() {
        return lectureCode.selectManageLectureTocList();
    }
	
	// 과목 코드 리스트
	public List<SubjectCode> selectManageLectureSubjectList(){
		return lectureCode.selectManageLectureSubjectList();
	}
	
	// 강의 평가 항목 코드 리스트
	public List<QuestionForEvaluateLectureCode> selectManageLectureQfelList(){
		return lectureCode.selectManageLectureQfelList();
	}
	
	// 강의별 평가항목 배정 코드 리스트
	public List<AssignmentForEvaluateCode> selectManageLectureAfeList(){
		return lectureCode.selectManageLectureAfeList();
	
	}
	// 성적 평가 기준 리스트
	public List<GradingCriteriaCode> selectManageLectureGccList(){
		return lectureCode.selectManageLectureGccList();
	
	}
}
