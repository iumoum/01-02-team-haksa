package com.cafe24.iumium.personnel.code.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iumium.personnel.code.dao.PersonnelCodeDao;
import com.cafe24.iumium.personnel.code.dto.CertificateCode;
import com.cafe24.iumium.personnel.code.dto.CertificatePurposeCode;
import com.cafe24.iumium.personnel.code.dto.PersonnelCommonCode;
import com.cafe24.iumium.personnel.code.dto.RewardPunishmentCode;
import com.cafe24.iumium.personnel.code.dto.TrainingCode;

@Service
@Transactional
public class PersonnelCodeService {
	@Autowired
	private PersonnelCodeDao personnelCodeDao;
	
	// 인사공통코드 리스트 service
	public List<PersonnelCommonCode> selectPersonnelCommonCodeList() {
		System.out.println("인사공통코드 리스트 service");
		return personnelCodeDao.selectPersonnelCommonCodeList();
	}
	
	// 상벌코드 리스트 service 메소드
	public List<RewardPunishmentCode> getrewardPunishmentCode() {
		System.out.println("상벌코드 리스트 service");
		return personnelCodeDao.selectRewardPunishmentCode();
	}
	
	// 연수코드 리스트 service 메소드
	public List<TrainingCode> getTrainingCodeList() {
		System.out.println("연수코드 리스트 service");
		return personnelCodeDao.selectTrainingCode();
	}
	
	// 증명서코드 리스트 service 메소드
	public List<CertificateCode> getCertificateCodeList() {
		System.out.println("증명서코드 리스트 service");
		return personnelCodeDao.selectCertificateCode();
	}
	
	// 증명서용도코드 리스트 service 메소드
	public List<CertificatePurposeCode> getCertificatePurposeCodeList() {
		System.out.println("증명서용도코드 리스트 service");
		return personnelCodeDao.selectCertificatePurposeCode();
	}
}
