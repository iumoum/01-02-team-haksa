package com.cafe24.iumium;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.iumium.common.dto.BuildingCode;
import com.cafe24.iumium.common.dto.CountryCode;
import com.cafe24.iumium.common.dto.JobGroupCode;
import com.cafe24.iumium.common.dto.JobPositionCode;
import com.cafe24.iumium.common.dto.JobRankCode;
import com.cafe24.iumium.common.dto.JobTypeCode;
import com.cafe24.iumium.common.dto.RoomCode;
import com.cafe24.iumium.common.service.CommonCodeService;

@Controller
public class CommonCodeController {
	@Autowired
	private CommonCodeService commonCodeService;
	
	// 직군코드 관리
	@RequestMapping(value="/common/codes/jobGroup", method=RequestMethod.GET)
	public String getAllJobGroubCodes(Model model) {
		List<JobGroupCode> jobGroupCodes = commonCodeService.selectAllJobGroupCodes();
		
		// 직군 코드 model 객체 내부에 저장
		model.addAttribute("jobGroupCodes", jobGroupCodes);
		
		return "commonCode/jobGroupCode";
	}
	
	// 직종코드 관리
	@RequestMapping(value="/common/codes/jobType", method=RequestMethod.GET)
	public String getAllJobTypeCodes(Model model) {
		List<JobTypeCode> jobTypeCodes = commonCodeService.selectAllJobTypeCodes();
		
		// 직종 코드 model 객체 내부에 저장
		model.addAttribute("jobTypeCodes", jobTypeCodes);
		
		return "commonCode/jobTypeCode";
	}
	
	// 직급코드 관리
	@RequestMapping(value="/common/codes/jobRank", method=RequestMethod.GET)
	public String getAllJobRankCodes(Model model) {
		List<JobRankCode> JobRankCodes = commonCodeService.selectAllJobRankCodes();
		
		// 직급 코드 model 객체 내부에 저장
		model.addAttribute("jobRankCodes", JobRankCodes);
		
		return "commonCode/jobRankCode";
	}
	
	// 직위코드 관리
	@RequestMapping(value="/common/codes/jobPosition", method=RequestMethod.GET)
	public String getAllJobPositionCodes(Model model) {
		List<JobPositionCode> jobPositionCodes = commonCodeService.selectAllJobPositionCodes();
		
		// 직위 코드 model 객체 내부에 저장
		model.addAttribute("jobPositionCodes", jobPositionCodes);
		
		return "commonCode/jobPositionCode";
	}
	
	// 건물코드 관리
	@RequestMapping(value="/common/codes/building", method=RequestMethod.GET)
	public String getAllBuildingCodes(Model model) {
		List<BuildingCode> buildingCodes = commonCodeService.selectAllBuildingCodes();
		
		// 건물 코드 model 객체 내부에 저장
		model.addAttribute("buildingCodes", buildingCodes);
		
		return "commonCode/buildingCode";
	}
	
	// 강의실코드 관리
	@RequestMapping(value="/common/codes/room", method=RequestMethod.GET)
	public String getAllRoomCodes(Model model) {
		List<RoomCode> roomCodes = commonCodeService.selectAllRoomCodes();
		
		// 강의실 코드 model 객체 내부에 저장
		model.addAttribute("roomCodes", roomCodes);
		
		return "commonCode/roomCode";
	}
	
	// 국가코드 관리
	@RequestMapping(value="/common/codes/country", method=RequestMethod.GET)
	public String getAllCountryCodes(Model model) {
		List<CountryCode> countryCodes = commonCodeService.selectAllCountryCodes();
		
		// 강의실 코드 model 객체 내부에 저장
		model.addAttribute("countryCodes", countryCodes);
		
		return "commonCode/countryCode";
	}
}
