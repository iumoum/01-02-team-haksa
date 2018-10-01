package com.cafe24.iumium.commoncode.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.commoncode.dto.BuildingCode;
import com.cafe24.iumium.commoncode.dto.CountryCode;
import com.cafe24.iumium.commoncode.dto.JobGroupCode;
import com.cafe24.iumium.commoncode.dto.JobPositionCode;
import com.cafe24.iumium.commoncode.dto.JobRankCode;
import com.cafe24.iumium.commoncode.dto.JobTypeCode;
import com.cafe24.iumium.commoncode.dto.RoomCode;

@Repository
public class CommonCodeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String nameSpace = "com.cafe24.iumium.commoncode.dao.CommonCodeMapper.";
	
	// 직군 코드 리스트 조회
	public List<JobGroupCode> selectAllJobGroupCodes(){
		return sqlSessionTemplate.selectList(nameSpace + "selectAllJobGroupCodes");
	}
	
	// 직종 코드 리스트 조회
	public List<JobTypeCode> selectAllJobTypeCodes(){
		return sqlSessionTemplate.selectList(nameSpace + "selectAllJobTypeCodes");
	}
	
	// 직급 코드 리스트 조회
	public List<JobRankCode> selectAllJobRankCodes(){
		return sqlSessionTemplate.selectList(nameSpace + "selectAllJobRankCodes");
	}
	
	// 직위 코드 리스트 조회
	public List<JobPositionCode> selectAllJobPositionCodes(){
		return sqlSessionTemplate.selectList(nameSpace + "selectAllJobPositionCodes");
	}
	
	// 건물 코드 리스트 조회
	public List<BuildingCode> selectAllBuildingCodes(){
		return sqlSessionTemplate.selectList(nameSpace + "selectAllBuildingCodes");
	}
	
	// 강의실 코드 리스트 조회
	public List<RoomCode> selectAllRoomCodes(){
		return sqlSessionTemplate.selectList(nameSpace + "selectAllRoomCodes");
	}
	
	// 국가 코드 리스트 조회
	public List<CountryCode> selectAllCountryCodes(){
		return sqlSessionTemplate.selectList(nameSpace + "selectAllCountryCodes");
	}
}
