package com.cafe24.iumium.personnel.appoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iumium.personnel.appoint.dto.PersonnelPromotion;
import com.cafe24.iumium.personnel.appoint.dao.PersonnelPromotionDao;

@Service
@Transactional
public class PersonnelPromotionService {
	@Autowired
	private PersonnelPromotionDao PersonnelPromotionDao;
	
	public int savePersonnelPromotion(PersonnelPromotion personnelPromotion) {
		System.out.println("service호출");
		return PersonnelPromotionDao.savePersonnelPromotion(personnelPromotion);
	}
	
	// 이응빈
	// 승진처리 리스트 service
	public List<PersonnelPromotion> personnelPromotionList() {
		System.out.println("승진처리 리스트 service");
		return PersonnelPromotionDao.personnelPromotionList();
	}
}	
