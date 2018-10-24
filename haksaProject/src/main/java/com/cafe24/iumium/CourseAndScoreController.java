package com.cafe24.iumium;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.iumium.courseandscore.dto.EnrolCourse;
import com.cafe24.iumium.courseandscore.dto.InsertScore;
import com.cafe24.iumium.courseandscore.service.CourseAndScoreService;

@Controller
public class CourseAndScoreController {
	
	@Autowired
	private CourseAndScoreService courseAndScoreService;
	
	/*1.세션에서 학번을 입력받아 수강 신청가능 과목을 조회하여 표로 출력해주는 메소드
	 * 입력 값 = 세션 값, 반환 값 = view 페이지명 문자열
	*/
	
	@RequestMapping(value="/courseAndScore/enrolCourse")
	public String enrolCourseList(Model model, HttpSession session) {
		System.out.println("CourseAndScoreController - enrolCourse() 호출");
		String id = null;
		String userLevel = null;
		
		//세션 아이디 값이 있을 시 id 문자열 변수에 대입
		if(session.getAttribute("userId") != null) {
			id = (String)session.getAttribute("userId");
		}
		System.out.println("session ID : " + id);
		
		if(session.getAttribute("userLevel") != null) {
			userLevel = (String)session.getAttribute("userLevel");
		}
		System.out.println("session userLevel : " + userLevel);
		
		/*
		 *  수강신청 목록 조회 서비스 메소드 호출
		 *  입력 값 = id, 반환 값 = EnrolCourse 타입 리스트
		 */
		List<EnrolCourse> enrolCourse = courseAndScoreService.selectEnrolCourse(id,userLevel);
		
		List<EnrolCourse> enrolCourseList = courseAndScoreService.selectEnrolCourseList(id);
		
		// 모델 객체에 반환 값과 세션 id 저장
		model.addAttribute("enrolCourse", enrolCourse);
		model.addAttribute("enrolCourseList", enrolCourseList);
		model.addAttribute("id", id);
		
		return "lecture/courseAndScore/addEnrolCourse";
	}
	/*
	 * 1-1 선택된 과목의 행 정보를 모두 전달하는 배열 값을 받아서 수강신청 테이블에 입력
	 */
	@RequestMapping(value="/courseAndScore/addEnrolCourse", method= {RequestMethod.POST, RequestMethod.GET})
	public String EnrolCourse (HttpServletRequest request) {
		
		String lectureStatusNumber = request.getParameter("lectureStatusNumber") == null?"":request.getParameter("lectureStatusNumber");
		String id = request.getParameter("id") == null?"":request.getParameter("id");
		String enrolCourseCourseName = request.getParameter("enrolCourseCourseName") == null?"":request.getParameter("enrolCourseCourseName");
		String enrolCourseCompletionDivision = request.getParameter("enrolCourseCompletionDivision") == null?"":request.getParameter("enrolCourseCompletionDivision");
		String enrolCourseCourseCredit = request.getParameter("enrolCourseCourseCredit") == null?"":request.getParameter("enrolCourseCourseCredit");
		String enrolCourseDeptName = request.getParameter("enrolCourseDeptName") == null?"":request.getParameter("enrolCourseDeptName");
		String enrolCourseSchoolYear = request.getParameter("enrolCourseSchoolYear") == null?"":request.getParameter("enrolCourseSchoolYear");
		String enrolCourseClass = request.getParameter("enrolCourseClass") == null?"":request.getParameter("enrolCourseClass");
		String enrolCourseProfName = request.getParameter("enrolCourseProfName") == null?"":request.getParameter("enrolCourseProfName");
		String enrolCourseClassroom = request.getParameter("enrolCourseClassroom") == null?"":request.getParameter("enrolCourseClassroom");
		String enrolCourseYear = request.getParameter("enrolCourseYear") == null?"":request.getParameter("enrolCourseYear");
		String enrolCourseSemester = request.getParameter("enrolCourseSemester") == null?"":request.getParameter("enrolCourseSemester");
		
		System.out.println("lectureStatusNumber에 담긴 데이터 확인 = " + lectureStatusNumber);
		
		Map<String, String> enrolCourse = new HashMap<String, String>();
		
		enrolCourse.put("lectureStatusNumber", lectureStatusNumber);
		enrolCourse.put("id", id);
		enrolCourse.put("enrolCourseCourseName", enrolCourseCourseName);
		enrolCourse.put("enrolCourseCompletionDivision", enrolCourseCompletionDivision);
		enrolCourse.put("enrolCourseCourseCredit", enrolCourseCourseCredit);
		enrolCourse.put("enrolCourseDeptName", enrolCourseDeptName);
		enrolCourse.put("enrolCourseSchoolYear", enrolCourseSchoolYear);
		enrolCourse.put("enrolCourseClass", enrolCourseClass);
		enrolCourse.put("enrolCourseProfName", enrolCourseProfName);
		enrolCourse.put("enrolCourseClassroom", enrolCourseClassroom);
		enrolCourse.put("enrolCourseYear", enrolCourseYear);
		enrolCourse.put("enrolCourseSemester", enrolCourseSemester);
		
		System.out.println("map에 담긴 데이터 확인 = " + enrolCourse.get("lectureStatusNumber"));
		
		courseAndScoreService.addEnrolCourse(enrolCourse);
		
		System.out.println("입력 할 강의 계획서 번호 = " + lectureStatusNumber);
		
		return "redirect:/courseAndScore/enrolCourse";
	}
	/*
	 * 1-2 선택된 과목의 수강신청 번호를 입력하여 수강신청 내역 삭제
	 */
	@RequestMapping(value="/courseAndScore/deleteEnrolCourse", method= {RequestMethod.POST, RequestMethod.GET})
	public String deleteEnrolCourse (HttpServletRequest request) {
		
		String[] arr = request.getParameterValues("lectureStatusNumber");
		
		Map<String,String> lectureStatusNumberArr = new HashMap<String,String>();
		
		for(int i=0;i<arr.length;i++) {
			lectureStatusNumberArr.put("arr["+i+"]", arr[i]);
		}
		
		System.out.println("삭제할 수강 신청 내역 번호 = " + lectureStatusNumberArr.get("arr[0]"));
		
		courseAndScoreService.deleteEnrolCourse(lectureStatusNumberArr);
		
		return "redirect:/courseAndScore/enrolCourse";
	}
	
