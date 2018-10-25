package com.cafe24.iumium;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.iumium.lesson.lecture.dto.ChangedTypeOfCompletion;
import com.cafe24.iumium.lesson.lecture.dto.ClassByDepartment;
import com.cafe24.iumium.lesson.lecture.dto.LectureStatus;
import com.cafe24.iumium.lesson.lecture.dto.ProfessorChange;
import com.cafe24.iumium.lesson.lecture.service.LessonLectureService;

@Controller
public class LessonLectureController {
	@Autowired
	private LessonLectureService lessonLectureService;

	// 학과별 반 리스트 조회
	@RequestMapping(value = "/lesson/lecture/classByDepartment", method = RequestMethod.GET)
	public String getAllClassByDepartment(Model model) {

		List<ClassByDepartment> classesByDepartment = lessonLectureService.selectAllClassesByDepartment();
		model.addAttribute("classesByDepartment", classesByDepartment);

		return "lecture/lesson/listClassByDepartment";
	}
	
	// 학과별 반 입력 화면
	@RequestMapping(value = "/lesson/lecture/addClassByDepartment", method = RequestMethod.GET)
	public String classByDepartment() {
		return "lecture/lesson/addClassByDepartment";
	}

	// 강의 상황서 리스트 조회
	@RequestMapping(value = "/lesson/lecture/lectureStatus", method = RequestMethod.GET)
	public String getAllLectureStatus(Model model) {

		List<LectureStatus> LectureStatus = lessonLectureService.selectAllLectureStatus();
		model.addAttribute("list", LectureStatus);

		return "lecture/lesson/listLectureStatus";
	}
	
	// 강의 상황서 입력 화면
	@RequestMapping(value = "/lesson/lecture/addLectureStatus", method = RequestMethod.GET)
	public String lectureStatus() {
		return "lecture/lesson/addLectureStatus";
	}

	// 변경된 강의담당 상황교수 리스트 조회
	@RequestMapping(value = "/lesson/lecture/professorChange", method = RequestMethod.GET)
	public String getAllProfessorChange(Model model) {

		List<ProfessorChange> professorChange = lessonLectureService.selectAllProfessorChange();
		model.addAttribute("list", professorChange);

		return "lecture/lesson/listProfessorChange";
	}

	// 변경된 이수구분 리스트 조회
	@RequestMapping(value = "/lesson/lecture/changedTypeOfCompletion", method = RequestMethod.GET)
	public String getAllChangedTypeOfCompletion(Model model) {

		List<ChangedTypeOfCompletion> changedTypeOfCompletion = lessonLectureService.selectAllChangedTypeOfCompletion();
		model.addAttribute("list", changedTypeOfCompletion);

		return "lecture/lesson/listChangedTypeOfCompletion";
	}
	
	// 과목코드 리스트 조회
	@RequestMapping(value = "/rest/subjectCode", method = RequestMethod.GET)
	public @ResponseBody List<LectureStatus> subjectCode() {
		return lessonLectureService.selectAllSubjectCode();
	}
	
	// 강의실 리스트 조회
	@RequestMapping(value = "/rest/roomCode", method = RequestMethod.GET)
	public @ResponseBody List<LectureStatus> roomCode() {
		return lessonLectureService.selectAllRoomCode();
	}
	
	// 이수구분 리스트 조회
	@RequestMapping(value = "/rest/typeOfCompletionCode", method = RequestMethod.GET)
	public @ResponseBody List<LectureStatus> typeOfCompletionCode() {
		return lessonLectureService.selectAllTypeOfCompletionCode();
	}
}
