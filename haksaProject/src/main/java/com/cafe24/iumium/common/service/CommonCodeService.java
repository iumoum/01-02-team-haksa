package com.cafe24.iumium.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iumium.common.dao.CommonCodeDao;
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

@Service
@Transactional
public class CommonCodeService {
	@Autowired
	private CommonCodeDao commonCodeDao;
	
	// 모든 직군 코드 리스트
	public List<JobGroupCode> selectAllJobGroupCodes(){ 
		return commonCodeDao.selectAllJobGroupCodes();
	}
	
	// 모든 직종 코드 리스트
	public List<JobTypeCode> selectAllJobTypeCodes(){ 
		return commonCodeDao.selectAllJobTypeCodes();
	}
	
	// 모든 직급 코드 리스트
	public List<JobRankCode> selectAllJobRankCodes(){ 
		return commonCodeDao.selectAllJobRankCodes();
	}
	
	// 모든 직위 코드 리스트
	public List<JobPositionCode> selectAllJobPositionCodes(){ 
		return commonCodeDao.selectAllJobPositionCodes();
	}
	
	// 모든 건물 코드 리스트
	public List<BuildingCode> selectAllBuildingCodes(){ 
		return commonCodeDao.selectAllBuildingCodes();
	}
	
	// 모든 강의실 코드 리스트
	public List<RoomCode> selectAllRoomCodes(){ 
		return commonCodeDao.selectAllRoomCodes();
	}
	
	// 모든 국가 코드 리스트
	public List<CountryCode> selectAllCountryCodes(){ 
		return commonCodeDao.selectAllCountryCodes();
	}
	
	// 모든 기관 코드 리스트
	public List<AgencyCode> selectAllAgencyCodes() {
        return commonCodeDao.selectAllAgencyCodes();
    }
	
	// 모든 기구 코드 리스트
	public List<OrganizationCode> selectAllOrganizationCodes() {
        return commonCodeDao.selectAllOrganizationCodes();
    }
	
	// 모든 부서 코드 리스트 
	public List<DepartmentCode> selectAllDepartmentCodes() {
        return commonCodeDao.selectAllDepartmentCodes();
	}
	
	// 모든 팀 코드 리스트
	public List<TeamCode> selectAllTeamCodes(){
		return commonCodeDao.selectAllTeamCodes();
	}
	
}
