package com.cafe24.iumium.personnel.code.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.personnel.code.dto.CertificateCode;
import com.cafe24.iumium.personnel.code.dto.CertificatePurposeCode;
import com.cafe24.iumium.personnel.code.dto.PersonnelCommonCode;
import com.cafe24.iumium.personnel.code.dto.RewardPunishmentCode;
import com.cafe24.iumium.personnel.code.dto.TrainingCode;

@Repository
public class PersonnelCodeDao {
	private final String NS = "com.cafe24.iumium.personnel.code.dao.PersonnelCodeMapper.";
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	// 인사공통코드 리스트
	public List<PersonnelCommonCode> selectPersonnelCommonCodeList() {
		System.out.println("인사공통코드 리스트 dao");
		return sqlSessionTemplate.selectList(NS+"personnelCommonCodeList");
	}
	
	// 상벌코드 리스트
	public List<RewardPunishmentCode> selectRewardPunishmentCode() {
		System.out.println("상벌코드 리스트 dao");
		return sqlSessionTemplate.selectList(NS+"selectRewardPunishmentCode");
	}
	
	// 연수코드 리스트
	public List<TrainingCode> selectTrainingCode() {
		System.out.println("연수코드 리스트 dao");
		return sqlSessionTemplate.selectList(NS+"selectTrainingCode");
	}
	
	// 증명서코드 리스트
	public List<CertificateCode> selectCertificateCode() {
		System.out.println("증명서코드 리스트 dao");
		return sqlSessionTemplate.selectList(NS+"selectCertificateCode");
	}
	
	// 증명서용도코드 리스트
	public List<CertificatePurposeCode> selectCertificatePurposeCode() {
		System.out.println("증명서용도코드 리스트 dao");
		return sqlSessionTemplate.selectList(NS+"selectCertificatePurposeCode");
	}
}