	/*
	 *	2.수강 신청된 과목정보를 입력된 학번을 통해서 조회하는 메소드 
	 *	입력 값 = 학번, 반환 값 = 과목 정보의 리스트 객체, 뷰 이름이 담긴 ModelAndView 객체
	 */
	
	@RequestMapping(value="/courseAndScore/searchCourse", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView searchCourse(ModelAndView mv, HttpServletRequest request) {
		System.out.println("CourseAndScoreController - searchCourse() 호출");
		String option = null;
		String value = null;
		
		if(request.getParameter("option") == null) {
			option = "studentnumber";
		} else {
			option = request.getParameter("option");
		}
		
		if(request.getParameter("value") == null) {
			value = "";
		} else {
			value = request.getParameter("value");
		}
		
		String[] array = new String[2];
		array[0] = option;
		array[1] = value;
		
		System.out.println("array[0] 출력 : " + array[0]);
		System.out.println("array[1] 출력 : " + array[1]);
		
		List<EnrolCourse> enrolCourse = courseAndScoreService.searchEnrolCourse(array);
		
		mv.addObject("enrolCourse", enrolCourse);
		mv.setViewName("/lecture/courseAndScore/listSearchCourse");

		return mv;
	}
	
	/*
	 * 3. 교수의 세션id를 검색하여 담당 과목을 조회 하고 과목 정보의 리스트를 불러온다. 
	 */
	
	@RequestMapping(value="/courseAndScore/enrolScoreCourseList")
	public String enrolScoreCourseList(Model model, HttpSession session) {
		
		System.out.println("CourseAndScoreController - enrolScoreCourseList() 호출");
		String id = null;
		String level = null;
		
		if(session.getId() != null) {
			id = (String)session.getAttribute("userId");
			level = (String)session.getAttribute("userLevel");
		}
		
		System.out.println("session ID : " + id);
		System.out.println("session LEVEL : " + level);
		
		List<InsertScore> insertScore = courseAndScoreService.searchEnrolScoreCourseList(id, level);
		
		model.addAttribute("insertScore", insertScore);
		model.addAttribute("id", id);
		
		return "lecture/courseAndScore/listEnrolScoreCourse";
	}
	
	/*
	 * 4. 교수의 강의 과목명을 입력하여 과목을 수강하는 학생들의 정보가 담긴 리스트가 조회된다.
	 * 
	 */
	
	@RequestMapping(value="/courseAndScore/enrolScore" , method= {RequestMethod.POST, RequestMethod.GET})
	public String enrolScoreCourse(Model model, HttpServletRequest request) {
		System.out.println("CourseAndScoreController - enrolScoreCourse() 호출");
		
		String subjectName = (String)request.getParameter("subject");
		
		List<EnrolCourse> enrolCourse = courseAndScoreService.searchEnrolScoreCourse(subjectName);
		
		//강의 정보도 같이 전송해야 하므로 컨트롤러에서 처리해야 함.
		//model.addAttribute("EnrolCourse",EnrolCourse);
		model.addAttribute("enrolCourse", enrolCourse);
		
		return "/lecture/courseAndScore/addEnrolScore";
	}
	
	/*
	 * 5. 반별 석차 조회 서비스 메소드 호출
	 */
	
	@RequestMapping(value="/courseAndScore/printScoreRankInClass", method= {RequestMethod.POST, RequestMethod.GET})
	public String printScoreCourseByClass(Model model, HttpServletRequest request) {
		System.out.println("CourseAndScoreController - EnrolScoreCourseByClass() 호출");
		
		String ClassName = null;
		
		if(request.getParameter("ClassName") != null) {
			ClassName = (String)request.getParameter("ClassName");
		}
		
		List<EnrolCourse> enrolCourse = courseAndScoreService.searchEnrolScoreCourseByClass(ClassName);
		
		model.addAttribute("enrolCourse", enrolCourse);
		
		
		return "lecture/courseAndScore/listScoreRankInClass";
	}
	/*
	 * 6.학과별 석차 조회 서비스 메소드 호출
	 */
	@RequestMapping(value="/courseAndScore/printScoreRankInDept", method= {RequestMethod.POST, RequestMethod.GET})
	public String printScoreCourseByDept(Model model, HttpServletRequest request) {
		
		String DeptName = null;
		
		if(request.getParameter("DeptName") != null) {
			DeptName = (String)request.getParameter("DeptName");
		}
		
		List<EnrolCourse> enrolCourse = courseAndScoreService.searchprintScoreCourseByDept(DeptName);
		
		model.addAttribute("enrolCourse", enrolCourse);
		
		return "lecture/courseAndScore/listScoreRankInDept";
	}
	
}
