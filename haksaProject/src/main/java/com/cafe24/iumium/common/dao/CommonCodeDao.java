package com.cafe24.iumium.common.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.common.dto.BuildingCode;
import com.cafe24.iumium.common.dto.CountryCode;
import com.cafe24.iumium.common.dto.DepartmentCode;
import com.cafe24.iumium.common.dto.JobGroupCode;
import com.cafe24.iumium.common.dto.JobPositionCode;
import com.cafe24.iumium.common.dto.JobRankCode;
import com.cafe24.iumium.common.dto.JobTypeCode;
import com.cafe24.iumium.common.dto.RoomCode;
import com.cafe24.iumium.common.dto.TeamCode;
import com.cafe24.iumium.common.dto.OrganizationCode;
import com.cafe24.iumium.common.dto.AgencyCode;

@Repository
public class CommonCodeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String nameSpace = "com.cafe24.iumium.common.dao.CommonCodeMapper.";
	
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
	
	//기관 코드 리스트 조회
	public List<AgencyCode> selectAllAgencyCodes() {
        return sqlSessionTemplate.selectList(nameSpace+"selectAllAgencyCodes");
    }
	
	//기구 코드 리스트 조회
	public List<OrganizationCode> selectAllOrganizationCodes() {
        return sqlSessionTemplate.selectList(nameSpace+"selectAllOrganizationCodes");
    }
	
	//부서 코드 리스트 조회
	public List<DepartmentCode> selectAllDepartmentCodes() {
        return sqlSessionTemplate.selectList(nameSpace+"selectAllDepartmentCodes");
    }
	
	//팀 코드 리스트 조회
	public List<TeamCode> selectAllTeamCodes() {
        return sqlSessionTemplate.selectList(nameSpace+"selectAllTeamCodes");
    }
}
