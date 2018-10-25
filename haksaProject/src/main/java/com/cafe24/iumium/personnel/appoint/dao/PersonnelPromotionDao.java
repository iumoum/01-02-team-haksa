package com.cafe24.iumium.personnel.appoint.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.personnel.appoint.dto.PersonnelPromotion;


@Repository
public class PersonnelPromotionDao {
private final String NS = "com.cafe24.iumium.personnel.appoint.dao.PersonnelPromotionMapper.";
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	// 승진 입력 처리
	public int savePersonnelPromotion(PersonnelPromotion personnelPromotion) {
		System.out.println("승진 입력 dao호출");
		return sqlSessionTemplate.insert(NS+"addPersonnelPromotion", personnelPromotion);
	}
	
	// 이 밑으로 이응빈 작업
	// 승진처리 리스트 dao
	public List<PersonnelPromotion> personnelPromotionList() {
		System.out.println("승진처리 리스트 dao");
		return sqlSessionTemplate.selectList(NS+"personnelPromotionList");
	}
}
