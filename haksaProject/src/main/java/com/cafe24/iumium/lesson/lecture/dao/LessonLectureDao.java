package com.cafe24.iumium.lesson.lecture.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.lesson.lecture.dto.ClassByDepartment;

@Repository
public class LessonLectureDao {

		@Autowired
		private SqlSessionTemplate sqlSessionTemplate;
		
		private final String nameSpace = "com.cafe24.iumium.lesson.lecture.dao.LessonLectureMapper.";
		
		// 학과별 반 리스트 조회
		public List<ClassByDepartment> selectAllClassesByDepartment(){
			return sqlSessionTemplate.selectList(nameSpace + "selectAllClassesByDepartment");
		}
}
